package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Day7 {

	public static void main(String[] args) {
		//this problem is dumb.  this solution is going to be dumb

		//I am really trusting there's no infinite bag recursion
		
		MasterBagList theList= new MasterBagList();
		
		//read input
		try{
			File input = new File("day7Input.txt");
		
			Scanner fileReader = new Scanner (input);
			String tempIn;
			String delims = "[,. ]";
			String[] tokens;
			int tempQuant;
			
			
			
			while (fileReader.hasNextLine()) {
				tempIn=fileReader.nextLine();
				//System.out.println(tempIn);
				tokens=tempIn.split(delims);
				BagType thisBag;
			
				
				//parse the line, token by token, but also line by line
				for (int i=0;i<tokens.length;i++) {
					if (tokens[i].equals("bag") || tokens[i].equals("bags") || tokens[i].equals("contain") || tokens[i].isEmpty()) {
						//then we don't care about it
						
					}
					else{
						//real shit.  don't parse token by token? assemble it as a phrase?  looks like may contain up to 4 different bag types.  how to handle? this should work
						
						//if this is token 0(and 1), definitely need to update master bag list, even if it's in there already
						//don't forget to increment i so we don't double count
						
						
						
						
						//first check if token is an integer, store it in tempQuant

						
						// if not token 0, and not integer, pass int and this token and next token into addBagInside for current thisBag
						//don't forget to increment i so we don't double count
						
						
					}
					
					
				}//end for loop parsing current line
				
				
				//so now we've parsed the whole line, we can add thisBag to master bag list
					
					
					
			}//done reading file. do we have to do anything here or can we close it?
				
				
				
			
			
			fileReader.close();
			System.out.println("Input complete.");
			
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File Read error");
			e.printStackTrace();
		}
		
		
		//for loop through masterbaglist, and increment a counter for each one that can contain shiny gold bag
		
		
		//print incremented counter for part 1
		
		
		
		
	}

}
