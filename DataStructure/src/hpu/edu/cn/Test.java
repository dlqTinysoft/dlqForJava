package hpu.edu.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by 董乐强 on 2017/10/25.
 */
public class Test {
    public static void main(String [] args){
        Person person1 = new Person(1,"张三",21);
        Person person2 = new Person(2,"李四",21);
        Person person3 = new Person(3,"王五",21);
        Person person4 = new Person(4,"赵六",21);
        Person person5 = new Person(5,"田七",21);
        MyHashMap<Person,String> persons = new MyHashMap<Person,String>();
        persons.put(person1,"张三");
        persons.put(person2,"李四");
        persons.put(person3,"王五");
        persons.put(person4,"赵六");
        persons.put(person5,"田七");
        //使用迭代器来遍历栈
        MyIterator<Person> iterator = persons.getKeyIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
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