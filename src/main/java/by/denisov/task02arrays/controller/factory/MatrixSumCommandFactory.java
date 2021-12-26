package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.MatrixCommandInterface;
import by.denisov.task02arrays.controller.command.MatrixSumCommand;
import by.denisov.task02arrays.model.Matrix;
import by.denisov.task02arrays.model.MatrixMessage;
import by.denisov.task02arrays.service.MatrixSumService;

public class MatrixSumCommandFactory implements OperationsAbstractFactory{
    private MatrixMessage message;

    public MatrixSumCommandFactory(MatrixMessage newMessage){
        message = newMessage;
    }

    @Override
    public MatrixCommandInterface createCommand(){

        Matrix<Double> matrix1 = new Matrix(message.getCommandData(0).length, message.getCommandData(0)[0].length);
        Matrix<Double> matrix2 = new Matrix(message.getCommandData(1).length, message.getCommandData(1)[0].length);
            for(int i2 = 0; i2 < matrix1.getHorizontalLength(); i2++){
                for(int i3 = 0; i3 < matrix1.getVerticalLength(); i3++){
                    matrix1.set(i2,i3, Double.parseDouble(message.getCommandData(0)[i2][i3]));
                }
            }
            for(int i2 = 0; i2 < matrix2.getHorizontalLength(); i2++){
                for(int i3 = 0; i3 < matrix2.getVerticalLength(); i3++){
                    matrix2.set(i2,i3, Double.parseDouble(message.getCommandData(1)[i2][i3]));
                }
            }
        MatrixSumService matrixOperation = new MatrixSumService();
        MatrixCommandInterface command = new MatrixSumCommand(matrix1, matrix2, matrixOperation, message);
        return command;
    }
}
