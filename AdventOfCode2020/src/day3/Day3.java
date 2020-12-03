package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigInteger; 

public class Day3 {

	public static void main(String[] args) {
		
		
		//read input
		ArrayList<String> data = inputToArray();
		
		
		
		int width = (data.get(0)).length(); System.out.println("Width:"+width);
		int height = data.size(); System.out.println("Hight:"+height);
		
		int posX1=0;
		int posX2=0;
		int posX3=0;
		int posX4=0;
		int posX5=0;
		int posY=0;
		boolean down2=false;
		
		posX1=(posX1+1)%width;
		posX2=(posX2+3)%width;
		posX3=(posX3+5)%width;
		posX4=(posX4+7)%width;
		//don't need to set up x5 for first run, it increments in loop
		posY=posY+1;
		
		int countTree1=0;
		int countTree2=0;
		int countTree3=0;
		int countTree4=0;
		int countTree5=0;
		
		while (posY<height) {
			if (data.get(posY).charAt(posX1)=='#') {
				countTree1++;
				//System.out.println("Tree Found in row "+posY+ " horiz "+posX1);
			}
			else {
				//System.out.println("No Tree Found in row "+posY+ " horiz "+posX1);
			}
			if (data.get(posY).charAt(posX2)=='#') {
				countTree2++;
				//System.out.println("Tree Found in row "+posY+ " horiz "+posX2);
			}
			else {
				//System.out.println("No Tree Found in row "+posY+ " horiz "+posX2);
			}
			if (data.get(posY).charAt(posX3)=='#') {
				countTree3++;
				//System.out.println("Tree Found in row "+posY+ " horiz "+posX3);
			}
			else {
				//System.out.println("No Tree Found in row "+posY+ " horiz "+posX3);
			}
			if (data.get(posY).charAt(posX4)=='#') {
				countTree4++;
				//System.out.println("Tree Found in row "+posY+ " horiz "+posX4);
			}
			else {
				//System.out.println("No Tree Found in row "+posY+ " horiz "+posX4);
			}
			if (down2 && data.get(posY).charAt(posX5)=='#') {
				countTree5++;
				//System.out.println("Tree Found in row "+posY+ " horiz "+posX5);
			}
			else if(down2) {
				//System.out.println("No Tree Found in row "+posY+ " horiz "+posX5);
			}
			
			
			//next locations
			posX1=(posX1+1)%width;
			posX2=(posX2+3)%width;
			posX3=(posX3+5)%width;
			posX4=(posX4+7)%width;
			posY=posY+1;
			down2=!down2;
			if (down2) {
				posX5=(posX5+1)%width;
			}
			
		}
		System.out.println("Trees1:"+countTree1);
		System.out.println("Trees2:"+countTree2);
		System.out.println("Trees3:"+countTree3);
		System.out.println("Trees4:"+countTree4);
		System.out.println("Trees5:"+countTree5);
		BigInteger multiple = new BigInteger(String.valueOf(countTree1));
		System.out.println("Multiple:"+(multiple));
		multiple=multiple.multiply(new BigInteger(String.valueOf(countTree2)));
		System.out.println("Multiple:"+(multiple));
		multiple=multiple.multiply(new BigInteger(String.valueOf(countTree3)));
		System.out.println("Multiple:"+(multiple));
		multiple=multiple.multiply(new BigInteger(String.valueOf(countTree4)));
		System.out.println("Multiple:"+(multiple));
		multiple=multiple.multiply(new BigInteger(String.valueOf(countTree5)));
		
		System.out.println("Multiple:"+(multiple));
		
	}





static ArrayList<String> inputToArray() {
	ArrayList<String> output = new ArrayList<String>();
	
	try{
		File input = new File("day3Input.txt");
	
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

}