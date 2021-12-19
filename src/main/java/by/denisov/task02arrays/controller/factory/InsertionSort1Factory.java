package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.Command;
import by.denisov.task02arrays.controller.command.InsertionSort1Command;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractSortingAlgorithm;
import by.denisov.task02arrays.service.InsertionSort1;

public class InsertionSort1Factory implements SortAbstractFactory {

    private Message message;

    public InsertionSort1Factory(Message newMessage){
        message = newMessage;
    }

    @Override
    public InsertionSort1 createSortInstance(){
        return new InsertionSort1();
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
    public InsertionSort1Command createCommand(ArrayData newArrayData, AbstractSortingAlgorithm sortingAlgorithm){
        InsertionSort1Command command = new InsertionSort1Command(newArrayData, sortingAlgorithm);
        return command;
    }

}
