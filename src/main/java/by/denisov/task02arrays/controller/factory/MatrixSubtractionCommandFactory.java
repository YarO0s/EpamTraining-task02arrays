package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.MatrixCommandInterface;
import by.denisov.task02arrays.controller.command.MatrixSubtractionCommand;
import by.denisov.task02arrays.model.Matrix;
import by.denisov.task02arrays.model.MatrixMessage;
import by.denisov.task02arrays.service.MatrixSubtractionService;

public class MatrixSubtractionCommandFactory implements OperationsAbstractFactory{
    private MatrixMessage message;

    public MatrixSubtractionCommandFactory(MatrixMessage newMessage){
        message = newMessage;
    }

    @Override
    public MatrixCommandInterface createCommand(){

        Matrix<Double> matrix1 = new Matrix(message.getCommandData(0).length, message.getCommandData(0)[0].length);
        Matrix<Double> matrix2 = new Matrix(message.getCommandData(1).length, message.getCommandData(1)[0].length);

        MatrixSubtractionService matrixOperation = new MatrixSubtractionService();
        MatrixCommandInterface command = new MatrixSubtractionCommand(matrix1, matrix2, matrixOperation, message);
        return command;
    }
}
