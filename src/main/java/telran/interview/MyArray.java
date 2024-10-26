package telran.interview;

public class MyArray<T> {
    private T defValue;
    private boolean isSetDefault;
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArray(int size) {
        this.size = size;
        this.isSetDefault = false;
        this.array = (T[])new Object[size];

    }

	public void setAll(T value) {
        this.defValue = value;
        this.isSetDefault = true;
		
	}
    
	public void set(int index, T value) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(isSetDefault && !defValue.equals(value)) {
            array[index] = value;
            isSetDefault = false;
        }
        else if(!isSetDefault) {
            array[index] = value;
        }
	}
	
	public T get(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return isSetDefault ? defValue : array[index];
	}

}