package by.denisov.task02arrays.test.service;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Matrix;
import by.denisov.task02arrays.service.MatrixMultiplicationService;
import by.denisov.task02arrays.service.MergeSort;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MatrixMultiplicationServiceTest {
    @DataProvider(name = "matrixMultiplicationTestData")
    public Object[][] matrixMultiplicationTestData(){
        return new Object[][] {
                {new Double[][]{{2.0,2.0,2.0},{2.0,2.0,2.0}}, new Double[][]{{2.0,2.0},{2.0,2.0},{2.0,2.0}},
                        new Double[][]{{8.0,8.0,8.0},{8.0,8.0,8.0},{8.0,8.0,8.0}}
                },
                {new Double[][]{{2.0,2.0},{2.0,2.0},{2.0,2.0}}, new Double[][]{{2.0,2.0,2.0},{2.0,2.0,2.0}},
                        new Double[][]{{12.0,12.0},{12.0,12.0}}
                }
        };
    }

    @Test(description = "matrix multiplication test", dataProvider = "matrixMultiplicationTestData")
    public void matrixMultiplicationTest(Double[][] inputData1, Double[][] inputData2, Double[][] expected){
        Matrix matrix1 = new Matrix(inputData1);
        Matrix matrix2 = new Matrix(inputData2);

        Matrix expectedMatrix = new Matrix(expected);
        MatrixMultiplicationService multiplicationService = new MatrixMultiplicationService();
        Matrix actualMatrix = multiplicationService.multiply(matrix1, matrix2);

        assertEquals(expectedMatrix, actualMatrix);
    }
}
