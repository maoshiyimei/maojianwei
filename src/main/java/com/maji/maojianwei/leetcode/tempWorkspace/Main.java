package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.*;
public class Main{
    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABD";
        Set<Character> letters = new HashSet<>();
        for( int i = 0 ;i < t.length() ;i++ ){
            letters.add(t.charAt(i));
        }
        int minStart = 0 ;
        int maxEnd = s.length();
        Map<Character, Integer> record = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            char letter = s.charAt(i);
            if( letters.contains( letter ) ){
                record.put( letter, i);
                if( record.size() == letters.size() ){
                    int tempStart = Integer.MAX_VALUE;
                    int tempEnd = Integer.MIN_VALUE;
                    Iterator it = record.entrySet().iterator();
                    while( it.hasNext()){
                        Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>)it.next();
                        if(entry.getValue() < tempStart ){
                            tempStart = entry.getValue();
                        }
                        if(entry.getValue() > tempEnd ){
                            tempEnd = entry.getValue();
                        }
                    }
                    if( tempEnd - tempStart < maxEnd- minStart ){
                        minStart = tempStart;
                        maxEnd = tempEnd;
                    }
                }

            }
        }
        System.out.println( s.substring( minStart, maxEnd+1 ));
    }


}


