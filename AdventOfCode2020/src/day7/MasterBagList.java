package day7;

import java.util.LinkedList;

public class MasterBagList {
	
	LinkedList<BagType> bigList;
	
	public MasterBagList() {
		//I don't even know if this is necessary  I feel like it is?
		//it was necessary, I forgot to initialize the variable duh
		
		bigList=new LinkedList<BagType>();
	}
	
	
	
	public void addBag(BagType bagIn) {
		if (findBag(bagIn.getAdjective(),bagIn.getColor()) == null) {
			//if the bag does not exist already, create an entry for it
			bigList.add(bagIn);
			
			
		}
		else {
			System.out.println("Bag exists in master list already");
		}
		
		
		
		
		
		
		
	}
	
	public BagType findBag(String adj, String clr) {
		if(!(bigList==null)) {//don't call bigList.size on null list
			
		
		for(int i=0;i<bigList.size();i++) {
			//search the list of existing bags to find the one that matches
			if(bigList.get(i).isBag(adj,clr)) {
				return bigList.get(i);
			}
			
			
		}
		
		
		}//endif
		return null;
	}
	
	
	
	public int size() {
		
		return bigList.size();
	}
	
	
	public BagType getBag(int index) {
		return bigList.get(index);
		
	}
	
	public int mayContain(String adj, String clr) {
		int containerCount=0;//counter for part 1
		//LinkedList<String> adjectives= new LinkedList<String>();
		//LinkedList<String> colors= new LinkedList<String>();
		
		for(int i=0; i<bigList.size();i++) {
			
			if (bigList.get(i).mayContain(adj, clr, this)) {//if the bag exists within
				
				if (bigList.get(i).getName().equals(adj+" "+clr)) {//if it's the bag we're looking for in the first place, ignore
					System.out.println("This is just the bag you're looking for.");//dont count itself
				}
				else
				{//count it as something that immediately contains target bags
					containerCount++;
					
					//add it to the list of bags that may contain target bag
					//adjectives.add(adj);
					//colors.add(clr);
					//System.out.println("adding "+adj+ " "+clr+" to list");
				//}
				
			}//end if we found the bag
				
			
		}//end for.  should have all bags that immediately contain target counted.  now count all bags that may contain those
		
		//for (int y=0;y<adjectives.size();y++){
			//containerCount+=this.mayContain(adjectives.get(y), colors.get(y));
			
		//}
		
		
		
		
	}
		return containerCount;
	}
	
	/*public void updateAll() {
		for(int i=0; i<bigList.size();i++) {
			bigList.get(i).updateContainers(this);
			
			
			
		}
		
	}*/
	
}
