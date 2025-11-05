package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Stack;

/**
 * Class: 规范化Linux路径，
 * example ： /a/../../b/../c//.//  ->  /c
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/1 , 19:51
 */
public class Path_3_PathNormalization {

    public static String path = "/../";

    public static void main(String[] args) {
        System.out.println(normalizePath(path));
    }

    public static String normalizePath(String path) {
        path = path.replaceFirst("/", "");
        String[] dirs = path.split("/");
        Stack<String> dirStack = new Stack<>();
        for (String dir : dirs) {
            if (dir.equals(".") || dir == null || dir.equals("") || dir.equals(" ")) {
                continue;
            }
            if (dir.equals("..") && !dirStack.isEmpty()) {
                dirStack.pop();
                continue;
            }
            if(dir.equals("..") && dirStack.isEmpty()){
                continue;
            }
            dirStack.push(dir);
        }
        if(dirStack.isEmpty()){
            return "/";
        }
        String[] dirArray = new String[dirStack.size()];
        dirStack.toArray(dirArray);
        StringBuilder result = new StringBuilder();
        for (int j = 0; j <dirArray.length; j++) {
            result.append("/" + dirArray[j]);
        }
        return result.toString();
    }

}
