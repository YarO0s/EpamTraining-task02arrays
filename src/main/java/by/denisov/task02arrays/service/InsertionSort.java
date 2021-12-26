package by.denisov.task02arrays.service;

import by.denisov.task02arrays.model.ArrayData;

/**
 * Insertion sort class
 */
public class InsertionSort implements AbstractOperation {

    /**
     * Sorts data using insertion sort approach
     * @param initialArray - input data set
     */
    public void sort(ArrayData initialArray){
        for (int i = 1; i < initialArray.size(); ++i) {
            double key = initialArray.get(i).doubleValue();
            int j = i - 1;

            while (j >= 0 && initialArray.get(j).doubleValue() < key) {
                initialArray.set(j + 1,initialArray.get(j).doubleValue());
                j = j - 1;
            }
            initialArray.set(j + 1, key);
        }
    }
}
