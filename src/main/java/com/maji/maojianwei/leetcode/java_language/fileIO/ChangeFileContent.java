package com.maji.maojianwei.leetcode.java_language.fileIO;

import java.io.*;

/**
 * Class: �޸��滻�ļ��е�ָ������
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/22 , 9:54
 */
public class ChangeFileContent {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\lvyinru\\Desktop\\Test\\oldCode";
        String path1 = "C:\\Users\\lvyinru\\Desktop\\Test\\newCode";
        changePage(path,path1,4,"Slide","Code.cs");

    }
    public static void changePage(String srcPath,String destPath,int offset,String prefix,String suffix) throws Exception{
        File srcFile = new File(srcPath);
        File[] files = srcFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            String name = files[i].getName();
            int start = prefix.length();
            int end = name.indexOf(suffix);
            if(end!=-1){
                int page = Integer.parseInt(name.substring(start, end));
                File destFile = new File(destPath + File.separator + prefix + page + suffix);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(files[i]));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destFile));
                String line;
                while((line=bufferedReader.readLine())!=null){
                    String replace;
                    if(line.contains("Slide"+page+"Code")){
                        replace = line.replace(String.valueOf(page), String.valueOf(page+offset));
                    }
                    else if(line.contains("SlidePage1("+page+")")){
                        replace = line.replace(String.valueOf(page), String.valueOf(page+offset));
                    } else{
                        replace=line;
                    }
                    bufferedWriter.write(replace);
                    bufferedWriter.write("\n");
                    bufferedWriter.flush();
                }
            }
        }
    }

}

