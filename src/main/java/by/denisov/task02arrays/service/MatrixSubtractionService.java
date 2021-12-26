package by.denisov.task02arrays.service;

import by.denisov.task02arrays.model.Matrix;

public class MatrixSubtractionService implements AbstractMatrixOperation{

    /**
     * Performs matrices subtraction
     * @param matrix1 - first matrix operand
     * @param matrix2 - second matrix operand
     * @return result matrix
     */
    public Matrix<Double> subtract(Matrix<Double> matrix1, Matrix<Double> matrix2){
        Matrix<Double> resultMatrix = new Matrix<Double>(matrix1.getHorizontalLength(), matrix1.getVerticalLength());
        for(int i = 0; i < matrix1.getHorizontalLength(); i++){
            for(int i2 = 0; i2 < matrix1.getVerticalLength(); i2++){
                Double value = matrix1.get(i, i2) - matrix2.get(i, i2);
                resultMatrix.set(i, i2, value);
            }
        }
        return resultMatrix;
    }
}
