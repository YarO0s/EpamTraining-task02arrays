package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.service.AbstractSortingAlgorithm;
import by.denisov.task02arrays.service.InsertionSort1;
import by.denisov.task02arrays.view.IOData;

public class InsertionSort1Command implements Command{

    //TODO: remove outprint with IOData

    private ArrayData initArray;
    private AbstractSortingAlgorithm sortingAlgorithm = new InsertionSort1();
    private IOData ioData = new IOData();

    public InsertionSort1Command(ArrayData newInitArray, AbstractSortingAlgorithm newSortingAlgorithm){
        initArray = newInitArray;
        sortingAlgorithm = newSortingAlgorithm;
    }

    public void execute(){
        sortingAlgorithm.sort(initArray);
        ioData.writeData(""+initArray);
    }
}
