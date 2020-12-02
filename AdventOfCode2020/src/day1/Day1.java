package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Day1 {

	public static void main(String[] args) {
		//get input
		ArrayList<Integer> data = inputToArray();
		
		//sort input
		Collections.sort(data);
		
		//get the answer for part 1
		find2020Multiple(data, 2020);
		
		//get the answer for part 2
		find2020Triple(data);
	}

	static ArrayList<Integer> inputToArray() {
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		try{
			File day1Input = new File("day1Input.txt");
		
			Scanner fileReader = new Scanner (day1Input);
			String tempIn;
			while (fileReader.hasNextLine()) {
				tempIn=fileReader.nextLine();
				//System.out.println(tempIn);
				output.add(Integer.parseInt(tempIn));
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
	
	static int find2020Multiple(ArrayList<Integer> data, int targetSum) {
		//compare lowest value and highest value, increment/decrement as necessary until meet in the middle.
		int pointerLow=0;
		int pointerHigh=data.size()-1;
		int data1=data.get(pointerLow);
		int data2=data.get(pointerHigh);
		boolean failure=false;

		
		
		while (data1+data2 != targetSum && !failure) {
			if (pointerLow >= pointerHigh) {
				//bad input
				failure=true;
				//System.out.println("Bad input, no sum found.");
				return 0;
			}
			else if ((data1+data2)>targetSum) {
				//need to lower the higher number
				data2=data.get(--pointerHigh);
			}
			else if ((data1+data2)<targetSum) {
				//need to raise the lower number
				data1=data.get(++pointerLow);
			}
			
			
		}
		//found?
		System.out.println("Found "+targetSum+": "+data1+" + "+data2);
		System.out.println("Multiplied: "+(data1*data2));
		return data1*data2;
		
	}
	
	static void find2020Triple(ArrayList<Integer> data) {
		//compare lowest value and highest value, increment/decrement as necessary until meet in the middle.

		int data0=data.get(0);
		int newTarget=2020-data0;
		
		data.remove(0);
		int multipleTest=find2020Multiple(data,newTarget);
		
		while (multipleTest==0) {
			if (data.size()>1){
				data0=data.get(0);
				data.remove(0);
				newTarget=2020-data0;
				multipleTest=find2020Multiple(data,newTarget);
			}
			else {
				multipleTest=-1;
			}
			
			
		}
		//when loop is done, they've found 2/3 of the multiple
		System.out.println("Triple: "+(multipleTest*data0));
		
	}
	
}
