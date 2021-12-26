package by.denisov.task02arrays.service;

import by.denisov.task02arrays.model.ArrayData;

public class ShellSort implements AbstractOperation {
    /**
     * Performs shell sort operation
     * @param initialArray - initial data set
     */
    public void sort(ArrayData initialArray){
        for (int interval = initialArray.size() / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < initialArray.size(); i += 1) {
                double temp = initialArray.get(i).doubleValue();
                int j;
                for (j = i; j >= interval && initialArray.get(j-interval).doubleValue() < temp; j -= interval) {
                    initialArray.set(j, initialArray.get(j-interval).doubleValue());
                }
                initialArray.set(j, temp);
            }
        }
    }
}
