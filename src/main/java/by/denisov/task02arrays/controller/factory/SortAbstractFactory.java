package by.denisov.task02arrays.controller.factory;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.controller.command.Command;
import by.denisov.task02arrays.model.ArrayData;
import by.denisov.task02arrays.service.AbstractSortingAlgorithm;

public interface SortAbstractFactory {
    public AbstractSortingAlgorithm createSortInstance();

    public Command createCommand(ArrayData arrayData, AbstractSortingAlgorithm abstractSortingAlgorythm);

    public ArrayData createArrayData() throws DataParsingException;
}
