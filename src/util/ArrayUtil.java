package util;

import java.util.ArrayList;

public class ArrayUtil<E>{

	public boolean isAllEqual(ArrayList<E> a){
		E head = a.get(0);
		for (Object object : a) {
			if(!head.equals(object)) return false;
		}
        return true;
    }

}
