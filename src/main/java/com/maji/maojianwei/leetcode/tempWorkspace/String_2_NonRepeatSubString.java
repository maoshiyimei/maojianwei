package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class: �ҳ�����ظ�Ԫ�ص������Ӵ�
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/6 , 21:35
 */
public class String_2_NonRepeatSubString {
    public static void main(String[] args){
        String s = "fdggerghaasdfdfbgbrcddsfgrerheyjtjtyuuykudfdvfnttjty";
        String subString = getMaxSubString( s );
        System.out.println( " max subString length : " + subString.length() );
        System.out.println( subString );
    }

    public static String getMaxSubString( String str ){
        int n = str.length();
        char[] letters = str.toCharArray();
        int start = 0 , end = 0;
        int tempStart = 0, tempEnd = 0 ;
        char foreLetter = letters[0];
        int max = 1;
        int count = 1;
        for( int i = 1 ; i< n ; i++){
            if( letters[i] == foreLetter ){
                if(count > max){
                    max = count ;
                    start= tempStart;
                    end =tempEnd;

                }
                count = 1;
                tempStart = i;
                tempEnd = i;

            }
            else{
                count++;
                tempEnd++;
            }
            foreLetter = letters[i];
        }
        return str.substring(start, end+1);
    }

}
