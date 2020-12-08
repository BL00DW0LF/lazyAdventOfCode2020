package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Day6 {

	public static void main(String[] args) {
		
		
		
		LinkedList<Group> groupList = new LinkedList<Group>();
		
		
		
		try{
			File input = new File("day6Input.txt");
		
			Scanner fileReader = new Scanner (input);
			String tempIn;
			
			
			Group workGroup=new Group();;
			
			
			while (fileReader.hasNextLine()) {
				tempIn=fileReader.nextLine();
				//System.out.println(tempIn);
				
				
			
				if(tempIn.isEmpty()) {
					//then new group
					groupList.add(workGroup);
					workGroup=new Group();
					// will this work? java is weird
					
				}
				else {
				//parse the line
				workGroup.addPerson(tempIn);
					
					
					
				}
				
				
				
			}
			
			fileReader.close();
			System.out.println("Input complete.");
			
			//end of file, also trigger end of group thingy
			groupList.add(workGroup);
		}
		catch(FileNotFoundException e) {
			System.out.println("File Read error");
			e.printStackTrace();
		}
		
		//for testing
		//System.out.println(groupList.get(0).getNumQs());
		//System.out.println(groupList.get(1).getNumQs());
		//System.out.println(groupList.get(2).getNumQs());
		//System.out.println(groupList.size());
		
		int sumResponses=0;
		int sumUnanimous=0;
		for (int i=0;i<groupList.size();i++) {
			sumResponses+= groupList.get(i).getNumQs();
			sumUnanimous+= groupList.get(i).getUnanimous();
			
		}
		
		System.out.println("Total Sum Responses: "+sumResponses);
		System.out.println("Total Unanimous Responses: "+sumUnanimous);

	}

}
