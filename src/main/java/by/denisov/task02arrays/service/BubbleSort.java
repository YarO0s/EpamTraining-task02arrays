package by.denisov.task02arrays.service;

import by.denisov.task02arrays.model.ArrayData;


//TODO decide about return value
//  -return instance and not void sort method
//  -return void and change object through link

public class BubbleSort implements AbstractSortingAlgorithm {
    public void sort(ArrayData initialInstance){
        ArrayData resultInstance = new ArrayData();
        for(int i =0; i<initialInstance.size(); i++){
            for(int i2 = initialInstance.size()-1; i2 > i; i2--){
                if(initialInstance.get(i2).doubleValue()>initialInstance.get(i2-1).doubleValue()){
                    double val = initialInstance.get(i2).doubleValue();
                    initialInstance.set(i2, initialInstance.get(i2-1));
                    initialInstance.set(i2-1, val);
                }
            }
        }
    }
}
