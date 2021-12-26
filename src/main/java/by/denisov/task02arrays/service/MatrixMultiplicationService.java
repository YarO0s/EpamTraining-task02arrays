package by.denisov.task02arrays.service;

import by.denisov.task02arrays.model.Matrix;


/**
 * Matrix multiplication service class
 */
public class MatrixMultiplicationService implements AbstractMatrixOperation{

    /**
     * Multiplies matrices
     * @param matrix1 - first matrix operand
     * @param matrix2 - second matrix operand
     * @return - operation result
     */
    public Matrix<Double> multiply(Matrix<Double> matrix1, Matrix<Double> matrix2){
        int matrix1RowLength = matrix1.getHorizontalLength();
        int matrix1ColumnLength = matrix1.getVerticalLength();
        int matrix2RowLength = matrix2.getHorizontalLength();
        int matrix2ColumnLength = matrix2.getVerticalLength();

        Matrix<Double> resultMatrix = new Matrix<Double>(matrix1ColumnLength, matrix2RowLength);
        for(int i = 0; i < matrix1ColumnLength; i++){
            for(int i2 = 0; i2 < matrix1ColumnLength; i2++){
                double mValue = 0;
                for(int i3 = 0; i3 < matrix1RowLength; i3++){
                    mValue += matrix1.get(i3, i2) * matrix2.get(i2,i3);
                }
                resultMatrix.set(i, i2, mValue);
            }
        }
        return resultMatrix;
    }
}
