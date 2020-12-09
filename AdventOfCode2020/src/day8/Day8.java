package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {

	public static void main(String[] args) {
		
		ArrayList<String> data = inputToArray();//read input to a format I can more easily go back and forth
		
		ArrayList<Boolean> dupe = createDupeTracker(data.size());// fill an array with false, which we will use to track if we've executed a line of code before
		
		int part1= accAtDupe(data, dupe);
		
		
		System.out.println("Answer for part 1: "+part1);
		
		
		
		
		
		
		
		
		
	}
	
	
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