package com.maji.maojianwei.leetcode.ds_type.set;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountKeyWorld{

	public static void main(String[] args) throws Exception{
		Scanner input= new Scanner(System.in);
//		String fileName = input.nextLine();
		File file =new File("C:\\eclipse\\workSpace\\Set\\src\\set\\1.txt");
		if(file.exists()) {
			System.out.println("the number of keyWorlds in file 1.txt "+countKeyWords(file));
		}
		else {
			System.out.println("file not exist!");
		}
		input.close();
		
	}
	
	public static int countKeyWords(File file) throws Exception {
		String[] keyWords = {"main","static","String","public",
				"if","else","return","int","void","long","true"};
		Set<String> set =new HashSet<>(Arrays.asList(keyWords));
		int count =0;
		Scanner input =new Scanner(file);
		while(input.hasNext()) {
			String word =input.next();
			if(set.contains(word))
				count++;
		}
		input.close();
		return count;
		
	}

}
