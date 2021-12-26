package by.denisov.task02arrays.service;

import by.denisov.task02arrays.model.ArrayData;

import java.util.Arrays;

public class MergeSort implements AbstractOperation {

    /**
     * Merge sort algorithm interface method
     * @param arrayInstance - input data set as ArrayData instance
     */
    public void sort(ArrayData arrayInstance) {
        double initialArray[] = new double[arrayInstance.size()];
        for(int i = 0; i<arrayInstance.size();i++){
            initialArray[i] = arrayInstance.get(i).doubleValue();
        }
        initialArray = sort(initialArray);
        arrayInstance.clear();
        for(double value : initialArray){
        arrayInstance.add(value);
        }
    }

    /**
     * Performs actual sorting operation
     * @param initialArray - input data set as primitive array
     * @return result
     */
    private double[] sort(double initialArray[]){
        if(initialArray.length<=1){
            return initialArray;
        }
        double[] leftArray = Arrays.copyOfRange(initialArray,0, initialArray.length/2);

        double[] rightArray = Arrays.copyOfRange(initialArray, initialArray.length/2, initialArray.length);

        return merge(sort(leftArray), sort(rightArray));
    }

    /**
     * performs merging and comparison operations
     * @param leftArray - left array partition
     * @param rightArray - right array partition
     * @return merged and sorted array partitions
     */
    private double[] merge(double[] leftArray, double[] rightArray){
        int leftIndex = 0;
        int rightIndex = 0;
        double[] resultArray = new double[leftArray.length + rightArray.length];

        for(int i = 0; i < resultArray.length; i++){
            if(leftIndex==leftArray.length){
                resultArray[i] = rightArray[rightIndex++];
            }
            else if(rightIndex==rightArray.length){
                resultArray[i] = leftArray[leftIndex++];
            }
            else if(leftArray[leftIndex]>=rightArray[rightIndex]){
                resultArray[i] = leftArray[leftIndex++];
            }
            else if(rightArray[rightIndex]>=leftArray[leftIndex]){
                resultArray[i] = rightArray[rightIndex++];
            }
        }

        return resultArray;
    }
}

