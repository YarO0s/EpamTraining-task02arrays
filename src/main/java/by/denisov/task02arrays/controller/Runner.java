package by.denisov.task02arrays.controller;

import by.denisov.task02arrays.controller.command.Command;
import by.denisov.task02arrays.controller.command.ExitCommand;
import by.denisov.task02arrays.view.RequestListener;

public class Runner {

    RequestListener requestListener = new RequestListener();
    UserRequestMapping messageProcessor = new UserRequestMapping();
    Command commandToExecute = null;

    public void run(){

        do{
            commandToExecute = messageProcessor.getCommand(requestListener.getMessage());
            if(commandToExecute!=null){
                commandToExecute.execute();
            } else {
                continue;
            }
        } while(!(commandToExecute instanceof ExitCommand));
    }
}
