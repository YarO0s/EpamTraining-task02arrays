package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.ShakerSortCommand;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractOperation;
import by.denisov.task02arrays.service.ShakerSort;

public class ShakerSortFactory implements OperationsAbstractFactory {
    private Message message;

    public ShakerSortFactory(Message newMessage){
        message = newMessage;
    }

    @Override
    public ShakerSortCommand createCommand(){
        ArrayData arrayData = new ArrayData();

        ShakerSort sortingAlgorithm = new ShakerSort();

        ShakerSortCommand command = new ShakerSortCommand(arrayData, sortingAlgorithm, message);
        return command;
    }
}
