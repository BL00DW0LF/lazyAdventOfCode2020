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
				BagType thisBag= new BagType();
			
				
				//parse the line, token by token, but also line by line
				for (int i=0;i<tokens.length;i++) {
					if (tokens[i].equals("bag") || tokens[i].equals("bags") || tokens[i].equals("contain") || tokens[i].equals("no") || tokens[i].equals("other") || tokens[i].isEmpty()) {
						//then we don't care about it.  I hope
						
					}
					else{//we do care about this token
						String adj;
						String clr;
						//real shit.  don't parse token by token? assemble it as a phrase?  looks like may contain up to 4 different bag types.  how to handle? this should work:
						
						//if this is token 0(and 1), definitely need to update master bag list, even if it's in there already
						//don't forget to increment i so we don't double count
						if (i==0) {
							adj=tokens[i];
							clr=tokens[i+1];
							i++;
							thisBag=theList.findBag(adj, clr);
							if (thisBag==null) {//if this is a brand new bag, let's create it
								thisBag=new BagType(adj, clr);
							}
							else {
								//does this ever happen?
								System.out.println("it happens");
								//no, it doesn't happen.
							}
							
						}
						else if (tokens[i].chars().allMatch( Character::isDigit )){//first check if token is an integer, store it in tempQuant
							tempQuant=Integer.parseInt(tokens[i]);
							
							// if not token 0, and not integer, pass int and this token and next token into addBagInside for current thisBag
							//don't forget to increment i so we don't double count
							adj=tokens[i+1];
							clr=tokens[i+2];
							i++;i++;
							
							BagType bagInside = new BagType(adj,clr);
							thisBag.addBagInside(bagInside, tempQuant);
						}
						else {
							//this claims to be a token we care about, but it wasn't predicted
							System.out.println("Uhh, shouldn't be here, token = "+tokens[i]);
						}
					}//end else for tokens we care about
					
					
				}//end for loop parsing current line
				//so now we've parsed the whole line, we can add thisBag to master bag list
				theList.addBag(thisBag);
					
					
			}//done reading file. do we have to do anything here or can we close it?
				
				
				
			
			
			fileReader.close();
			System.out.println("Input complete.");
			
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File Read error");
			e.printStackTrace();
		}
		
		
		//for loop through masterbaglist, and increment a counter for each one that can contain shiny gold bag
		//actually no that's not going to work because I did not recursively update the master list when I came across a new bag.
		
		
		//print incremented counter for part 1
		//do I need to subtract one because it's counting itself?  no I accounted for that, it's the "This is just the bag you're looking for." line
		System.out.println("Counter for part 1: "+theList.mayContain("shiny", "gold"));//take a loong time to run, very inefficient
		
		
		//getting value of bags in bags for part two.  DO need to subtract one to get answer for Advent of Code, because we're not counting our gold bag (bags within gold bag)
		System.out.println("Counter for part 2: "+theList.getValue("shiny", "gold")+" minus one (given number is value of the bag)");
		
		
	}

}
