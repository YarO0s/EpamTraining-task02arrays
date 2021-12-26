package by.denisov.task02arrays.service;

import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.view.IOData;

public class LocaleReplacementService {

    /**
     * Changes localisation value, provides change between english and russian locales.
     * @param lang - string for defining appropriate case
     */
    public void replace(String lang){
        switch(lang){
            case "eng":
                IOData.setLocaleManager(LocaleManager.LangConfig.EN);
            break;
            case "rus":
                IOData.setLocaleManager(LocaleManager.LangConfig.RU);
            break;
        }
    }

}
