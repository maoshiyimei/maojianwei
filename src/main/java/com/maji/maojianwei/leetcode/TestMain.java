package com.maji.maojianwei.leetcode;

public class TestMain {

    public static void main(String[] args){
        System.out.println("hello , dog");
    }


//    String solution(String[] strs) {
//        List<char[]> letters = new ArrayList<>();
//        for(String str : strs){
//            letters.add(str.toCharArray());
//        }
//
//        StringBuilder resStr = new StringBuilder();
//        int idx = 0;
//        while(true){
//            char curLetter = '*';
//            int i = 0;
//            for(; i < letters.size(); i++){
//                if(idx >= letters.get(i).length){
//                    return resStr.toString();
//                }
//
//                if(i == 0){
//                    curLetter = letters.get(i)[idx];
//                    continue;
//                }
//                if(letters.get(i)[idx] == curLetter){
//                    continue;
//                } else {
//                    return resStr.toString();
//                }
//            }
//            if( i == letters.size()-1){
//                resStr.append(curLetter);
//                idx++;
//            }
//
//        }
//
//    }

}
