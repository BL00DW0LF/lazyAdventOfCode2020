package day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day9 {

	public static void main(String[] args) {
		
		//for part 1: input and store the data
		String part1Answer=inputAndProcess();
		System.out.println("Answer for Part 1: "+part1Answer);
		
		long part2Answer=findContiguousSum(Long.parseLong(part1Answer));
		System.out.println("Answer for Part 2: "+part2Answer);
	}





public static String inputAndProcess(){
	ArrayList<KeyedDataPair> data= new ArrayList<KeyedDataPair>();
	int indexHigh=0;//to keep track of the most recently added data
	//int indexLow=0;//the lowest index we should expect to see in the data
	
	try{
		File input = new File("day9Input.txt");
	
		Scanner fileReader = new Scanner (input);
		String tempIn;
		
		while (fileReader.hasNextLine()) {
			
			
			tempIn=fileReader.nextLine();
			//System.out.println(tempIn);
			
			if (data.size()<25) {//then we need to propagate the data
				//and we need to do nothing special, just proceed below
				
			}
			else {//we need to find the sum
				if(isThereSum(data, tempIn)) {//if the sum exists, then proceed  //isThereSum()
					
					//need to remove data with index value indexLow. be extra lazy and just sort by index, remove first element
					Collections.sort(data, new KeyedIndexComparator());//sorting by index
					//System.out.println("Removing lowest index from list w/ index: "+data.get(0).getIndex());
					data.remove(0);
					
					//and will just add the current dataIn below
				}
				else {//or we have found the first number that doesn't process, return it for part 1 answer
					System.out.println("Yaay, we found the first sum that doesn't process @ input line "+(indexHigh+1));
					return tempIn;
					
				}
				
			}
			
			
			data.add(new KeyedDataPair(indexHigh,Long.parseLong(tempIn)));
			
			indexHigh++;
			
		}//we have reached end of file
		fileReader.close();
		System.out.println("Input complete.");
		System.out.println("Total lines read: "+indexHigh);
		
	}
	catch(FileNotFoundException e) {
		System.out.println("File Read error");
		e.printStackTrace();
	}
	
	return "NOT FOUND";
}





public static boolean isThereSum(ArrayList<KeyedDataPair> data, String target) {
	Collections.sort(data, new KeyedValueComparator());//sorting by value
	
	//let's just test that it sorted properly
	/*for (int i=0;i<data.size();i++) {
		System.out.println(data.get(i).getValue());
		
	}*/
	
	
	int indexLow=0;
	int indexHigh=data.size()-1;
	long targetSum = Long.parseLong(target);
	
	while(indexLow<indexHigh) {
		long tempSum=data.get(indexLow).getValue() + data.get(indexHigh).getValue();
		
		if (tempSum<targetSum) {//if we need a higher sum
			indexLow++;
		}
		else if (tempSum>targetSum) {
			indexHigh--;
		}
		else if (data.get(indexLow).getValue()==data.get(indexHigh).getValue()) {//if we hit here, we found the target sum, but it's not valid because the values are equal to eachother.  
			System.out.println("Valid sum, but nums are equal to eachother. 2x " + data.get(indexHigh).getValue());
			indexLow++;
		}
		else {//then the sum is valid
			return true;
		}
		
		
	}
	
	
	return false;
}



public static long findContiguousSum(long targetSum) {
	long runningSum=0;
	ArrayList<KeyedDataPair> data= new ArrayList<KeyedDataPair>();
	int indexHigh=0;//to keep track of the most recently added data
	
	
	try{
		File input = new File("day9Input.txt");
		Scanner fileReader = new Scanner (input);
		
		while (fileReader.hasNextLine()) {
			
			
			
			//get future line
			Long tempValue=Long.parseLong(fileReader.nextLine());
			
			
			
			if (runningSum<targetSum) {//we just need to add another number
				
				//can just do below? do nothing here?
			}
			else if (runningSum>targetSum) {
				System.out.println("Size of contiguous attempt before removing: "+data.size());
				
				//we need to remove numbers from the front of data (and subtract from runningSum) until runningSum<targetSum
				while(runningSum>targetSum) {
					runningSum-=data.get(0).getValue();
					data.remove(0);
				}//when this loop is done, we should be ready to add a new number below
				
			}
			else {//then runningSum == targetSum
				if (tempValue==targetSum) {
					System.out.println("We have gone too far trying to find a sum.");
					fileReader.close();
					return -1;
				}
				
				
				
				//need to find lowest value and highest value, sum them together, and return
				//sort data first
				Collections.sort(data, new KeyedValueComparator());
				fileReader.close();
				long low=data.get(0).getValue();
				long high=data.get(data.size()-1).getValue();
				System.out.println("Low consec: "+low);
				System.out.println("High consec: "+high);
				return (low + high);//sum highest and lowest values (first and last in data)
				
				
			}
			data.add(new KeyedDataPair(indexHigh,tempValue));
			runningSum+=tempValue;
			indexHigh++;
			
		}//we have reached end of file
		fileReader.close();
		System.out.println("End of File for part 2. Uh oh...");
		//System.out.println("Total lines read: "+indexHigh);
		
	}
	catch(FileNotFoundException e) {
		System.out.println("File Read error");
		e.printStackTrace();
	}
	
	
	
	
	return -1;
}



}