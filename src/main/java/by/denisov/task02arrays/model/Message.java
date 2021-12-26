package by.denisov.task02arrays.model;

public class Message extends AbstractMessage{

    private String[] commandData;

    public Message(String initialMessage){
        super(initialMessage);
    int separator = initialMessage.indexOf(" ");
    if(separator+1 < initialMessage.length()) {
        commandData = initialMessage.substring(separator + 1).split(" ");
    } else {
        commandData = new String[0];
    }
    }

    public String[] getCommandData(){
        return commandData;
    }


}
