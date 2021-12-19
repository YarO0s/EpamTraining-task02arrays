package by.denisov.task02arrays.view;

import java.util.Scanner;

public class IOData {
    private Scanner scanner = new Scanner(System.in);

    public void writeData(String... initData){
        String resultString = "";
        for(String i : initData){
            resultString +=i;
        }
        System.out.println(resultString);
    }

    public String readData(){
        return scanner.nextLine();
    }
}
