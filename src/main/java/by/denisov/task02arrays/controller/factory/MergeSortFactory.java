package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.MergeSortCommand;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractOperation;
import by.denisov.task02arrays.service.MergeSort;

public class MergeSortFactory implements OperationsAbstractFactory {
    private Message message;

    public MergeSortFactory(Message newMessage){
        message = newMessage;
    }

    @Override
    public MergeSortCommand createCommand(){
        ArrayData arrayData = new ArrayData();

        MergeSort sortingAlgorithm = new MergeSort();

        MergeSortCommand command = new MergeSortCommand(arrayData, sortingAlgorithm, message);
        return command;
    }
}
