package by.denisov.task02arrays.test.service;

import by.denisov.task02arrays.model.Matrix;
import by.denisov.task02arrays.service.MatrixMultiplicationService;
import by.denisov.task02arrays.service.MatrixSumService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MatrixSumServiceTest {
    @DataProvider(name = "matrixMultiplicationTestData")
    public Object[][] matrixMultiplicationTestData(){
        return new Object[][] {
                {new Double[][]{{2.0,2.0,2.0},{2.0,2.0,2.0},{2.0,2.0,2.0}}, new Double[][]{{2.0,2.0,2.0},{2.0,2.0,2.0},{2.0,2.0,2.0}},
                        new Double[][]{{4.0,4.0,4.0},{4.0,4.0,4.0},{4.0,4.0,4.0}}
                },
                {new Double[][]{{1.0,0.0,0.0},{0.0,1.0,0.0},{0.0,0.0,1.0}}, new Double[][]{{0.0,0.0,0.0},{0.0,0.0,0.0},{0.0,0.0,0.0}},
                        new Double[][]{{1.0,0.0,0.0},{0.0,1.0,0.0},{0.0,0.0,1.0}}
                },
                {new Double[][]{{2.0,2.0,2.0},{2.0,2.0,2.0}}, new Double[][]{{-2.0,-2.0,-2.0},{-2.0,-2.0,-2.0}},
                        new Double[][]{{0.0,0.0,0.0},{0.0,0.0,0.0}}
                },
        };
    }

    @Test(description = "matrix multiplication test", dataProvider = "matrixMultiplicationTestData")
    public void matrixMultiplicationTest(Double[][] inputData1, Double[][] inputData2, Double[][] expected){
        Matrix matrix1 = new Matrix(inputData1);
        Matrix matrix2 = new Matrix(inputData2);

        Matrix expectedMatrix = new Matrix(expected);
        MatrixSumService sumService = new MatrixSumService();
        Matrix actualMatrix = sumService.sum(matrix1, matrix2);

        assertEquals(expectedMatrix, actualMatrix);
    }
}
