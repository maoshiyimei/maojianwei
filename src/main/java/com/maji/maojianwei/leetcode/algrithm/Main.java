package com.maji.maojianwei.leetcode.algrithm;

import java.util.*;

public class Main {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
    static int string2int(String str) {
        int len = str.length();
        int i =0;
        int flag = 1;
        int pos =len-1;
        int dot =0;
        if(str.charAt(0) == '-'){
            flag =0;
            i++;
        }
        if(str.charAt(0) == '+'){
            flag=2;
            i++;
        }
        if(str.charAt(0) == '.'){
            return 0;
        }
        for(;i<len;i++){
            if(str.charAt(i)=='.'){
                if(dot<1){
                    dot++;
                    pos=i-1;
                }
                else{
                    return 0;
                }
            }
            else if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                return 0;
            }
        }
        int result =0;
        if(flag !=1){
            for(i =1;i<=pos;i++){
                result = result*10+(int)(str.charAt(i)-'0');
            }
            if(flag ==0)
            	result = 0-result;
        }
        else{
            for(i =0;i<=pos;i++){
                result = result*10+(int)(str.charAt(i)-'0');
            }
        }
        return result;


    }
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
            
        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }
  
        res = string2int(_str);
        System.out.println(String.valueOf(res));    

    }
}
