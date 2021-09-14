package com.demo;


import com.demo.entity.User;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.ls.LSOutput;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestUser {

    @Test
    public void test1(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello,world!");
            }
        };
        runnable.run();
        System.out.println("-----------------------");

        Runnable r1 = ()-> System.out.println("hellowordl1");
        r1.run();
    }

    @Test
    public void test3(){
        happy(1000,(m)-> System.out.println("消费了多少"+m+"元"));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
    public List<Integer> getNumber(int num, Supplier<Integer> sup){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i <num ; i++) {
            Integer integer = sup.get();
            integers.add(integer);
        }
        return integers;

    }
    @Test
    public void test4(){
        List<Integer> number = getNumber(10, () -> (int)( Math.random() * 100));
        for (Integer i:number
             ) {
            System.out.println(i);
        }

    }

    @Test
    public void test7(){

        User user = new User();
        Supplier<String> emp = ()->user.getUsername();
        String s = emp.get();
        System.out.println(s);

        Supplier<String> rmp = user::getPassword;
        String s1 = rmp.get();
        System.out.println(s1);

    }
    /**
     * 构造器引用
     */
    @Test
    public void test8(){
        Supplier<User> emp = () ->new User();

        //构造器引用方式
        Supplier<User> ump = User::new;
        User user = ump.get();
        System.out.println(user);
    }

    @Test
    public void test10(){
        Stream<Integer> stream = Stream.iterate(0,(x)->x+2);
        stream.forEach(System.out::println);

        ArrayList<String> users = new ArrayList<>();
        Stream<String> stream1 = users.stream();

        User[] is = new User[10];
        Stream<User> stream2 = Arrays.stream(is);

        Stream<String> aa = Stream.of("aa", "bb", "vv");



    }
}
