package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Day5 {

	public static void main(String[] args) {
		
		
		LinkedList<boardingPass> pList = new LinkedList<boardingPass>();
		
		
		//input data
		try{
			File input = new File("day5Input.txt");
		
			Scanner fileReader = new Scanner (input);
			String tempIn;
			while (fileReader.hasNextLine()) {
				tempIn=fileReader.nextLine();
				//System.out.println(tempIn);
				pList.add(new boardingPass(tempIn));
			}
			fileReader.close();
			System.out.println("Input complete.");
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File Read error");
			e.printStackTrace();
		}
		

		
		//try sort?
		Collections.sort(pList);
		//get last seat on plane
		System.out.println("Last seat is:");
		pList.get(pList.size()-1).print();
		
		
		//look for missing seat. just compare adjacent seats?
		boolean searching=true;
		int seatLow=0;
		int seatHigh=1;
		
		while(searching) {
			if (pList.get(seatLow).getSeatID() == pList.get(seatHigh).getSeatID() -1) {
				//if difference is one seat, need to keep looking
				seatLow=seatHigh;
				seatHigh+=1;
				if(seatHigh>=pList.size())
					//don't go out of bounds here I guess
					searching=false;
			}
			else
			{//then we have found the empty space between seatLow and seatHigh
				int mySeat=pList.get(seatLow).getSeatID()+1;
				
				System.out.println("My seat number is: "+mySeat);
				searching=false;
			}
			
			
		}
	}

}
