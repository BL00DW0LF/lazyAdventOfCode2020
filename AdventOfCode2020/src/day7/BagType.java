package day7;

import java.util.LinkedList;

public class BagType {
	String adjective;
	String color;
	
	LinkedList<BagType> contains;
	LinkedList<Integer> containsQuant;
	
	
	public BagType (String adj, String clr) {       
		//creation
		adjective=adj;
		color=clr;
		
		contains=new LinkedList<BagType>();
		containsQuant=new LinkedList<Integer>();
		
	}
	
	public BagType () {//compiler complained about variable not being initialized, so have to make a dummy initialization
		//creation
		adjective=null;
		color=null;
	}
	
	public void addBagInside(BagType newie, int quantity) {
		//add to list
		contains.add(newie);
		containsQuant.add(quantity);
		//should be synced for a given index
		
		
		
		
		
	}
	
	public boolean mayContain(String adj, String clr, MasterBagList bigList) {
		if (this.adjective.equals(adj) && this.color.equals(clr)) {
			//if this is the bag we are trying to find
			return true;
		}
		
		boolean doesItContain=false;
		for (int i=0;i<contains.size();i++) {
			//for each bagtype in contains
			
			if(contains.get(i).mayContain(adj, clr, bigList)) {
				doesItContain=true;
				//System.out.println(contains.get(i).getName()+" may contain target at i="+i);//why does this always say shiny gold?
				
			}
				
			
		}
		
		
		return doesItContain;
	}
	
	public boolean isBag(String adj, String clr) {
		if (this.adjective.equals(adj) && this.color.equals(clr)) {
			//if this is the bag we are trying to find
			return true;
		}
		return false;
		
	}
	
	public String getAdjective() {
		return adjective;
		
	}
	
	public String getColor() {
		return color;
		
	}
	
	public String getName() {
		String temp = adjective + " "+color;
		return temp;
		
	}
	
	public int typesInside() {
		return contains.size();
		
	}
	
	/*public void updateContainers(MasterBagList bigList) {
		for (int i=0; i<contains.size();i++) {
			//for each bag inside this object, update it from the master list
			
			
			
		}
		
		
		
	}*/
	
}
