package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.BubbleSortCommand;
import by.denisov.task02arrays.controller.command.Command;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractSortingAlgorithm;
import by.denisov.task02arrays.service.BubbleSort;

//TODO: replace ArrayData with interface;
public class BubbleSortFactory implements SortAbstractFactory {

    private Message message;


    public BubbleSortFactory(Message newMessage){
        message = newMessage;
    }

    @Override
    public BubbleSort createSortInstance(){
        return new BubbleSort();
    }


    //TODO: validation
    @Override
    public ArrayData createArrayData() throws DataParsingException{
        ArrayData initArray = new ArrayData();
        for(String i : message.getCommandData()){
            try {
                initArray.add(Double.parseDouble(i));
            } catch(Exception e){
                throw new DataParsingException();
            }
        }
        return initArray;
    }

    @Override
    public BubbleSortCommand createCommand(ArrayData newArrayData, AbstractSortingAlgorithm sortingAlgorithm){
        BubbleSortCommand command = new BubbleSortCommand(newArrayData, sortingAlgorithm);
        return command;
    }

}
