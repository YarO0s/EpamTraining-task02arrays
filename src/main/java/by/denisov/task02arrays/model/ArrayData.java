package by.denisov.task02arrays.model;

import java.util.*;

public class ArrayData<T extends Number> {
    private final List data = new LinkedList<Number>();

    public int size(){
        return data.size();
    }

    public void add(T initValue){
        data.add(initValue);
    }

    public T get(int index){
        T returnValue = (T) data.get(index);
        return returnValue;
    }

    public void clear(){
        data.clear();
    }

    public void set(int i2, T number) {
        data.set(i2, number);
    }

    public void addAll(T... values){
        for(int i = 0; i< values.length; i++){
            T val = values[i];
            data.add(val);
        }
    }

    public String toString(){
        String resultString = "";
        for(int i = 0; i < data.size(); i++){
            resultString+=data.get(i)+" ";
        }
        return resultString;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof ArrayData) {
            ArrayData<T> arrayData = (ArrayData) o;
            if (this.size() != arrayData.size()) {
                return false;
            }
            for (int i = 0; i < this.size(); i++) {
                T instanceValue = this.get(i);
                T outerValue = arrayData.get(i);
                if (!instanceValue.equals(outerValue)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
