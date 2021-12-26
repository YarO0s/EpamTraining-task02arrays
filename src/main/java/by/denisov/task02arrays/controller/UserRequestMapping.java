package by.denisov.task02arrays.controller;

import by.denisov.task02arrays.controller.command.*;
import by.denisov.task02arrays.controller.factory.*;
import by.denisov.task02arrays.model.AbstractMessage;
import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.model.MatrixMessage;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.view.IOData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserRequestMapping {

    IOData ioData = new IOData();

    Logger logger = LogManager.getLogger();

    public Command getCommand(AbstractMessage message){

        OperationsAbstractFactory operationsAbstractFactory = null;

        switch (message.getCommandMessage()) {
            case "exit":
                return new ExitCommand();

            case "help":
                break;

            case "bubblesort":
                operationsAbstractFactory = new BubbleSortFactory((Message)message);
                break;

            case "insertionsort":
                operationsAbstractFactory = new InsertionSortFactory((Message)message);
                break;

            case "mergesort":
                operationsAbstractFactory = new MergeSortFactory((Message)message);
                break;

            case "selectionsort":
                operationsAbstractFactory = new SelectionSortFactory((Message)message);
                break;

            case "shakersort":
                operationsAbstractFactory = new ShakerSortFactory((Message)message);
                break;

            case "shellsort":
                operationsAbstractFactory = new ShellSortFactory((Message)message);
                break;

            case "addresscalcsort":
                operationsAbstractFactory = new AddressCalculationSortFactory((Message)message);
                break;

            case "multiplymatrix":
                operationsAbstractFactory = new MatrixMultiplicationCommandFactory((MatrixMessage)message);
                break;

            case "subtractmatrix":
                operationsAbstractFactory = new MatrixSubtractionCommandFactory((MatrixMessage)message);
                break;

            case "summatrix":
                operationsAbstractFactory = new MatrixSumCommandFactory((MatrixMessage)message);
                break;
            case "setlang":
                return new SetLanguageCommand((Message)message);
        }

            Command resultCommand = null;

        if(operationsAbstractFactory!=null) {

            try {
                resultCommand = operationsAbstractFactory.createCommand();
            } catch (DataParsingException e){
                ioData.writeLocalisedData(LocaleManager.MessageKeys.STR3);
                logger.log(Level.ERROR, "Error while creating command");
                return null;
            }

        } else {
            IOData ioData = new IOData();
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR4);
        }

        return resultCommand;
    }
}
