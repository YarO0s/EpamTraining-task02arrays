package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.SelectionSortCommand;
import by.denisov.task02arrays.controller.command.ShakerSortCommand;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractSortingAlgorithm;
import by.denisov.task02arrays.service.SelectionSort;
import by.denisov.task02arrays.service.ShakerSort;

public class ShakerSortFactory implements SortAbstractFactory {
    private Message message;

    public ShakerSortFactory(Message newMessage){
        message = newMessage;
    }

    @Override
    public ShakerSort createSortInstance(){
        return new ShakerSort();
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
    public ShakerSortCommand createCommand(ArrayData newArrayData, AbstractSortingAlgorithm newSortingAlgorithm){
        ShakerSortCommand command = new ShakerSortCommand(newArrayData, newSortingAlgorithm);
        return command;
    }
}
