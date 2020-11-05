package com.kavy.rookiespringbootredis.util;

import com.kavy.rookiespringbootredis.bean.Person;

import java.util.Arrays;
import java.util.Comparator;

public class TestPreson {
    public static void main(String[] args) {

        Person [] arr ={
                new Person("娜娜",18),
                new Person("张总",28),
                new Person("罗布",15),
                new Person("罗4布",13)
        };
    /*    Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge()-o1.getAge();
            }
        });*/

        Arrays.sort(arr,( o1, o2)-> o1.getAge()-o2.getAge()
        );

        for (Person person : arr) {
            String name = person.getName();
            int age = person.getAge();
            System.out.println(name+"->"+age);
        }
    }


}
