package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.BubbleSortCommand;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractOperation;
import by.denisov.task02arrays.service.BubbleSort;

//TODO: replace ArrayData with interface;
public class BubbleSortFactory implements OperationsAbstractFactory {

    private Message message;


    public BubbleSortFactory(Message newMessage){
        message = newMessage;
    }

    @Override
    public BubbleSortCommand createCommand() throws DataParsingException{
        ArrayData arrayData = new ArrayData();

        BubbleSort sortingAlgorithm = new BubbleSort();

        BubbleSortCommand command = new BubbleSortCommand(arrayData, sortingAlgorithm, message);
        return command;
    }

}
