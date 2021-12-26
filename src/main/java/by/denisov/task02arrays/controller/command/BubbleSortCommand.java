package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractOperation;
import by.denisov.task02arrays.service.BubbleSort;
import by.denisov.task02arrays.service.Validation.BubbleSortValidation;
import by.denisov.task02arrays.view.IOData;

public class BubbleSortCommand implements Command{

    private ArrayData initArray;
    private BubbleSort sortingAlgorithm;
    private Message message;
    private BubbleSortValidation validation;
    private IOData ioData = new IOData();


    public BubbleSortCommand(ArrayData newInitArray, BubbleSort newSortingAlgorithm, Message newMessage){
        initArray = newInitArray;
        sortingAlgorithm = newSortingAlgorithm;
        message = newMessage;
    }

    public void execute(){
          validation = new BubbleSortValidation(message);
          if(validation.isValid(initArray)) {
              sortingAlgorithm.sort(initArray);
              ioData.writeLocalisedData(LocaleManager.MessageKeys.STR7);
              ioData.writeData(""+initArray);
          } else{
              ioData.writeLocalisedData(LocaleManager.MessageKeys.STR6);
          }
    }

}
