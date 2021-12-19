package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.service.AbstractSortingAlgorithm;
import by.denisov.task02arrays.service.InsertionSort1;
import by.denisov.task02arrays.service.MergeSort;
import by.denisov.task02arrays.view.IOData;

public class MergeSortCommand implements Command{

    private ArrayData initArray;
    private AbstractSortingAlgorithm sortingAlgorithm;
    private IOData ioData = new IOData();

    public MergeSortCommand(ArrayData newInitArray, AbstractSortingAlgorithm newSortingAlgorithm){
        sortingAlgorithm = newSortingAlgorithm;
    }

    public void execute(){
        //sortingAlgorithm.sort(initArray);
        ioData.writeData(""+initArray);
    }
}
