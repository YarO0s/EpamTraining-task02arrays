package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.Command;
import by.denisov.task02arrays.controller.command.MergeSortCommand;
import by.denisov.task02arrays.controller.command.SelectionSortCommand;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractSortingAlgorithm;
import by.denisov.task02arrays.service.MergeSort;
import by.denisov.task02arrays.service.SelectionSort;

public class SelectionSortFactory implements SortAbstractFactory {
    private Message message;

    public SelectionSortFactory(Message newMessage){
        message = newMessage;
    }

    @Override
    public SelectionSort createSortInstance(){
        return new SelectionSort();
    }

    @Override
    public ArrayData createArrayData() throws DataParsingException{
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
    public SelectionSortCommand createCommand(ArrayData newArrayData, AbstractSortingAlgorithm newSortingAlgorithm){
        SelectionSortCommand command = new SelectionSortCommand(newArrayData, newSortingAlgorithm);
        return command;
    }
}
