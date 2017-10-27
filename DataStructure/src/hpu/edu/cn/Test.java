package hpu.edu.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

/**
 * Created by 董乐强 on 2017/10/25.
 */
public class Test {
    public static void main(String [] args){
        Random random = new Random();
        int [] datas = new int[]{1,8,9,5,15,2,89};
         Sort sort = new Sort();
         sort.repaidSort(datas);
        for(int j = 0 ; j<datas.length;j++)
            System.out.print(datas[j]+",");
    }
}

class Person{

    private int id;
    private String name;
    private int age;
    public Person(int id, String name , int age){
        this.age = age;
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "姓名:"+name+"--"+"年龄:"+age;
    }
}