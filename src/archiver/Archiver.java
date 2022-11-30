package archiver;

import archiver.exceptions.WrongZipFileException;

import java.io.IOException;

public class Archiver {
    static Operation operation;
    public static void main(String[] args) throws IOException {

        operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("You have not selected an archive file, or you have selected the wrong file.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("An error has occurred. Check the entered data.");
            }

        } while (operation != Operation.EXIT);
    }


    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("Please choose an operation:");
        ConsoleHelper.writeMessage(String.format("\t %d - pack files to the archive", Operation.CREATE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - add files to the archive", Operation.ADD.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - delete files from the archive", Operation.REMOVE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - unpack an archive", Operation.EXTRACT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - view the contents of the archive", Operation.CONTENT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - exit", Operation.EXIT.ordinal()));

        return Operation.values()[ConsoleHelper.readInt()];
    }

    public static int askLevelOfCompression() throws IOException {
        ConsoleHelper.writeMessage("Choose level of compression from 0 to 9:");
        return ConsoleHelper.readInt();
    }
}