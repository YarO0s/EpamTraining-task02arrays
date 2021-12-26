package by.denisov.task02arrays.view;

import by.denisov.task02arrays.controller.DataParsingException;
import by.denisov.task02arrays.model.AbstractMessage;
import by.denisov.task02arrays.model.LocaleManager;
import by.denisov.task02arrays.model.MatrixMessage;
import by.denisov.task02arrays.model.Message;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RequestListener {

    Logger logger = LogManager.getLogger();

    IOData ioData = new IOData();

    public RequestListener(){
       ioData.writeLocalisedData(LocaleManager.MessageKeys.STR1);
    }
    public AbstractMessage getMessage() throws Exception{
        AbstractMessage message = null;
        String messageString = ioData.readData();

        int index = messageString.indexOf(" ");

        if(index>0){
            String commandMessage = messageString.substring(0,index);
            if(commandMessage.equals("summatrix") || commandMessage.equals("subtractmatrix") ||
               commandMessage.equals("multiplymatrix")){

               String[][] resultMatrix1, resultMatrix2;
               String[] sizeData = messageString.substring(index+1).split(" ");
               try{
                  resultMatrix1 = readMatrixData(sizeData[0], sizeData[1]);
                  resultMatrix2 = readMatrixData(sizeData[1], sizeData[2]);
                  } catch(DataParsingException parsingException){
                        logger.log(Level.ERROR, "Error while matrix size data parsing");
                        throw new Exception();
                  }
               message = new MatrixMessage(commandMessage, resultMatrix1, resultMatrix2);
            } else {
                    message = new Message(messageString);
                   }
        } else {
                logger.log(Level.ERROR, "Zero index in request listener(unable to define user command)");
               throw new Exception();
               }

        return message;

    }

    private String[][] readMatrixData(String length1, String length2) throws DataParsingException{
        String[][] matrix;
        try {
            matrix = new String[Integer.parseInt(length1)][Integer.parseInt(length2)];

            ioData.writeLocalisedData(LocaleManager.MessageKeys.STR2);
            for(int i = 0; i < matrix[0].length; i++) {
                String matrixRowData[] = ioData.readData().split(" ");
                if(matrixRowData.length != matrix.length){
                    logger.log(Level.ERROR, "Input data size is inconsistent with matrix size input");
                    throw new DataParsingException();
                }
                for(int i2 = 0; i2 < matrix.length; i2++){
                    matrix[i2][i] = matrixRowData[i2];
                }
            }
        } catch(Exception e){
            logger.log(Level.ERROR, "Error while parsing matrix data");
            throw new DataParsingException();
        }
        return matrix;
    }
}