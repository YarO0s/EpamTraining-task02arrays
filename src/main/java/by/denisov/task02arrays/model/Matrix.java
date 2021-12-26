package by.denisov.task02arrays.model;

public class Matrix<T extends Number> {

    Number [][] data;

    public Matrix(T array[][]){
        data = array;
    }

    public Matrix(int firstDimensionLength, int secondDimensionLength){
        data = new Number[firstDimensionLength][secondDimensionLength];
    }

    public int getVerticalLength(){
        return data[0].length;
    }

    public int getHorizontalLength(){
        return data.length;
    }

    public void set(int firstDimensionLength, int secondDimensionLength, T value){
        data[firstDimensionLength][secondDimensionLength] = value;
    }

    public T get(int firstDimensionLength, int secondDimensionLength){
        return (T) data[firstDimensionLength][secondDimensionLength];
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < data.length; i++){
            for(int i2 = 0; i2 < data[0].length; i2++){
                result+=data[i][i2]+" ";
            }
            result+="\n";
        }
        return result;
    }

    public boolean equals(Object o){
        if(!(o instanceof Matrix)){
            return false;
        }
        Matrix toCompare = (Matrix) o;
        if(data.length!=toCompare.getHorizontalLength() || data[0].length != toCompare.getVerticalLength()){
            return false;
        }
        for(int i = 0; i < data.length; i++){
            for(int i2 = 0; i2 < data[0].length; i2++){
                if(data[i][i2].doubleValue() != toCompare.get(i,i2).doubleValue()){
                    return false;
                }
            }
        }
        return true;
    }

}
