package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.model.Matrix;
import by.denisov.task02arrays.model.MatrixMessage;
import by.denisov.task02arrays.service.MatrixSubtractionService;
import by.denisov.task02arrays.service.Validation.MatrixSubtractionValidation;
import by.denisov.task02arrays.view.IOData;

public class MatrixSubtractionCommand implements MatrixCommandInterface{

    //TODO: remove outprint with IOData

    private Matrix matrixOperand1, matrixOperand2;
    private MatrixSubtractionService matrixSubtractionService;
    private IOData ioData = new IOData();
    private MatrixSubtractionValidation validation;
    private MatrixMessage message;

    public MatrixSubtractionCommand(Matrix matrix1, Matrix matrix2, MatrixSubtractionService newMatrixSubtractionService,
                                    MatrixMessage newMessage){
        matrixOperand1 = matrix1;
        matrixOperand2 = matrix2;
        matrixSubtractionService = newMatrixSubtractionService;
        message = newMessage;
    }

    public void execute(){
        validation = new MatrixSubtractionValidation(message);
        if(validation.isValid(matrixOperand1, matrixOperand2)) {
            Matrix<Double> resultMatrix = matrixSubtractionService.subtract(matrixOperand1, matrixOperand2);
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR7);
            ioData.writeData(""+resultMatrix);
        } else{
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR6);
        }
    }
}
