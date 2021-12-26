package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractOperation;
import by.denisov.task02arrays.service.ShellSort;
import by.denisov.task02arrays.service.Validation.ShellSortValidation;
import by.denisov.task02arrays.view.IOData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShellSortCommand implements Command{

    private ArrayData initArray;
    private ShellSort sortingAlgorithm;
    private IOData ioData = new IOData();
    private Message message;
    private ShellSortValidation validation;
    Logger logger = LogManager.getLogger();

    public ShellSortCommand(ArrayData newInitArray, ShellSort newSortingAlgorithm, Message newMessage){
        initArray = newInitArray;
        sortingAlgorithm = newSortingAlgorithm;
        message = newMessage;
    }

    public void execute(){
        validation = new ShellSortValidation(message);
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
