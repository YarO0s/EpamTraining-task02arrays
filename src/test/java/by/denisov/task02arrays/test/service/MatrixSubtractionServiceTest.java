package by.denisov.task02arrays.test.service;

import by.denisov.task02arrays.model.Matrix;
import by.denisov.task02arrays.service.MatrixMultiplicationService;
import by.denisov.task02arrays.service.MatrixSubtractionService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MatrixSubtractionServiceTest {
    @DataProvider(name = "matrixSubtractionTestData")
    public Object[][] matrixSubtractionTestData(){
        return new Object[][] {
                {new Double[][]{{2.0,2.0,2.0},{2.0,2.0,2.0},{2.0,2.0,2.0}}, new Double[][]{{1.0,1.0,1.0},{1.0,1.0,1.0},{1.0,1.0,1.0}},
                        new Double[][]{{1.0,1.0,1.0},{1.0,1.0,1.0},{1.0,1.0,1.0}}
                },
                {new Double[][]{{1.0,0.0,0.0},{0.0,1.0,0.0},{0.0,0.0,1.0}}, new Double[][]{{0.0,0.0,0.0},{0.0,0.0,0.0},{0.0,0.0,0.0}},
                        new Double[][]{{1.0,0.0,0.0},{0.0,1.0,0.0},{0.0,0.0,1.0}}
                },
                {new Double[][]{{2.0,2.0,2.0},{2.0,2.0,2.0}}, new Double[][]{{2.0,2.0,2.0},{2.0,2.0,2.0}},
                        new Double[][]{{0.0,0.0,0.0},{0.0,0.0,0.0}}
                },
        };
    }

    @Test(description = "matrix subtraction test", dataProvider = "matrixSubtractionTestData")
    public void matrixSubtractionTest(Double[][] inputData1, Double[][] inputData2, Double[][] expected){
        Matrix matrix1 = new Matrix(inputData1);
        Matrix matrix2 = new Matrix(inputData2);

        Matrix expectedMatrix = new Matrix(expected);
        MatrixSubtractionService multiplicationService = new MatrixSubtractionService();
        Matrix actualMatrix = multiplicationService.subtract(matrix1, matrix2);

        assertEquals(expectedMatrix, actualMatrix);
    }
}
