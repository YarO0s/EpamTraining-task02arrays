package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.SelectionSortCommand;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractOperation;
import by.denisov.task02arrays.service.SelectionSort;

public class SelectionSortFactory implements OperationsAbstractFactory {
    private Message message;

    public SelectionSortFactory(Message newMessage){
        message = newMessage;
    }

    @Override
    public SelectionSortCommand createCommand(){
        ArrayData arrayData = new ArrayData();

        SelectionSort sortingAlgorithm = new SelectionSort();

        SelectionSortCommand command = new SelectionSortCommand(arrayData, sortingAlgorithm, message);
        return command;
    }
}
