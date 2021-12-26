package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.model.Matrix;
import by.denisov.task02arrays.model.MatrixMessage;
import by.denisov.task02arrays.service.MatrixSumService;
import by.denisov.task02arrays.service.Validation.MatrixSumValidation;
import by.denisov.task02arrays.view.IOData;

public class MatrixSumCommand implements MatrixCommandInterface{

    //TODO: remove outprint with IOData

    private Matrix matrixOperand1, matrixOperand2;
    private MatrixSumService matrixSumService;
    private IOData ioData = new IOData();
    private MatrixMessage message;
    private MatrixSumValidation validation;

    public MatrixSumCommand(Matrix matrix1, Matrix matrix2, MatrixSumService newMatrixSumService, MatrixMessage newMessage){
        matrixOperand1 = matrix1;
        matrixOperand2 = matrix2;
        matrixSumService = newMatrixSumService;
        message = newMessage;
    }

    public void execute(){
        validation = new MatrixSumValidation(message);
        if(validation.isValid(matrixOperand1, matrixOperand2)) {
            Matrix resultMatrix = matrixSumService.sum(matrixOperand1, matrixOperand2);
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR7);
            ioData.writeData(""+resultMatrix);
        } else{
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR6);
        }
    }
}
