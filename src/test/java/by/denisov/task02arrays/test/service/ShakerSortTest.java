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
                {new double[]{1,2,3,4,5}, new double[]{5,4,3,2,1}},
        };
    }

    @Test(description = "shakerSortTest", dataProvider = "shakerSortDataProvider")
    public void shakerSortTest(double[] array1, double[] array2){
        ArrayData initialData = new ArrayData();
        initialData.addAll(array1);
        ArrayData expectedData = new ArrayData();
        expectedData.addAll(array2);
        ShakerSort shakerSort = new ShakerSort();
        shakerSort.sort(initialData);
        assertEquals(expectedData, initialData);
    }
}
