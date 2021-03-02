package com.pregopower.provider.pages;

import java.io.IOException;
import java.util.ArrayList;

import com.pregopower.provider.utility.ReadandWrite_Excel;

public class NewTest {
	
		
		
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
ReadandWrite_Excel d= new ReadandWrite_Excel();
		
		ArrayList data = d.getData("login");
		
		System.out.println(data.get(0));

		System.out.println(data.get(1));   
		System.out.println(data.get(2)); 
		//int count1= 0;
		
	/*	String abc= "ami&t";
		String rev=" ";
		
		 //int upper = 0, lower = 0, number = 0, special = 0;
		 
		 
		
		 for (int i = abc.length()-1 ;  i>=0 ;i--){
			 
			 rev= rev + abc.charAt(i);
		 }
		 System.out.println("Lower case letters : " + rev); 
	        
		*/
	}	
		
}
