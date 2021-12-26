package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.model.Message;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SetLanguageValidation {

    public Message message;

    Logger logger = LogManager.getLogger();

    public SetLanguageValidation(Message newMessage){
            message = newMessage;
    }

    public boolean isValid(){
        if(message.getCommandData()[0].equals("eng")||message.getCommandData()[0].equals("rus")){
            return true;
        }
        else{
            logger.log(Level.DEBUG, "Language validation result - false");
            return false;
        }
    }

}
