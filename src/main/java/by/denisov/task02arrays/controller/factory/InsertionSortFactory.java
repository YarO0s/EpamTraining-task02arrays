package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.InsertionSortCommand;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.InsertionSort;

public class InsertionSortFactory implements OperationsAbstractFactory {

    private Message message;

    public InsertionSortFactory(Message newMessage){
        message = newMessage;
    }

    @Override
    public InsertionSortCommand createCommand(){
        ArrayData arrayData = new ArrayData();

        InsertionSort sortingAlgorithm = new InsertionSort();

        InsertionSortCommand command = new InsertionSortCommand(arrayData, sortingAlgorithm, message);
        return command;
    }

}
