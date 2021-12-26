package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.InsertionSort;
import by.denisov.task02arrays.service.Validation.InsertionSortValidation;
import by.denisov.task02arrays.view.IOData;

public class InsertionSortCommand implements Command{

    private ArrayData initArray;
    private InsertionSort sortingAlgorithm;
    private Message message;
    private IOData ioData = new IOData();
    private InsertionSortValidation validation;

    public InsertionSortCommand(ArrayData newInitArray, InsertionSort newSortingAlgorithm, Message newMessage){
        initArray = newInitArray;
        sortingAlgorithm = newSortingAlgorithm;
        message = newMessage;
    }

    public void execute(){
        validation = new InsertionSortValidation(message);
        if(validation.isValid(initArray)){
            sortingAlgorithm.sort(initArray);
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR7);
            ioData.writeData(""+initArray);
        } else{
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR6);
        }
    }
}
