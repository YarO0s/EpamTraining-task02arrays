package by.denisov.task02arrays.test.service;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.service.SelectionSort;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SelectionSortTest {
    @DataProvider(name = "selectionSortDataProvider")
    public Object[][] selectionSortDataProvider(){
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

    @Test(description = "selectionSortTest", dataProvider = "selectionSortDataProvider")
    public void selectionSortTest(Double[] array1, Double[] array2){
        ArrayData initialData = new ArrayData();
        initialData.addAll(array1);
        ArrayData expectedData = new ArrayData();
        expectedData.addAll(array2);
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(initialData);
        assertEquals(expectedData, initialData);
    }
}
