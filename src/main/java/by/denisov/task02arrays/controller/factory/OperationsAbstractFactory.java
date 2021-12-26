package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.Command;

public interface OperationsAbstractFactory {

    public Command createCommand() throws DataParsingException;

}
