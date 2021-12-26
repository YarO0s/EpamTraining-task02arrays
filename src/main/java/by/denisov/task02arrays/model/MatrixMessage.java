package by.denisov.task02arrays.model;

import java.util.LinkedList;
import java.util.List;

public class MatrixMessage extends AbstractMessage{

    private List<String[][]> matrixData = new LinkedList<String[][]>();
    int matrixColumns, matrixRows;

    public MatrixMessage(String initialString, String[][]matrix1, String[][]matrix2){
        super(initialString);
        matrixData.add(matrix1);
        matrixData.add(matrix2);
    }

    public String[][] getCommandData(int index){
        return matrixData.get(index);
    }
}
