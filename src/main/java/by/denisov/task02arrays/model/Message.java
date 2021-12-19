package by.denisov.task02arrays.model;

public class Message {
    private String commandMessage = "";
    private String[] commandData;

    public Message(String initialMessage){
    int separator = initialMessage.indexOf(" ");
    if(separator>0) {
        commandMessage = initialMessage.substring(0, separator);
    } else {
        commandMessage = initialMessage;
        //TODO: throw exception
        //throw
    }
    if(separator+1< initialMessage.length()) {
        commandData = initialMessage.substring(separator + 1, initialMessage.length()).split(" ");
    } else {
        commandData = new String[0];
        //TODO: throw exception
    }
    }

    public String getCommandMessage(){
        return commandMessage;
    }

    public String[] getCommandData(){
        return commandData;
    }


}
