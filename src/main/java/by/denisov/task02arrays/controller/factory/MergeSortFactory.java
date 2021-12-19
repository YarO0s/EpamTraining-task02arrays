package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.Command;
import by.denisov.task02arrays.controller.command.MergeSortCommand;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractSortingAlgorithm;
import by.denisov.task02arrays.service.MergeSort;

public class MergeSortFactory implements SortAbstractFactory {
    private Message message;

    public MergeSortFactory(Message newMessage){
        message = newMessage;
    }

    @Override
    public MergeSort createSortInstance(){
        return new MergeSort();
    }

    @Override
    public ArrayData createArrayData() throws DataParsingException {
        try {
            ArrayData arrayData = new ArrayData();
            for(String i : message.getCommandData()){
                arrayData.add(Double.parseDouble(i));
            }
            return arrayData;
        } catch(Exception e){
            throw new DataParsingException();
        }
    }

    @Override
    public MergeSortCommand createCommand(ArrayData newArrayData, AbstractSortingAlgorithm newSortingAlgorithm){
        MergeSortCommand command = new MergeSortCommand(newArrayData, newSortingAlgorithm);
        return command;
    }
}
