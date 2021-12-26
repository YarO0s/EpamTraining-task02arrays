package by.denisov.task02arrays.controller.command;

import by.denisov.task02arrays.controller.factory.SetLanguageValidation;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.LocaleReplacementService;
import by.denisov.task02arrays.service.ShakerSort;
import by.denisov.task02arrays.service.Validation.ShakerSortValidation;
import by.denisov.task02arrays.view.IOData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SetLanguageCommand implements Command{

    private IOData ioData = new IOData();
    private Message message;
    private SetLanguageValidation validation;
    private LocaleReplacementService localeReplacement = new LocaleReplacementService();
    Logger logger = LogManager.getLogger();

    public SetLanguageCommand(Message newMessage){
        message = newMessage;
    }

    public void execute(){
        validation = new SetLanguageValidation(message);
        if(validation.isValid()){
            localeReplacement.replace(message.getCommandData()[0]);
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR8);
        } else {
            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR6);
            logger.log(Level.DEBUG, "Localisation command data failed validation");
        }
    }
}
