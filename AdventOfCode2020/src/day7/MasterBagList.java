package day7;

import java.util.LinkedList;

public class MasterBagList {
	
	LinkedList<BagType> bigList;
	
	public MasterBagList() {
		//I don't even know if this is necessary  I feel like it is?
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
		for(int i=0;i<bigList.size();i++) {
			//search the list of existing bags to find the one that matches
			if(bigList.get(i).isBag(adj,clr)) {
				return bigList.get(i);
			}
			
			
		}
		
		
		
		return null;
	}
}
