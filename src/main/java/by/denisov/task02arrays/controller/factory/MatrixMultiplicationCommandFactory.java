package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.MatrixCommandInterface;
import by.denisov.task02arrays.controller.command.MatrixMultiplicationCommand;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Matrix;
import by.denisov.task02arrays.model.MatrixMessage;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.MatrixMultiplicationService;

public class MatrixMultiplicationCommandFactory implements OperationsAbstractFactory{
    private MatrixMessage message;

    public MatrixMultiplicationCommandFactory(MatrixMessage newMessage){
        message = newMessage;
    }

    @Override
    public MatrixCommandInterface createCommand(){

        Matrix<Double> matrix1 = new Matrix(message.getCommandData(0).length, message.getCommandData(0)[0].length);
        Matrix<Double> matrix2 = new Matrix(message.getCommandData(1).length, message.getCommandData(1)[0].length);


        MatrixMultiplicationService matrixMultiplicationService = new MatrixMultiplicationService();
        MatrixCommandInterface command = new MatrixMultiplicationCommand(matrix1, matrix2, matrixMultiplicationService, message);
        return command;
    }
}
