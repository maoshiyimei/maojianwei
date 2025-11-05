package com.maji.maojianwei.leetcode.java_language.java8;

import java.util.Optional;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/28 , 15:59
 */
public class OptionalDemo {
    public static void main(String[] args){
        Optional<String> optional1 = Optional.of("maji");
        System.out.println(optional1.get());
        Optional optional2 = Optional.empty();

        System.out.println(optional2.orElseGet(()->" love alin forever "));
        System.out.println( optional2.orElse("love alin "));
        System.out.println( optional1.filter( (value)-> value.length()>=5));
        System.out.println( optional1.map((value)->value.toUpperCase()));

    }



 }
