package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.SelectionSortCommand;
import by.denisov.task02arrays.controller.command.ShellSortCommand;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractSortingAlgorithm;
import by.denisov.task02arrays.service.SelectionSort;
import by.denisov.task02arrays.service.ShellSort;

public class ShellSortFactory implements SortAbstractFactory{
    private Message message;

    public ShellSortFactory(Message newMessage){
        message = newMessage;
    }

    @Override
    public ShellSort createSortInstance(){
        return new ShellSort();
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
    public ShellSortCommand createCommand(ArrayData newArrayData, AbstractSortingAlgorithm newSortingAlgorithm){
        ShellSortCommand command = new ShellSortCommand(newArrayData, newSortingAlgorithm);
        return command;
    }
}
