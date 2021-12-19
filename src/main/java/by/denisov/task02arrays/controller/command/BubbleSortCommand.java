package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.service.AbstractSortingAlgorithm;

public class BubbleSortCommand implements Command{

    private ArrayData initArray;
    private AbstractSortingAlgorithm sortingAlgorithm;

    public BubbleSortCommand(ArrayData newInitArray, AbstractSortingAlgorithm newSortingAlgorithm){
        initArray = newInitArray;
        sortingAlgorithm = newSortingAlgorithm;
    }

    public void execute(){
          sortingAlgorithm.sort(initArray);
          System.out.println(initArray);
    }

}
