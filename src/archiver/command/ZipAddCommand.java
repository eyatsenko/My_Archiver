package archiver.command;

import archiver.ConsoleHelper;
import archiver.ZipFileManager;
import archiver.exceptions.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Adding a new file to the archive.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Please enter full path to the file for adding:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());

            zipFileManager.addFile(sourcePath);

            ConsoleHelper.writeMessage("Adding is completed.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("File is not found.");
        }
    }
}
