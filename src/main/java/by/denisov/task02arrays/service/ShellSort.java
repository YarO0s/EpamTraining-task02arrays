package by.denisov.task02arrays.service;

import by.denisov.task02arrays.model.ArrayData;

public class ShellSort implements AbstractSortingAlgorithm{
    public void sort(ArrayData initialArray){
        for (int i = initialArray.size()/2; i > 0; i /= 2)
        {
            for (int i2 = i; i2 < initialArray.size(); i2 += 1)
            {
                double temp = initialArray.get(i);

                int j;
                for (j = i2; j >= i && initialArray.get(j-i).doubleValue() > temp; j -= i){
                    initialArray.set(j, initialArray.get(j - i));
                }
                initialArray.set(j, temp);
            }
        }
    }
}
