package by.denisov.task02arrays.service;

import by.denisov.task02arrays.model.ArrayData;

public class MergeSort implements AbstractSortingAlgorithm {

    @Override
    public void sort(ArrayData initArray) {

    }
    /*public ArrayData sort(ArrayData initialData){
        if(initialData.size()==1){
            return initialData;
        }
        double[] leftArray = new double[initialData.size()/2];
        for(int i = 0;i < initialData.size()/2; i++){
            leftArray[i] = initialData.get(i);
        }
        double[] rightArray = new double[initialData.size()- leftArray.length];
        for(int i = initialData.size()/2; i < initialData.size(); i++){
            rightArray[i] = initialData.get(i);
        }

        return merge(leftArray, rightArray);
    }

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
            else if(leftArray[leftIndex]>rightArray[rightIndex]){
                resultArray[i] = leftArray[leftIndex++];
            }
            else if(rightArray[rightIndex]>leftArray[leftIndex]){
                resultArray[i] = rightArray[rightIndex++];
            }
        }
        return resultArray;
    }*/
}

