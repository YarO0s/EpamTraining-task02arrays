package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.model.Matrix;
import by.denisov.task02arrays.model.MatrixMessage;
import by.denisov.task02arrays.service.MatrixMultiplicationService;
import by.denisov.task02arrays.service.Validation.MatrixMultiplicationValidation;
import by.denisov.task02arrays.view.IOData;

public class MatrixMultiplicationCommand implements MatrixCommandInterface{

    //TODO: remove outprint with IOData

    private Matrix matrixOperand1, matrixOperand2;
    private MatrixMultiplicationService matrixMultiplicationService;
    private IOData ioData = new IOData();
    private MatrixMessage message;
    private MatrixMultiplicationValidation validation;

    public MatrixMultiplicationCommand(Matrix matrix1, Matrix matrix2, MatrixMultiplicationService newMatrixMultiplicationService,
                                       MatrixMessage newMessage){
        matrixOperand1 = matrix1;
        matrixOperand2 = matrix2;
        matrixMultiplicationService = newMatrixMultiplicationService;
        message = newMessage;
    }

    public void execute() {
        validation = new MatrixMultiplicationValidation(message);
        if (validation.isValid(matrixOperand1, matrixOperand2)) {
            Matrix<Double> resultMatrix = matrixMultiplicationService.multiply(matrixOperand1, matrixOperand2);
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR7);
            ioData.writeData(""+resultMatrix);
        } else{
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR6);
        }
    }
}
