package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {

	public static void main(String[] args) {
		
		ArrayList<String> data = inputToArray();//read input to a format I can more easily go back and forth
		
		//ArrayList<Boolean> dupe = createDupeTracker(data.size());// fill an array with false, which we will use to track if we've executed a line of code before
		
		int part1= accAtDupe(data, createDupeTracker(data.size()));
		
		
		System.out.println("Answer for part 1: "+part1);
		
		
		//for part 2.  make two new methods, doesProgramTerminate(data, dupe, indexToFlip) + executeCorrectedProgram(data, dupe, indexToFlip)
		//maybe needs a third method testFlipAll(data, dupe), returning int indexToFlip.   If we parse it as it would be written, we don't test flips for any lines that would never be ran anyway.  
		int part2Flip=testFlipAll(data,createDupeTracker(data.size()));//get the index of the instruction to flip
		if (part2Flip==-1)//abort
			System.out.println("Did not find flippable command");
		else {
			System.out.println("Flip Found @ "+part2Flip);
			int part2 = executeCorrectedProgram(data,part2Flip);
			
			System.out.println("Answer for part 2: "+part2);
		}
		
		
		
		
		
	}
	
	
	//part 1 method
    public static int accAtDupe(ArrayList<String> data, ArrayList<Boolean> dupe) {
    	int accumulator=0;
    	int index=0;
    	
    	while (dupe.get(index)==false) {//heavily assuming there's an infinite loop here, oh well
    		//split into tokens, only separator is space
    		String delims = "[ ]";
			String[] tokens=data.get(index).split(delims);
    		
			//before we start playing with the index, let's mark that we've executed code at this index
			dupe.set(index, true);
			
			switch(tokens[0]) {
			case "nop":
				//then do nothing, increment index for next loop
				index++;
				break;
			case "acc":
				//increment accumulator by next token's value
				accumulator+= Integer.parseInt(tokens[1]);
				index++;
				break;
			case "jmp":
				//set index appropriately.  
				index+=Integer.parseInt(tokens[1]);
				break;
			default:
				System.out.println("We are not in Kansas anymore.");//oh god something is wrong
			}
			
    		
    	}
    	
    	return accumulator;
    }
	
    
	public static int testFlipAll(ArrayList<String> data, ArrayList<Boolean> dupe) {
		//int accumulator=0;
    	int index=0;
    	//int trackHowManyCommands=0;
    	//System.out.println(trackHowManyCommands);
    	
    	while (dupe.get(index)==false) {//heavily assuming there's an infinite loop here, oh well
    		//System.out.println(trackHowManyCommands);
			//trackHowManyCommands++;
    		
    		
    		
    		//split into tokens, only separator is space
    		String delims = "[ ]";
			String[] tokens=data.get(index).split(delims);
    		
			//before we start playing with the index, let's mark that we've executed code at this index
			dupe.set(index, true);
			
			switch(tokens[0]) {
			case "nop":
				//then do nothing, increment index for next loop
				if (doesProgramTerminate(data,createDupeTracker(data.size()),index)) {
					return index;
					
				}
				index++;
				break;
			case "acc":
				//increment accumulator by next token's value
				//accumulator+= Integer.parseInt(tokens[1]);
				index++;
				break;
			case "jmp":
				//set index appropriately.  
				if (doesProgramTerminate(data,createDupeTracker(data.size()),index)) {
					return index;
					
				}
				index+=Integer.parseInt(tokens[1]);
				break;
			default:
				System.out.println("We are not in Kansas anymore.");//oh god something is wrong
			}
			
    		
    	}
    	
    	
    	return -1;//nothing terminated when flipped
	}
	
	public static boolean doesProgramTerminate(ArrayList<String> data, ArrayList<Boolean> dupe, int indexToFlip) {
		int index=0;
		//int trackHowManyCommands=0;
		//System.out.println(trackHowManyCommands);
		
		while (dupe.get(index)==false) {//heavily assuming there's an infinite loop here, oh well
			//System.out.println(trackHowManyCommands);
			//trackHowManyCommands++;
    		//split into tokens, only separator is space
    		String delims = "[ ]";
			String[] tokens=data.get(index).split(delims);
    		
			//before we start playing with the index, let's mark that we've executed code at this index
			dupe.set(index, true);
			
			switch(tokens[0]) {
			case "nop":
				//then do nothing, increment index for next loop
				if (index==indexToFlip) {//if we are supposed to flip this command
					//do a jmp instead
					index+=Integer.parseInt(tokens[1]);
				}
				else {
					index++;
				}
				break;
			case "acc":
				//increment accumulator by next token's value
				//accumulator+= Integer.parseInt(tokens[1]);
				index++;
				break;
			case "jmp":
				if (index==indexToFlip) {//if this is the index we a are supposed to flip
					//then just nop
					index++;
				}
				else {
					//set index appropriately.  
					index+=Integer.parseInt(tokens[1]);
				}
				
				break;
			default:
				System.out.println("We are not in Kansas anymore.");//oh god something is wrong
			}
			
    		if(index>=data.size()){
    			//if we hit the end of the program.  or if there's a massive + jmp, which I assume is not in the input
    			System.out.println("We found a program that terminates.");
    			return true;
    		}
    			
    	}//end while loop
		
		
		//if we hit here, then we've executed a command twice in an infinite loop
		
		
		return false;
	}
	
	public static int executeCorrectedProgram(ArrayList<String> data, int indexToFlip) {
		int accumulator=0;
    	int index=0;
    	
    	while (index<data.size()) {//heavily assuming there's an infinite loop here, oh well
    		//split into tokens, only separator is space
    		String delims = "[ ]";
			String[] tokens=data.get(index).split(delims);
			
			switch(tokens[0]) {
			case "nop":
				//then do nothing, increment index for next loop
				if (index==indexToFlip) {//if we are supposed to flip this command
					//do a jmp instead
					index+=Integer.parseInt(tokens[1]);
				}
				else {
					index++;
				}
				break;
			case "acc":
				//increment accumulator by next token's value
				accumulator+= Integer.parseInt(tokens[1]);
				index++;
				break;
			case "jmp":
				if (index==indexToFlip) {//if this is the index we a are supposed to flip
					//then just nop
					index++;
				}
				else {
					//set index appropriately.  
					index+=Integer.parseInt(tokens[1]);
				}
				
				break;
			default:
				System.out.println("We are not in Kansas anymore.");//oh god something is wrong
			}
			
    		
    	}//end while loop
    	
    	
		return accumulator;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<String> inputToArray(){
		ArrayList<String> output = new ArrayList<String>();
		
		try{
			File input = new File("day8Input.txt");
		
			Scanner fileReader = new Scanner (input);
			String tempIn;
			while (fileReader.hasNextLine()) {
				tempIn=fileReader.nextLine();
				//System.out.println(tempIn);
				output.add(tempIn);
			}
			fileReader.close();
			System.out.println("Input complete.");
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File Read error");
			e.printStackTrace();
		}
		
		return output;
	}




    public static ArrayList<Boolean> createDupeTracker(int targetSize){
    	ArrayList<Boolean> output = new ArrayList<Boolean>();
    	
    	while (output.size()<=targetSize)
    		output.add(false);
    	
    	return output;
    }
    

    
}