package archiver.command;

import archiver.ConsoleHelper;
import archiver.ZipFileManager;
import archiver.exceptions.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Archive unpacking.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Please enter path for unpacking");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(destinationPath);

            ConsoleHelper.writeMessage("An archive has been unpacked.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Wrong path for unpacking!");
        }
    }
}