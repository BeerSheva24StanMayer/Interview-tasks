package telran.interview;

import java.util.*;

public class MyArray<T> {
    private T defValue = null;
    HashMap<Integer, T> array;
    private int size;

    public MyArray(int size) {
        this.size = size;
        array = new HashMap<>();

    }

	public void setAll(T value) {
        this.defValue = value;
        array = new HashMap<>();
		
	}
    
	public void set(int index, T value) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array.put(index, value);
	}
	
	public T get(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array.getOrDefault(index, defValue);
	}

}