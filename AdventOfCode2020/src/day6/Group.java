package day6;

public class Group {
	
	String answers;
	String unanimous;
	int people;//is this even needed? looks like no, but I started with it
	int numQs;
	
	
	public Group () {       
		//creation
		answers="";
		numQs=0;
		people=0;//no people
		
		
		unanimous="";
		// for part 2
		
	}
	
	
	public void addPerson(String dataIn) {
		
		//for part 1
		for (int i=0;i<dataIn.length();i++) {
			
			
				if (!(this.contains(dataIn.charAt(i)))) {
					answers=answers+dataIn.charAt(i);
					numQs++;//counting number of unique responses
				}
				
				
				
						
		}
		
		//for part 2
		if (people==0) {
			unanimous=answers.toString();
			//if this is the first person added, then just trust the data already in answers at the end
			//the first person could be pretty powerful, as their answers dominate what everyone else must abide by
		}
		else {
			//then we need to do some more complicated comparing
			this.compareUnanimous(dataIn);
			
		}
				
		people++;//one extra person
				
		
		
	}
	
	
	
	public boolean contains(char letter) {
		
		for (int i=0;i<answers.length();i++) {
			if (answers.charAt(i) == letter)
				return true;
		}
		
		return false;
		
	}
	
	public int getPeople(){
		return people;
	}
	
	public int getNumQs() {
		return numQs;
	}

	
	//for part 2
	public void compareUnanimous(String dataIn) {
		StringBuilder sb = new StringBuilder(unanimous);
		
		
		//for each char in unanimous
		for (int i=0;i<sb.length();i++) {
			boolean containsChar=false;
			int y=0;
			//check input to see if it exists
			
			while(!containsChar && y<dataIn.length()) {
				// if the character in unanimous exists at the current position in dataIn
				if (sb.charAt(i) == dataIn.charAt(y)) {
					containsChar=true;//stop searching
					
				}
				else {
					y++;// else check next char in dataIn
					
				}
			}//end while, at this point we know whether the character exists in input data
			
			if(!containsChar){
				//if it doesn't exist, we need to cut the char out of unanimous
				sb.deleteCharAt(i);
				
				//and decrement index i so we don't skip a letter
				i--;
			}
			
			
			
					
		}//end for each char in unanimous
		
		unanimous = sb.toString();//save changes
		
	}
	
	public int getUnanimous() {
		return unanimous.length();
	}
}
