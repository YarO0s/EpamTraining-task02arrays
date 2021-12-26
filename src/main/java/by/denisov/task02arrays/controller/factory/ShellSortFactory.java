package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.ShellSortCommand;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractOperation;
import by.denisov.task02arrays.service.ShellSort;

public class ShellSortFactory implements OperationsAbstractFactory {
    private Message message;

    public ShellSortFactory(Message newMessage){
        message = newMessage;
    }

    @Override
    public ShellSortCommand createCommand(){
        ArrayData arrayData = new ArrayData();

        ShellSort sortingAlgorithm = new ShellSort();

        ShellSortCommand command = new ShellSortCommand(arrayData, sortingAlgorithm, message);
        return command;
    }
}
