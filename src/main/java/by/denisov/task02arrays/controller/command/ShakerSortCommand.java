package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractOperation;
import by.denisov.task02arrays.service.ShakerSort;
import by.denisov.task02arrays.service.Validation.ShakerSortValidation;
import by.denisov.task02arrays.view.IOData;
import by.denisov.task02arrays.model.Message;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShakerSortCommand implements Command{

    private ArrayData initArray;
    private ShakerSort sortingAlgorithm;
    private IOData ioData = new IOData();
    private Message message;
    private ShakerSortValidation validation;
    Logger logger = LogManager.getLogger();

    public ShakerSortCommand(ArrayData newInitArray, ShakerSort newSortingAlgorithm, Message newMessage){
        initArray = newInitArray;
        sortingAlgorithm = newSortingAlgorithm;
        message = newMessage;
    }

    public void execute(){
        validation = new ShakerSortValidation(message);
        if(validation.isValid(initArray)){
            sortingAlgorithm.sort(initArray);
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR7);
            ioData.writeData(""+initArray);
        } else{
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR6);
            logger.log(Level.DEBUG, "Shell sort data failed validation");
        }
    }
}
