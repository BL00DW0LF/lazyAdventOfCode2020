package day5;
import java.io.*;

public class boardingPass implements Comparable<boardingPass>{

	int row;
	int column;
	int seatID;
	  
	 public boardingPass (String dataIn) {       
	        	//for loops? what are those? input sanitation? lol
	        	row=0; column=0;
	        	if (dataIn.charAt(0)=='B')
	        		row+=64;
	        	if (dataIn.charAt(1)=='B')
	        		row+=32;
	        	if (dataIn.charAt(2)=='B')
	        		row+=16;
	        	if (dataIn.charAt(3)=='B')
	        		row+=8;
	        	if (dataIn.charAt(4)=='B')
	        		row+=4;
	        	if (dataIn.charAt(5)=='B')
	        		row+=2;
	        	if (dataIn.charAt(6)=='B')
	        		row+=1;
	        	
	        	//get column in the same way
	        	if (dataIn.charAt(7)=='R')
	        		column+=4;
	        	if (dataIn.charAt(8)=='R')
	        		column+=2;
	        	if (dataIn.charAt(9)=='R')
	        		column+=1;
	        	
	        	//get seat ID
	        	seatID=(row*8)+column;
	        	
	        	//sanity check
	        	System.out.println("Row: "+row+". Column: "+column+". SeatID: "+seatID);
	        	
	        
	 }
	 
	        public  void print() 
	        { 
	          
	        	System.out.println("Row: "+row+". Column: "+column+". SeatID: "+seatID);
	       
	               
	        } 
	        
	        public int getSeatID() 
	        { 
	          
	        	return seatID;
	       
	               
	        } 
	        
	        @Override
	        public int compareTo(boardingPass o) {
	            
	            
	            return Integer.compare(seatID, o.getSeatID());
	        }
	        
} 
