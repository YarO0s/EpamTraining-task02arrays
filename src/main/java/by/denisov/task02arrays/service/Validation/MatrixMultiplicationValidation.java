package by.denisov.task02arrays.service.Validation;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.model.Matrix;
import by.denisov.task02arrays.model.MatrixMessage;

public class MatrixMultiplicationValidation {
    private MatrixMessage message;

    public MatrixMultiplicationValidation(MatrixMessage newMessage){
        message = newMessage;
    }

    public boolean isValid(Matrix firstOperand, Matrix secondOperand) {
        if(firstOperand.getVerticalLength()!= secondOperand.getHorizontalLength() ||
                firstOperand.getHorizontalLength()!= secondOperand.getVerticalLength()){
            return false;
        }
        try{
            dataParseValidation(firstOperand, 0);
            dataParseValidation(secondOperand, 1);
        } catch (DataParsingException parsingException){
            return false;
        }
        return true;
    }

    private void dataParseValidation(Matrix initialMatrix, int messageMatrixIndex) throws DataParsingException {
        try {
            for (int i2 = 0; i2 < initialMatrix.getHorizontalLength(); i2++) {
                for (int i3 = 0; i3 < initialMatrix.getVerticalLength(); i3++) {
                    initialMatrix.set(i2, i3, Double.parseDouble(message.getCommandData(messageMatrixIndex)[i2][i3]));
                }
            }
        } catch(Exception e){
            e.printStackTrace();
            throw new DataParsingException();
        }
    }
}
