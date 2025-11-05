package com.maji.maojianwei.leetcode.ds_type.string;

/**
 * 10
 * desc:
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class RegMatch {


    public boolean isMatch1(String s, String p) {
        if(s.equals(p)) return true;
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        //多一位给予空串
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //空串绝对匹配
        dp[0][0] = true;
        //确保空串和 p 的一部分是匹配，比如 s = ""，p = "a*b"
        for(int i = 1; i <= pArr.length; i++) {
            if(pArr[i-1] == '*'){
                dp[0][i] = dp[0][i-2];
            }
            else{
                dp[0][i] = false;
            }
        }

        for(int i = 1; i <= sArr.length; i++) {
            for(int j = 1; j <= pArr.length; j++) {
                if(sArr[i - 1] == pArr[j - 1] || pArr[j - 1] == '.') {   // 如果相同或模式串为.则等于上一位的结果
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(pArr[j - 1] == '*') { // 遇到* 不能直接人为false，因为至少可以不取，后面再看。
                    if(pArr[j - 2] == sArr[i - 1] || pArr[j - 2] == '.') {   // 第一种情况： s的当前与p的前一个匹配，则X*即可以是多次匹配，也可以是不匹配
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    }else {
                        dp[i][j] = dp[i][j - 2]; // dp[i][j-2] 表示 X* 0次
                    }
                }
            }
        }
        return dp[sArr.length][pArr.length];
    }

    /**
     * 动态规划的优化
     */
    public boolean isMatch2(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        //初始空串
        boolean[][] dp = new boolean[sArr.length+1][pArr.length+1];
        dp[sArr.length][pArr.length] = true;

        //i=sArr.length 被使用到也需要赋值
        for(int i=sArr.length;i>=0;i--){
            for(int j=pArr.length-1;j>=0;j--){
                //后面是不是*
                if(j<pArr.length-1 && pArr[j+1] == '*'){
                    //当前字符是否匹配
                    if(i!= sArr.length && (sArr[i]==pArr[j] || pArr[j]== '.')){
                        dp[i][j] = dp[i+1][j]||dp[i][j+2];
                    }else{
                        dp[i][j] = dp[i][j+2];
                    }
                }else{
                    if(i!= sArr.length && (sArr[i]==pArr[j] || pArr[j]== '.')){
                        dp[i][j] = dp[i+1][j+1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 练习
     */
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        int n = str.length;
        int m = str.length;
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for( int i = 1; i <= m ; i++){
            if(pattern[i-1] == '*'){
                dp[0][i] = dp[0][i-2];
            }
            else{
                dp[0][i] = false;
            }
        }
        for(int i = 1; i<= n ;i++){
            for(int j = 1; j<= m ;j++){
                if(str[i-1] == pattern[j-1] || pattern[j-1] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pattern[j-1] == '*'){
                    if(pattern[j-2] == '.' || str[i-1] == pattern[j-2]){
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    }
                    else{
                        dp[i][j] = dp[i][j-2];
                    }
                }
                //都不满足则直接设置为false， 因为初始化是false所以不用处理
            }
        }

        return dp[n][m];
    }




}
