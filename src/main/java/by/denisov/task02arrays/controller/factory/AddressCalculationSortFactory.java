package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.AddressCalculationSortCommand;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractOperation;
import by.denisov.task02arrays.service.AddressCalculationSort;

public class AddressCalculationSortFactory implements OperationsAbstractFactory {


    private Message message;


    public AddressCalculationSortFactory(Message newMessage){
        message = newMessage;
    }

    @Override
    public AddressCalculationSortCommand createCommand() {
        ArrayData arrayData = new ArrayData();

        AddressCalculationSort addressCalculationSort = new AddressCalculationSort();

        AddressCalculationSortCommand command = new AddressCalculationSortCommand(arrayData, addressCalculationSort, message);
        return command;
    }

}
