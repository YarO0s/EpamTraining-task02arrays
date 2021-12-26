package by.denisov.task02arrays.service;

import by.denisov.task02arrays.model.ArrayData;

import java.util.LinkedList;


/**
 *  Address calculation sort method class
 */
public class AddressCalculationSort implements AbstractOperation {

    //max value of data set
    private double maxValue = 0;

    //partitions
    private LinkedList<Double> array[] = new LinkedList[4];

    /**
     * sorts the data, calls getValueHash and addWithSort methods
     * @param initialArray - input values;
     */
    public void sort(ArrayData initialArray){
        maxValue = initialArray.get(0).doubleValue();
        for(int i = 1; i < initialArray.size(); i++){
            if (maxValue < initialArray.get(i).doubleValue()){
                maxValue = initialArray.get(i).doubleValue();
            }
        }
        for(int i = 0; i < array.length; i++){
            array[i] = new LinkedList<Double>();
        }
        for(int i = 0; i < initialArray.size(); i++){
            double value = initialArray.get(i).doubleValue();
            int valueMapIndex = getValueHash(value);
            addWithSort(valueMapIndex, value);
        }

        initialArray.clear();
        for(int i = array.length-1; i>=0; i--){
            initialArray.addAll(array[i].toArray(new Double[array[i].size()]));
        }
    }

    /**
     * calculates hash of the value to define the appropriate position
     * @param value - input value
     * @return the partition id
     */
    private int getValueHash(double value){
        return (int)Math.floor((value/maxValue)*(array.length-1));
    }

    /**
     *  adds value to the appropriate partition using insertion sort
     * @param address - hash address of value
     * @param value - value itself
     */
    private void addWithSort(int address, double value){
        LinkedList<Double> list = array[address];
        if(list.size() == 0){
            list.add(value);
            return;
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).doubleValue()<value){
                double valueToChange = list.get(i).doubleValue();
                list.set(i, value);
                value = valueToChange;
            }
            if(i == list.size()-1){
                list.add(value);
                return;
            }
        }
    }
}
