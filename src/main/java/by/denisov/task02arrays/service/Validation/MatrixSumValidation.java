package by.denisov.task02arrays.service.Validation;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Matrix;
import by.denisov.task02arrays.model.MatrixMessage;
import by.denisov.task02arrays.model.Message;

public class MatrixSumValidation {
    private MatrixMessage message;

    public MatrixSumValidation(MatrixMessage newMessage){
        message = newMessage;
    }

    public boolean isValid(Matrix firstOperand, Matrix secondOperand) {
        if(firstOperand.getVerticalLength()!= secondOperand.getVerticalLength() ||
                firstOperand.getHorizontalLength()!= secondOperand.getHorizontalLength()){
            return false;
        }
        try{
            dataParseValidation(firstOperand);
            dataParseValidation(secondOperand);
        } catch (DataParsingException parsingException){
            return false;
        }
        return true;
    }

    private void dataParseValidation(Matrix initialMatrix) throws DataParsingException {
        try {
            for (int i2 = 0; i2 < initialMatrix.getHorizontalLength(); i2++) {
                for (int i3 = 0; i3 < initialMatrix.getVerticalLength(); i3++) {
                    initialMatrix.set(i2, i3, Double.parseDouble(message.getCommandData(0)[i2][i3]));
                }
            }
        } catch(Exception e){
            throw new DataParsingException();
        }
    }
}
