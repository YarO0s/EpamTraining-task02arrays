package by.denisov.task02arrays.service;

import by.denisov.task02arrays.model.ArrayData;

public class ShakerSort implements AbstractSortingAlgorithm {
    public void sort(ArrayData initialArray) {
        for(int i = 0; i<initialArray.size()/2; i++){
            boolean swapped = false;

            for(int i2 = i; i2 < initialArray.size()-i-1; i2++){
                if(initialArray.get(i2).doubleValue()<initialArray.get(i2+1).doubleValue()){
                   double val = initialArray.get(i2).doubleValue();
                   initialArray.set(i2, initialArray.get(i2+1));
                   initialArray.set(i2+1, val);
                   swapped = true;
                }
            }

            for(int i2 = initialArray.size()-2-i; i2>i; i2--){
                if(initialArray.get(i2).doubleValue()>initialArray.get(i2-1).doubleValue()){
                    double val = initialArray.get(i2).doubleValue();
                    initialArray.set(i2, initialArray.get(i2-1));
                    initialArray.set(i2-1, val);
                    swapped = true;
                }
            }
            if(!swapped){
                return;
            }
        }
    }
}
