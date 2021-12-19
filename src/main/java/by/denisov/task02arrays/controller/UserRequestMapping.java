package by.denisov.task02arrays.controller;

import by.denisov.task02arrays.controller.command.*;
import by.denisov.task02arrays.controller.factory.*;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.model.Message;
import by.denisov.task02arrays.service.AbstractSortingAlgorithm;
import by.denisov.task02arrays.view.IOData;

public class UserRequestMapping {

    IOData ioData = new IOData();

    //TODO: architecture is hardly dependent from commands - find alternatives
    public Command getCommand(Message message){

        SortAbstractFactory sortAbstractFactory = null;

        switch (message.getCommandMessage()) {
            case "exit":
                return new ExitCommand();

            case "help":
                break;

            case "bubblesort":
                sortAbstractFactory = new BubbleSortFactory(message);
                break;

            case "insertionsort1":
                sortAbstractFactory = new InsertionSort1Factory(message);
                break;

            case "mergesort":
                sortAbstractFactory = new MergeSortFactory(message);
                break;

            case "selectionsort":
                sortAbstractFactory = new SelectionSortFactory(message);
                break;

            case "shakersort":
                sortAbstractFactory = new ShakerSortFactory(message);
                break;

            case "shellsort":
                sortAbstractFactory = new ShellSortFactory(message);
                break;
        }

            Command resultCommand = null;

        if(sortAbstractFactory!=null) {

            ArrayData arrayData = null;

            try {
                arrayData = sortAbstractFactory.createArrayData();
            } catch (DataParsingException e){
                ioData.writeData("Wrong data provided");
                return null;
            }
            AbstractSortingAlgorithm sortingAlgorithm = sortAbstractFactory.createSortInstance();

            resultCommand = sortAbstractFactory.createCommand(arrayData, sortingAlgorithm);

        } else {
            IOData ioData = new IOData();
            ioData.writeData("Command '" + message.getCommandMessage() + "' does not exist\n");
        }

        return resultCommand;
    }
}
