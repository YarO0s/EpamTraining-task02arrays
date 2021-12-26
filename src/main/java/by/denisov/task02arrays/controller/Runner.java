package by.denisov.task02arrays.controller;

import by.denisov.task02arrays.controller.command.Command;
import by.denisov.task02arrays.controller.command.ExitCommand;
import by.denisov.task02arrays.model.AbstractMessage;
import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.view.IOData;
import by.denisov.task02arrays.view.RequestListener;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

    private RequestListener requestListener = new RequestListener();
    private UserRequestMapping messageProcessor = new UserRequestMapping();
    private Command commandToExecute = null;
    private IOData ioData = new IOData();
    private LocaleManager localeManager = new LocaleManager(LocaleManager.LangConfig.EN);
    Logger logger = LogManager.getLogger();

    public void run(){
        ioData.setLocaleManager(LocaleManager.LangConfig.EN);
        do{
            AbstractMessage message = null;
            try {
                message = requestListener.getMessage();
            } catch (Exception e){
                logger.log(Level.ERROR, "Error while receiving user request");
                ioData.writeLocalisedData(LocaleManager.MessageKeys.STR5);
                continue;
            }
            commandToExecute = messageProcessor.getCommand(message);
            if(commandToExecute!=null){
                commandToExecute.execute();
            } else {
                continue;
            }
        } while(!(commandToExecute instanceof ExitCommand));
    }
}
