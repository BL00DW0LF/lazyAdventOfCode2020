package day9;

public class KeyedDataPair {
	int index;
	long value;
	
	public KeyedDataPair(int i,long v){
		index=i;
		value=v;
		
	}
	
	public long getValue() {
		return this.value;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public String toString(){
        return "(" + this.index + ", " + this.value + ")";
    }
}

