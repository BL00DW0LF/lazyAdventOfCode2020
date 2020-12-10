package day9;
import java.util.Comparator;
public class KeyedIndexComparator implements Comparator<KeyedDataPair>{

    @Override
    public int compare(KeyedDataPair a, KeyedDataPair b) {
        // TODO Auto-generated method stub
    	return Integer.compare(a.getIndex(), b.getIndex());
    }
	
	
}
