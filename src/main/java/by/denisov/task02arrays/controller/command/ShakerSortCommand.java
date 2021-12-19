package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.service.AbstractSortingAlgorithm;
import by.denisov.task02arrays.service.ShakerSort;
import by.denisov.task02arrays.view.IOData;

public class ShakerSortCommand implements Command{

    private ArrayData initArray;
    private AbstractSortingAlgorithm sortingAlgorithm = new ShakerSort();
    private IOData ioData = new IOData();

    public ShakerSortCommand(ArrayData newInitArray, AbstractSortingAlgorithm newSortingAlgorithm){
        initArray = newInitArray;
        sortingAlgorithm = newSortingAlgorithm;
    }

    public void execute(){
        sortingAlgorithm.sort(initArray);
        ioData.writeData(""+initArray);
    }
}
