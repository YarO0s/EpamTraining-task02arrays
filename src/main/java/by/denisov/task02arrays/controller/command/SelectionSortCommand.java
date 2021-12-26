package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractOperation;
import by.denisov.task02arrays.service.SelectionSort;
import by.denisov.task02arrays.service.Validation.SelectionSortValidation;
import by.denisov.task02arrays.view.IOData;

public class SelectionSortCommand implements Command{

    private ArrayData initArray;
    private SelectionSort sortingAlgorithm;
    private IOData ioData = new IOData();
    private Message message;
    private SelectionSortValidation validation;

    public SelectionSortCommand(ArrayData newInitArray, SelectionSort newSortingAlgorithm, Message newMessage){
        initArray = newInitArray;
        sortingAlgorithm = newSortingAlgorithm;
        message = newMessage;
    }

    public void execute(){
        validation = new SelectionSortValidation(message);
        if(validation.isValid(initArray)){
            sortingAlgorithm.sort(initArray);
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR7);
            ioData.writeData(""+initArray);
        } else{
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR6);
        }
    }
}
