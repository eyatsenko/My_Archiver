package archiver.command;

import archiver.ConsoleHelper;
import archiver.ZipFileManager;
import archiver.exceptions.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Archive creating.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Enter full name of file or directory for archiving:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.createZip(sourcePath);

            ConsoleHelper.writeMessage("An archive is created.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("You entered the wrong file or directory name.");
        }
    }
}
