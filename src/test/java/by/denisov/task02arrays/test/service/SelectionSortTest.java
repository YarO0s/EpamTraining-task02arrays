package by.denisov.task02arrays.test.service;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.service.InsertionSort1;
import by.denisov.task02arrays.service.SelectionSort;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SelectionSortTest {
    @DataProvider(name = "selectionSortDataProvider")
    public Object[][] selectionSortDataProvider(){
        return new Object[][] {
                {new double[]{1,2,3,4,5}, new double[]{5,4,3,2,1}},
        };
    }

    @Test(description = "selectionSortTest", dataProvider = "selectionSortDataProvider")
    public void selectionSortTest(double[] array1, double[] array2){
        ArrayData initialData = new ArrayData();
        initialData.addAll(array1);
        ArrayData expectedData = new ArrayData();
        expectedData.addAll(array2);
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(initialData);
        assertEquals(expectedData, initialData);
    }
}
