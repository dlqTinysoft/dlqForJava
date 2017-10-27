package hpu.edu.cn;

/**
 * Created by 董乐强 on 2017/10/27.
 * 归并排序和快速排序算法实现
 */
public class Sort {


    public Object [] mergerSort(Object [] datas){


        return null;
    }
    //快速排序
    public int [] repaidSort(int [] datas){
        int i = 0;
        int j=datas.length-1;
        repaidSort_pivot(i,j,datas);
        return datas;
    }
    //寻找枢轴
    private void repaidSort_pivot(int left, int right,int[] datas){
         int begin = left;
         int end = right;
         if(begin>end)
             return ;
         int pivot = datas[begin];
         int temp = 0;
         while(begin<end){
            while(true) {
                if (end == begin || datas[end] < pivot)
                    break;
                end--;
            }
             while(true) {
                 if (begin == end || datas[begin] > pivot)
                     break;
                 begin++;
             }
             if(begin==end){
                temp=datas[end];
                datas[end]=pivot;
                datas[left]=temp;
                break;
             }
             temp = datas[end];
             datas[end] = datas[begin];
             datas[begin] = temp;
         }
         repaidSort_pivot(left,end-1,datas);
         repaidSort_pivot(end+1,right,datas);
    }
}
