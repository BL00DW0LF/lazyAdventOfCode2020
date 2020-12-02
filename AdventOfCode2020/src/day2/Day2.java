package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int finalCount1=0;
		int finalCount2=0;
		
		try{
			File input = new File("day2Input.txt");
		
			Scanner fileReader = new Scanner (input);
			String tempIn;
			String delims = "[- :]";
			String[] tokens;
			
			while (fileReader.hasNextLine()) {
				tempIn=fileReader.nextLine();
				//System.out.println(tempIn);
				tokens=tempIn.split(delims);

				int minimum= Integer.parseInt(tokens[0]);//System.out.println(tokens[0]);//minimumChar
				int maximum= Integer.parseInt(tokens[1]);//System.out.println(tokens[1]);//maximumChar
				char targetChar=tokens[2].charAt(0);//System.out.println(tokens[2]);//targetChar
				//System.out.println(tokens[3]);//blank
				String password = tokens[4];//System.out.println(tokens[4]);//password
				
				//PART 1: get count of occurrences in password
				long count = password.chars().filter(ch -> ch ==targetChar).count();
				if(count>=minimum && count<=maximum) {
					finalCount1++;
				}
				
				
				//PART 2: check positions A and B and ensure exactly one contains given letter. use xor
				if (password.charAt(minimum-1)==targetChar ^ password.charAt(maximum-1)==targetChar){
					finalCount2++;
				}
			}
			fileReader.close();
			System.out.println("Input complete.");
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File Read error");
			e.printStackTrace();
		}
		
		System.out.println("Part 1 answer: "+finalCount1);
		System.out.println("Part 2 answer: "+finalCount2);
		//just read data while parsing?
		
	}

}
