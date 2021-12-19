package by.denisov.task02arrays.view;

import by.denisov.task02arrays.model.Message;

public class RequestListener {

    IOData ioData = new IOData();

    public RequestListener(){
        ioData.writeData("Input command to perform operation, to print the set of instructions use <help>, to exit use <exit>;");

    }
    public Message getMessage(){
        return new Message(ioData.readData());
    }

}