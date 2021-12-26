package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractOperation;
import by.denisov.task02arrays.service.AddressCalculationSort;
import by.denisov.task02arrays.service.Validation.AddressCalculationSortValidation;
import by.denisov.task02arrays.view.IOData;

//TODO: replace system.out.println
public class AddressCalculationSortCommand implements Command {

    private ArrayData initArray;
    private Message message;
    private AddressCalculationSort sortingAlgorithm;
    private AddressCalculationSortValidation validation;
    private IOData ioData = new IOData();

    public AddressCalculationSortCommand(ArrayData newInitArray, AddressCalculationSort newSortingAlgorithm, Message newMessage){
        initArray = newInitArray;
        sortingAlgorithm = newSortingAlgorithm;
        message = newMessage;
    }

    public void execute(){
        validation = new AddressCalculationSortValidation(message);
        if(validation.isValid(initArray)){
            sortingAlgorithm.sort(initArray);
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR7);
            ioData.writeData(""+initArray);
        } else{
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR6);
        }
    }
}
