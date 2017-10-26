package hpu.edu.cn;

/**
 * Created by 董乐强 on 2017/10/26.
 */
public class CircularQueue<T> {
    //队列中元素个数
    private int size;
    //默认初始容量
    private static final int DEFAULT_SIZE = 16;
    //存储队列元素
    private Object [] objects;
    //队头指针
    private int head;
    //队尾指针
    private int tail;

    public CircularQueue(){
        objects = new Object[DEFAULT_SIZE];
    }
    public CircularQueue(int init_size){
        objects = new Object[init_size];
    }

    //进队操作
    public void enQueue(T data){
        //队满不能够进队
        if((tail+1)%objects.length == head)
            throw new RuntimeException("Queue is full, do not enQueue");
        objects[tail]=data;
        tail = (tail+1)%objects.length;
        size++;
    }

    //出队操作
    public T deQueue(){
        T data;
        //队空不能够出队
        if(head == tail)
            throw new RuntimeException("Queue is Empty, do not deQueue!!");
        data = (T)objects[head];
        head = (head+1)%objects.length;
        size--;
        return data;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return size ==0 ;
    }

    //得到队列中的元素个数
    public int getSize(){
        return size;
    }

    //遍历集合，得到集合中的元素
    private class QueueIterator<T> implements MyIterator<T>{
        int temp_head = head;
        int temp_tail = tail;
        @Override
        public boolean hasNext() {
            return temp_tail!= temp_head;
        }

        @Override
        public T next() {
            T data = (T) objects[temp_head];
            temp_head = (temp_head+1)%objects.length;
            return data;
        }
    }

    public MyIterator<T> getIterator(){
        return new QueueIterator<T>();
    }
}
