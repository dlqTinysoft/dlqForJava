package com.tinysoft.cn.service;

import com.tinysoft.cn.dao.*;
import com.tinysoft.cn.domain.*;
import com.tinysoft.cn.util.UtilFuns;
import com.tinysoft.cn.vo.ContractProductVO;
import com.tinysoft.cn.vo.ContractVO;
import com.tinysoft.cn.vo.ExtProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 董乐强 on 2017/11/10.
 */
@Service
public class ExportServiceImpl extends BaseServiceImpl<Export> implements  ExportService {

    @Resource
    private ExportDao exportDao;

    @Resource
    private ContractDao contractDao;

    @Resource
    private ContractProductDao contractProductDao;

    @Resource
    private ExportProductDao exportProductDao;

   @Resource
   private ExtProductDao extProductDao;

   @Resource
   private ExtEProductDao extEProductDao;



    public List<Export> find(Map map) {
        super.set(exportDao);
        List<Export> exports = exportDao.find(null);
        return exports;
    }

    //这个插入操作部分，还是有点难度，业务逻辑还是挺复杂的
    //一个报运来自于多个合同，一个合同又包括多个货物，一个货物包括多个附件
    public void insert(String[] contractIds) {
        //产生一个报运的id
        String exportId = UUID.randomUUID().toString();
        Export export = new Export();
        export.setId(exportId);
        export.setState(0);
        //将合同的id拼接到后面，用逗号隔开
        export.setContractIds(UtilFuns.joinStr(contractIds,","));
        //将合同号发到报运单，注意这里面的合同号可以有多个，因为一次可以报运可以报运多个合同，一个合同也可以分批次进行报运
        StringBuffer _contractNos=new StringBuffer();

        //通过合同，来获的合同号
        for(int i =0 ; i<contractIds.length;i++){
            ContractVO contract = contractDao.getView(contractIds[i]);
            _contractNos.append(contract.getContractNo()).append(" ");
        }

        //设置报运单的合同号
        export.setCustomerContract(_contractNos.toString());
        exportDao.insert(export);

        //将合同中的所有信息进行搬家，数据库的打断设计，这里面就实现了跳跃查询，加快速度
        //通过合同的id去查货物表，数据库打断设计，实现跳跃式查询

        for(int i = 0 ; i<contractIds.length;i++){
            //直接，查出加快速度，不用再次从数据库表中进行查询,明显提高效率
            ContractVO contract = contractDao.getView(contractIds[i]);
            //得到合同下的所有货物
            for(ContractProductVO contractProduct:contract.getContractProducts()){

                  ExportProduct exportProduct = new ExportProduct();
                  exportProduct.setId(UUID.randomUUID().toString());
                  //注意，不能忘，必须绑定外键
                  exportProduct.setExportId(export.getId());
                  if(contractProduct.getFactory()!=null) {
                      exportProduct.setFactoryId(contractProduct.getFactory().getId());
                      exportProduct.setFactoryName(contractProduct.getFactory().getFactoryName());
                  }
                  exportProduct.setProductNo(contractProduct.getProductNo());
                  exportProduct.setPackingUnit(contractProduct.getPackingUnit());
                  exportProduct.setCnumber(contractProduct.getCnumber());
                  exportProduct.setBoxNum(contractProduct.getBoxNum());
                  exportProduct.setPrice(contractProduct.getPrice());
                  exportProductDao.insert(exportProduct);

                  //处理附件信息
                  for(ExtProductVO extProductVO:contractProduct.getExtProducts()){
                      ExtEProduct extEProduct = new ExtEProduct();
                      BeanUtils.copyProperties(extProductVO,extEProduct);
                      extEProduct.setId(UUID.randomUUID().toString());
                      extEProduct.setExportProductId(exportProduct.getId());
                      if(extProductVO.getFactory()!=null) {
                          extEProduct.setFactoryId(extProductVO.getFactory().getId());
                          extEProduct.setFactoryName(extProductVO.getFactory().getFactoryName());
                      }
                      extEProductDao.insert(extEProduct);
                  }
            }
        }
    }

    //报运单的状态 上报
    public void submit(Serializable[] ids) {
        Map<String ,Object> map = new HashMap<String ,Object>();
        map.put("state",1);
        map.put("ids",ids);
        exportDao.updateState(map);
    }
    //取消上报
    public void cancel(Serializable[] ids) {
      Map<String,Object> map = new HashMap<String,Object>();
      map.put("state",0);
      map.put("ids",ids);
      exportDao.updateState(map);
    }
    //批量修改
    public void update(Export export,
                       String[] mr_id,
                       Integer[] mr_orderNo,
                       Integer[] mr_cnumber,
                       Double[] mr_grossWeight,
                       Double[] mr_netWeight,
                       Double[] mr_sizeLength,
                       Double[] mr_sizeWidth,
                       Double[] mr_sizeHeight,
                       Double[] mr_exPrice,
                       Double[] mr_tax,
                       Integer[] mr_changed) {

        exportDao.update(export);
        //因为是动态表格，所以只有用户修改的行，才进行新增
        for(int i = 0 ; i<mr_id.length;i++) {
            if (mr_changed[i]!=null && mr_changed[i]==1) {
                ExportProduct exportProduct = exportProductDao.get(mr_id[i]);
                exportProduct.setOrderNo(mr_orderNo[i]);
                exportProduct.setCnumber(mr_cnumber[i]);
                exportProduct.setGrossWeight(mr_grossWeight[i]);
                exportProduct.setNetWeight(mr_netWeight[i]);
                exportProduct.setSizeLength(mr_sizeLength[i]);
                exportProduct.setSizeWidth(mr_sizeWidth[i]);
                exportProduct.setSizeHeight(mr_sizeHeight[i]);
                exportProduct.setExPrice(mr_exPrice[i]);
                exportProduct.setTax(mr_tax[i]);
                exportProductDao.update(exportProduct);
            }
        }
    }

    //得到已上报的所有购销合同列表
    public List<Contract> getContractList() {
        Map<String , Integer> map = new HashMap<String,Integer>();
        //1表示已经上报的购销合同
        map.put("state",1);
        List<Contract> contracts = contractDao.find(map);
        return contracts;
    }

    //用来拼接js字符串，这个地方，也不是太理解，尤其是动态表格，批量插入这一块，感觉基础还是很薄弱，好好把js认真看一下
    public String getMrecordData(String exportId) {

        Map map = new HashMap<String ,Object>();
        map.put("exportId",exportId);
        List<ExportProduct> oList = exportProductDao.find(map);
        StringBuffer sBuf = new StringBuffer();
        for(ExportProduct ep : oList){
            sBuf.append("addTRRecord(\"mRecordTable\", \"").append(ep.getId()).append("\", \"").append(ep.getProductNo()).append("\", \"").append(ep.getCnumber()).append("\", \"").append(UtilFuns.convertNull(ep.getGrossWeight())).append("\", \"").append(UtilFuns.convertNull(ep.getNetWeight())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeLength())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeWidth())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeHeight())).append("\", \"").append(UtilFuns.convertNull(ep.getExPrice())).append("\", \"").append(UtilFuns.convertNull(ep.getTax())).append("\");");
        }
        return sBuf.toString();
    }

    //级联删除,先删除报运下货物，然后删除附件，然后删除该条报运记录
    @Override
    public void delete(Serializable[] ids) {
        for(int i = 0 ; i<ids.length;i++){
            //删除报运下的附件
           extEProductDao.deleteByExportId(ids[i]);
        }

        for(int i = 0 ; i<ids.length;i++){
            //删除报运下的货物
           exportProductDao.deleteByExportId(ids[i]);
        }
    }
}
