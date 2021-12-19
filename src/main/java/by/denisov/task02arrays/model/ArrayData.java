package by.denisov.task02arrays.model;

import java.util.*;

public class ArrayData {
    private final List data = new LinkedList<Number>();

    public int size(){
        return data.size();
    }

    public <T extends Number>void add(T initValue){
        data.add(initValue);
    }

    public <T extends Number> T get(int index){
        T returnValue = (T) data.get(index);
        return returnValue;
    }

    //public <T extends Number> T[] getAll(){
        //T[] array = new T[data.size()];
    //}

    public void set(int i2, Number number) {
        data.set(i2, number);
    }

    public void addAll(double[] values){
        for(int i = 0; i< values.length; i++){
            double val = values[i];
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
            ArrayData arrayData = (ArrayData) o;
            if (this.size() != arrayData.size()) {
                return false;
            }
            for (int i = 0; i < this.size(); i++) {
                double thisvalue = this.get(i);
                double outervalue = arrayData.get(i);
                if (thisvalue != outervalue) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
