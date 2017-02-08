package com.valeo.xml.recovery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RecoverXML {

	public static void main(String[] args) {
//		File file = new File("E:/UnCategorized/castle.txt");
//		File correctedFile = new File("E:/UnCategorized/corrected.xml");
		File file = new File(args[0]);
		File correctedFile = new File(args[1]);
		
		StringBuilder builder = new StringBuilder();
		
		Scanner s = null;
		System.out.println("FixMyFile has started working");
		try {
			s = new Scanner(new BufferedReader(new FileReader(file)));
			while(s.hasNext()) {
				String str = s.next();
				char[] myChar = str.toCharArray();
				ArrayList<Character> correctedList = new ArrayList<Character>();
				// print the character array
//				printCharArray(myChar);
//				correctedList = validateCharArray(myChar) ;
				builder.append(validateCharArray(str));
//				builder.append("\n");
//				System.out.println(correctedList);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(s != null) {
				s.close();
			}
		}
		
		
		try{
		    PrintWriter writer = new PrintWriter(correctedFile, "UTF-8");
		    writer.println(builder);
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
		
		System.out.println("FixMyFile Has finished working");
		
	}
	
	
	private static String validateCharArray(String in) {
		StringBuffer out = new StringBuffer();
		char current;
		for(int i = 0; i< in.length() ; i++) {
			current = in.charAt(i);
			if(current < 0x7F) {
				out.append(current);
			}
				
		}
		return out.toString();
		
//		ArrayList<Character> correctList = new ArrayList<Character>();
//		for (char c : myChar) {
//			if (c < 0x7F)
//	         {
//				correctList.add(c);
//	         } else {
//	        	 // This is invalid character
////	        	 System.out.println("This is invalid xml character : " +  c);
//	         }
//		}
//		return correctList;
		 
	}
	

//	private static ArrayList<Character> validateCharArray(char[] myChar) {
//		ArrayList<Character> correctList = new ArrayList<Character>();
//		for (char c : myChar) {
//			if (c < 0x7F)
//	         {
//				correctList.add(c);
//	         } else {
//	        	 // This is invalid character
////	        	 System.out.println("This is invalid xml character : " +  c);
//	         }
//		}
//		return correctList;
//		 
//	}

//	private static void printCharArray(char[] myChar) {
//		if(myChar[myChar.length-1] !=  '\0') {
//			System.out.println("This string wasn't terminated then skip it");
//		} else {
//			System.out.println(myChar);
//		}
//		
//	}
}
