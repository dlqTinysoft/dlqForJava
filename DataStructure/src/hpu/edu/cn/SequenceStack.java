package hpu.edu.cn;

/**
 * Created by 董乐强 on 2017/10/25.
 * 顺序栈的实现
 */
public class SequenceStack<T> {
    //栈中元素的个数
    private int size;
    //栈的初始大小
    private static final int DEFAULT_SIZE =16;
    //存放元素的数值
    private Object [] objects ;
    //栈顶指针
    int top=0;
    public SequenceStack(){
        objects = new Object[DEFAULT_SIZE];
    }
    public SequenceStack(int stack_size){
        objects = new Object[stack_size];
    }

    //元素进栈
    public void push(T data){
        //栈满，不能够进栈
        if(objects.length == size)
            throw new RuntimeException("Sequence is full , do not push!!");
        objects[top++]=data;
        size++;
    }

    //出栈操作
    public T top(){
        //如果栈空，则不能够出栈
        if(size ==0 )
            throw new RuntimeException("Sequence is Empty ,do not top!!");
        size--;
        return (T)objects[--top];
    }

    //得到栈顶元素]
    public T getTop(){
        //栈不空，则可以得到栈顶元素
        if(size ==0 )
            throw new RuntimeException("Sequence is Empty ,do not getTop!!");
        int temp = top;
        return (T)objects[--temp];
    }

    //获得栈中元素个数
    public int  getSize(){
        return size;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return size ==0 ;
    }
    //遍历栈的所有元素
    public class StackIterator<T> implements MyIterator<T>{

        int temp = top;
        @Override
        public boolean hasNext() {
            return temp!=0;
        }

        @Override
        public T next() {
            T data = (T)objects[--temp];
            return data;
        }
    }

    public MyIterator<T> getIterator(){
        return new StackIterator<T>();
    }
}
