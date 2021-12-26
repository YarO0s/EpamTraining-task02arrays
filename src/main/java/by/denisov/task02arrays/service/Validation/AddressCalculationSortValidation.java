package by.denisov.task02arrays.service.Validation;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.DataValidationException;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;

public class AddressCalculationSortValidation {

    private Message message;

    public AddressCalculationSortValidation(Message newMessage){
        message = newMessage;
    }

    public boolean isValid(ArrayData arrayData) {
        boolean valid = true;
        try {
            for(String i : message.getCommandData()){
                arrayData.add(Double.parseDouble(i));
            }
        } catch(Exception e){
            valid = false;
        }
        return valid;
    }

}
