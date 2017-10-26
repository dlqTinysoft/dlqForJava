package hpu.edu.cn;

import java.util.ArrayList;

/**
 * Created by 董乐强 on 2017/10/25.
 * 链栈的实现
 */
public class LinkedStack<T> {

    private static class Node<T>{
          //用于存储下一个节点的地址
          Node<T> next;
          T data;
          public Node(T data, Node<T> next){
              this.data = data;
              this.next = next;
          }
    }
    //栈中元素的个数
    private int size;
    //栈顶指针
    private Node<T> top;

    //元素进栈
    public void push(T data){
        top = new Node(data,top);
        size++;
    }

    //元素出栈
    public  T top(){
        T data = null;
        if(top == null){
            throw new RuntimeException("Stack is Empty , not be able to top!!");
        }
        Node<T> temp = top;
        data = top.data;
        top = top.next;
        temp = null;
        size--;
        return data;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return size ==0 ;
    }

    //栈中元素个数
    public int getSize(){
        return size;
    }

    //得到栈顶元素
    public  T getTop(){
        T data = null;
        if(top==null)
            throw new RuntimeException("Stack is Empty ");
        data = top.data;
        return data;
    }

    //清空栈
    public void clear(){
        top = null;
    }

    private  class StackIterator<T> implements MyIterator<T>{
        Node<T> temp =(Node<T>) top;
        public boolean hasNext(){
            return temp!=null;
        }
        public T next(){
            T data = (T)temp.data;
            temp= temp.next;
            return data;
        }
    }
    //遍历栈中的所有元素
    public MyIterator<T> getIterator(){
        return new StackIterator<T>();
    }
}
