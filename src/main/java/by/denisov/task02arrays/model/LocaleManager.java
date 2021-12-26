package by.denisov.task02arrays.model;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleManager {

    private Locale currentLocale;
    private ResourceBundle resourceBundle;

    public LocaleManager(LangConfig config){
        createBundle(config);
    }

    public enum MessageKeys{
        STR1, STR2, STR3, STR4, STR5, STR6, STR7, STR8
    }

    public enum LangConfig{
        EN, RU;
    }

    public void setLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle("ui", locale);
    }

    private void createBundle(LangConfig config){
        switch(config){
            case EN:
                resourceBundle = ResourceBundle.getBundle("ui", new Locale("en","US"));
                return;
            case RU:
                resourceBundle = ResourceBundle.getBundle("ui", new Locale("ru","RU"));
                return;
            default:
                resourceBundle = ResourceBundle.getBundle("ui", new Locale("en","US"));
        }
    }

    public String getText(MessageKeys key){
        String message;
        switch(key){
            case STR1:
                message = "str1";
                break;
            case STR2:
                message = "str2";
                break;
            case STR3:
                message = "str3";
                break;
            case STR4:
                message = "str4";
                break;
            case STR5:
                message = "str5";
                break;
            case STR6:
                message = "str6";
                break;
            case STR7:
                message = "str7";
                break;
            case STR8:
                message = "str8";
                break;
            default:
                message = "";
        }
        return resourceBundle.getString(message);
    }

}
