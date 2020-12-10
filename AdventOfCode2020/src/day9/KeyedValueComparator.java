package day9;
import java.util.Comparator;
public class KeyedValueComparator implements Comparator<KeyedDataPair>{
	
	
	  @Override
	    public int compare(KeyedDataPair a, KeyedDataPair b) {
	        // TODO Auto-generated method stub
	        return Long.compare(a.getValue(), b.getValue());
	    }

}



