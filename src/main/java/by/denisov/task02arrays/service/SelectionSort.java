package by.denisov.task02arrays.service;

import by.denisov.task02arrays.model.ArrayData;

public class SelectionSort implements AbstractSortingAlgorithm {
    public void sort(ArrayData initialArray){
        for (int i = 0; i < initialArray.size()-1; i++)
        {
            // Find the minimum element in unsorted array
            int max = i;
            for (int j = i+1; j < initialArray.size(); j++)
                if (initialArray.get(j).doubleValue() > initialArray.get(max).doubleValue())
                    max = j;

            double temp = initialArray.get(max);
            initialArray.set(max, initialArray.get(i));
            initialArray.set(i, temp);
        }
    }

}
