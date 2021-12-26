package by.denisov.task02arrays.view;

import by.denisov.task02arrays.model.LocaleManager;

import java.util.Scanner;

public class IOData {
    private Scanner scanner = new Scanner(System.in);
    public static LocaleManager localeManager = new LocaleManager(LocaleManager.LangConfig.RU);

    public void writeData(String... initData){
        String resultString = "";
        for(String i : initData){
            resultString +=i;
        }
        System.out.println(resultString);
    }

    public static void setLocaleManager(LocaleManager.LangConfig langConfig){
        localeManager = new LocaleManager(langConfig);
    }

    public void writeLocalisedData(LocaleManager.MessageKeys key){
        System.out.println(localeManager.getText(key));
    }

    public String readData(){
        return scanner.nextLine();
    }
}