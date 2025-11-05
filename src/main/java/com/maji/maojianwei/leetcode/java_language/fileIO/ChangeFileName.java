package com.maji.maojianwei.leetcode.java_language.fileIO;

import java.io.File;
/**
 * Class: �ı��ļ���
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/22 , 9:39
 */
public class ChangeFileName {
    public static void main(String[] args) {
        String srcPath = "C:\\Users\\lvyinru\\Desktop\\Test\\oldCode";
        String destPath = "C:\\Users\\lvyinru\\Desktop\\Test\\newCode";
        String prefix = "Slide";
        String suffix = "Code.cs";
        changeName(srcPath, destPath, 4, prefix, suffix);



    }

    /*  offset  ����ҳ�� */
    public static void changeName(String srcPath, String destPath, int offset, String prefix, String suffix) {
        File file = new File(srcPath);
        File[] files = file.listFiles();
        for (int i = files.length - 1; i >= 0; i--) {
            String name = files[i].getName();
            int start = prefix.length();/* ȷ����Ҫ�޸ĵ�λ�� */
            int end = name.indexOf(suffix);
            if (end != -1) {
                int oldValue = Integer.parseInt(name.substring(start, end));
                int newValue = oldValue + offset;
                String newName = destPath + "\\" + prefix + newValue + suffix;
                files[i].renameTo(new File(newName));//������ͬʱ�ƶ������ļ�����
            }
        }
    }
}
