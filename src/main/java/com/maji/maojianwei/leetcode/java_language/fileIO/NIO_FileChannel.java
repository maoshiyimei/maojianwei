package com.maji.maojianwei.leetcode.java_language.fileIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/1 , 12:49
 */
public class NIO_FileChannel{
    public static void main(String[] args) throws IOException{

        RandomAccessFile file =new RandomAccessFile("fileChannel.txt","rw");
        FileChannel channel = file .getChannel();

        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);byteBuffer2.put("123456787654!".getBytes());
        channel.write(byteBuffer2);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int n = channel.read(byteBuffer);
        while( n != -1){
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()){
                System.out.println( (char)byteBuffer.get());
            }
            n = channel.read(byteBuffer);
        }
        System.out.println( byteBuffer.getChar());



        channel.close();
    }
}