package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.service.AbstractSortingAlgorithm;
import by.denisov.task02arrays.service.ShellSort;
import by.denisov.task02arrays.view.IOData;

public class ShellSortCommand implements Command{

    private ArrayData initArray;
    private AbstractSortingAlgorithm sortingAlgorithm;
    private IOData ioData = new IOData();

    public ShellSortCommand(ArrayData newInitArray, AbstractSortingAlgorithm newSortingAlgorithm){
        initArray = newInitArray;
        sortingAlgorithm = newSortingAlgorithm;
    }

    public void execute(){
        sortingAlgorithm.sort(initArray);
        ioData.writeData(""+initArray);
    }
}
