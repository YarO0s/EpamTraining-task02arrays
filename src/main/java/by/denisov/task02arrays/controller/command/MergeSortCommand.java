package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractOperation;
import by.denisov.task02arrays.service.MergeSort;
import by.denisov.task02arrays.service.Validation.MergeSortValidation;
import by.denisov.task02arrays.view.IOData;

public class MergeSortCommand implements Command{

    private ArrayData initArray;
    private MergeSort sortingAlgorithm;
    private IOData ioData = new IOData();
    private MergeSortValidation validation;
    private Message message;

    public MergeSortCommand(ArrayData newInitArray, MergeSort newSortingAlgorithm, Message newMessage){
        sortingAlgorithm = newSortingAlgorithm;
        initArray = newInitArray;
        message = newMessage;
    }

    public void execute(){
        validation = new MergeSortValidation(message);
        if(validation.isValid(initArray)){
            sortingAlgorithm.sort(initArray);
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR7);
            ioData.writeData(""+initArray);
        } else{
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR6);
        }
    }
}
