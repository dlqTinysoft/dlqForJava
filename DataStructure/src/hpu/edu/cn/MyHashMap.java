package hpu.edu.cn;

/**
 * Created by 董乐强 on 2017/10/25.
 * 数据结构，Hash表的实现
 */
public class MyHashMap<K,V> {

    //hash表的初始容量
    private final static int INIT_CAPACITY = 16;
    //装载因子
    private final static float load_factor =0.75f;
    //表，存储元素的个数
    private int size;
    //表，用于key-value数据
    private Entry<K,V> [] table;
    //初始化表的容量
    public MyHashMap(){
        table = new Entry[INIT_CAPACITY];
    }

    private static class Entry<K,V>{
            Entry<K,V> next;
            K k;
            V v;
            public Entry(K k, V v , Entry<K,V> next){
                this.k = k;
                this.v = v;
                this.next = next;
            }
    }

    //往hash表中添加元素
    public boolean put(K k,V v){
        //每一个k都有一个唯一的hashCode
        int key = k.hashCode();
        //通过hash希函数得到在hash表中存储位置
        int index = key & table.length-1;
        //得到这个位置的Entry对象
        Entry<K,V> entry = table[index];
        //如果这个位置为null,则直接存入元素
        if(entry==null){
            entry = new Entry<K,V>(k,v,null);
            table[index]=entry;
            size++;
            return true;
        }else{
            //如果对象的内容也相等，必须重写hashCode()
            Entry<K,V> temp;
            temp=entry;
            while(temp!=null){
                  int oldKey = temp.k.hashCode();
                  if(oldKey == key){
                      temp.v=v;
                      break;
                  }
                  temp = temp.next;
           }
           //链表中不存在相同的Entry对象,则将新Entry存入hash表中
           if(temp ==null) {
               table[index] = new Entry<K, V>(k, v, entry);
               size++;
           }
        }
        return true;
    }

    //从hash表中通过key取出对应的value
    public V getValue(K k){
        V value = null;
        int key = k.hashCode();
        int index = key & table.length-1;
        //取出entry对象
        Entry<K,V> entry = table[index];

        while(entry!=null){
            int oldKey = entry.k.hashCode();
            if(oldKey == key){
               value = entry.v;
               break;
            }
            entry = entry.next;
        }

        if(entry == null)
           throw new RuntimeException("key is not exist or key is  null!!") ;
        return value;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size ==0;
    }
    //遍历Hash表的key
    private class MapKeyIterator<K> implements MyIterator<K>{
        int temp_index=0;
        Entry<K,V> temp_entry = (Entry<K, V>) table[temp_index];

        @Override
        public boolean hasNext() {
            return temp_index != table.length-1 ;
        }

        @Override
        public K next() {
            K temp_k = null;
            if(temp_entry!=null){
                temp_k = temp_entry.k;
                temp_entry = temp_entry.next;
                return temp_k;
            }else{
                while(temp_entry == null && temp_index != table.length-1)
                    temp_entry =(Entry<K, V>) table[++temp_index];
                //这个地方有个bug,最后一个位置元素为空，怎么处理 待解决
                if (temp_entry == null)
                    return temp_k;

                temp_k = temp_entry.k;
                temp_entry = temp_entry.next;
                return temp_k;
            }
        }
    }

    public MyIterator<K> getKeyIterator(){
        return new MapKeyIterator<K>();
    }
}
