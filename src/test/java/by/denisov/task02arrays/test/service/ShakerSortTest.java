package by.denisov.task02arrays.test.service;

import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.service.ShakerSort;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ShakerSortTest {
    @DataProvider(name = "shakerSortDataProvider")
    public Object[][] shakerSortDataProvider(){
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

    @Test(description = "shakerSortTest", dataProvider = "shakerSortDataProvider")
    public void shakerSortTest(Double[] array1, Double[] array2){
        ArrayData initialData = new ArrayData();
        initialData.addAll(array1);
        ArrayData expectedData = new ArrayData();
        expectedData.addAll(array2);
        ShakerSort shakerSort = new ShakerSort();
        shakerSort.sort(initialData);
        assertEquals(expectedData, initialData);
    }
}
