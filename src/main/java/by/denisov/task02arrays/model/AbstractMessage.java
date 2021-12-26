package by.denisov.task02arrays.model;

public abstract class AbstractMessage {

    private String commandMessage = "";

    public AbstractMessage(String initialMessage){
        int separator = initialMessage.indexOf(" ");
        if(separator>0) {
            commandMessage = initialMessage.substring(0, separator);
        } else {
            commandMessage = initialMessage;
        }
    }

    public String getCommandMessage(){
        return commandMessage;
    }

}
