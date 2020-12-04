package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {

	public static void main(String[] args) {
		int semiValidPassports=0;
		int mostlyValidPassports=0;
		
		try{
			File input = new File("day4Input.txt");
		
			Scanner fileReader = new Scanner (input);
			String tempIn;
			String delims = "[: ]";
			String[] tokens;
			
			boolean byr=false;
			boolean iyr=false;
			boolean eyr=false;
			boolean hgt=false;
			boolean hcl=false;
			boolean ecl=false;
			boolean pid=false;
			boolean cid=false;
			
			boolean byrV=false;
			boolean iyrV=false;
			boolean eyrV=false;
			boolean hgtV=false;
			boolean hclV=false;
			boolean eclV=false;
			boolean pidV=false;
			boolean cidV=false;
			
			
			
			while (fileReader.hasNextLine()) {
				tempIn=fileReader.nextLine();
				//System.out.println(tempIn);
				
				
			
				if(tempIn.isEmpty()) {
					//then we have a new line, new passport
					if(byrV&&iyrV&&eyrV&&hgtV&&hclV&&eclV&&pidV) {
						mostlyValidPassports++;
						System.out.println("Moslty-Valid Passport");
					}					
					else if(byr&&iyr&&eyr&&hgt&&hcl&&ecl&&pid) {
						semiValidPassports++;
						System.out.println("Semi-Valid Passport");
					}
					
					else {
						System.out.println("Invalid Passport");
					}
					
					
					
					//then reset counters etc
					//System.out.println("Previous line is blank, yes?");
					byr=false;
					iyr=false;
					eyr=false;
					hgt=false;
					hcl=false;
					ecl=false;
					pid=false;
					cid=false;
					
					byrV=false;
					iyrV=false;
					eyrV=false;
					hgtV=false;
					hclV=false;
					eclV=false;
					pidV=false;
					cidV=false;
				}
				else {
				
				tokens=tempIn.split(delims);
				
				for (int i=0;i<tokens.length;i++) {
					//System.out.println(tokens[i]);
					int data;
					
					//so for validation, grab the next token after the identifier and check it
					switch (tokens[i]) {
					case "byr":
						byr=true;
						i++;
						data=Integer.parseInt(tokens[i]);
						if (tokens[i].length()==4 && data>=1920 && data <= 2002)
							byrV=true;
						break;
					case "iyr":
						iyr=true;
						i++;
						data=Integer.parseInt(tokens[i]);
						if (tokens[i].length()==4 && data>=2010 && data <= 2020)
							iyrV=true;
						break;
					case "eyr":
						eyr=true;
						i++;
						data=Integer.parseInt(tokens[i]);
						if (tokens[i].length()==4 && data>=2020 && data <= 2030)
							eyrV=true;
						break;
					case "hgt"://yikes.  don't look
						hgt=true;
						i++;
						String number="";
						String units="";
						
						//parse out the data??  god this is bad
						//System.out.println(tokens[i].length());
						//System.out.println(tokens[i]);
						
						for (int y=0; y<(tokens[i].length());y++) {
							if (Character.isDigit(tokens[i].charAt(y))) {
								number=number+tokens[i].charAt(y);
							}
							else {
								units=units+tokens[i].charAt(y);
							}
							//System.out.println(y);
						}
						data=Integer.parseInt(number);
						
						//System.out.println("Height number: "+data);
						//System.out.println("Height units: "+units);
						
						
						
						
						if(units.equals("cm")) {
							if (data>=150 && data<=193) {
								hgtV=true;
								//System.out.println("valid height");
							}
							
						}
						else if (units.equals("in")) {
							if (data>=59 && data<=76) {
								hgtV=true;
								//System.out.println("valid height");
							}
							
						}
						else {
							//System.out.println("height parser is broken, or bad data");
						}
						
						
						data=Integer.parseInt(number);
						if (data>=2020 && data <= 2030)
							eyrV=true;
						break;
					case "hcl":
						hcl=true;
						i++;
						
						if (tokens[i].length()==7 && tokens[i].charAt(0)=='#') {
							if(Character.digit(tokens[i].charAt(1),16)!=-1 && 
									Character.digit(tokens[i].charAt(1),16)!=-1 && 
									Character.digit(tokens[i].charAt(2),16)!=-1 && 
									Character.digit(tokens[i].charAt(3),16)!=-1 && 
									Character.digit(tokens[i].charAt(4),16)!=-1 && 
									Character.digit(tokens[i].charAt(5),16)!=-1 && 
									Character.digit(tokens[i].charAt(6),16)!=-1 ) {
								//lol, then we've got a hex code
								hclV=true;
							}
						}
						
						break;
					case "ecl":
						ecl=true;
						i++;
						if (tokens[i].equals("amb")||tokens[i].equals("blu")||tokens[i].equals("brn")||tokens[i].equals("gry")||tokens[i].equals("grn")||tokens[i].equals("hzl")||tokens[i].equals("oth"))
							eclV=true;
						break;
					case "pid":
						pid=true;
						i++;
						if (tokens[i].length()==9 && tokens[i].matches("[0-9]+"))
							pidV=true;
						break;
					case "cid":
						cid=true;
						cidV=true;
						//we hackers now
						break;
					
					default:
						//code
					}
					
					
					
				}
				
				
				
				//PART 1: get count of occurrences in password
				//long count = password.chars().filter(ch -> ch ==targetChar).count();
				//if(count>=minimum && count<=maximum) {
					//finalCount1++;
				//}
				
				
				//PART 2: check positions A and B and ensure exactly one contains given letter. use xor
				//if (password.charAt(minimum-1)==targetChar ^ password.charAt(maximum-1)==targetChar){
					//finalCount2++;
				//}
				
				//}
			}
			
			}
			
			//end of file, also trigger end of passport thingy
			//then we have a new line, new passport
			if(byrV&&iyrV&&eyrV&&hgtV&&hclV&&eclV&&pidV) {
				mostlyValidPassports++;
				System.out.println("Moslty-Valid Passport");
			}					
			else if(byr&&iyr&&eyr&&hgt&&hcl&&ecl&&pid) {
				semiValidPassports++;
				System.out.println("Semi-Valid Passport");
			}
			
			else {
				System.out.println("Invalid Passport");
			}
			
			
			
			fileReader.close();
			System.out.println("Input complete.");
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File Read error");
			e.printStackTrace();
		}
		
		System.out.println("# of Semi-Valid Passports: "+(semiValidPassports+mostlyValidPassports));
		System.out.println("# of Moslty-Valid Passports: "+mostlyValidPassports);
		
	}	

}
