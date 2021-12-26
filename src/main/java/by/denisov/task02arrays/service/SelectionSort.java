package by.denisov.task02arrays.service;

import by.denisov.task02arrays.model.ArrayData;

public class SelectionSort implements AbstractOperation {

    /**
     * Performs sorting operation using selection sort approach
     * @param initialArray initial data set
     */
    public void sort(ArrayData initialArray){
        for (int i = 0; i < initialArray.size()-1; i++)
        {
            int max = i;
            for (int j = i+1; j < initialArray.size(); j++)
                if (initialArray.get(j).doubleValue() > initialArray.get(max).doubleValue())
                    max = j;

            double temp = initialArray.get(max).doubleValue();
            initialArray.set(max, initialArray.get(i));
            initialArray.set(i, temp);
        }
    }

}
