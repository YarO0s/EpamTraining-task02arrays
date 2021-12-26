package by.denisov.task02arrays.test.service;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.service.InsertionSort;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class InsertionSortTest {
    @DataProvider(name = "insertionSortDataProvider")
    public Object[][] insertionSortDataProvider(){
        return new Object[][] {
                {new Double[]{1.0,2.0,3.0,4.0,5.0}, new Double[]{5.0,4.0,3.0,2.0,1.0}},
                {new Double[]{1.0,2.0,3.0,4.0}, new Double[]{4.0,3.0,2.0,1.0}},
                {new Double[]{1.0,2.0}, new Double[]{2.0,1.0}},
                {new Double[]{-1.0,-2.0}, new Double[]{-1.0,-2.0}},
                {new Double[]{}, new Double[]{}},
                {new Double[]{1.0}, new Double[]{1.0}},
                {new Double[]{1.0,2.0,3.0,3.0,3.0,3.0}, new Double[]{3.0,3.0,3.0,3.0,2.0,1.0}},
        };
    }

    @Test(description = "insertionSortTest", dataProvider = "insertionSortDataProvider")
    public void insertionSortTest(Double[] array1, Double[] array2){
        ArrayData initialData = new ArrayData();
        initialData.addAll(array1);
        ArrayData expectedData = new ArrayData();
        expectedData.addAll(array2);
        InsertionSort insertionSort1 = new InsertionSort();
        insertionSort1.sort(initialData);
        assertEquals(expectedData, initialData);
    }
}
