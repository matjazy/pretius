package com.mateuszjazy;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileMover {
    private FilesMovingRulesHandler filesMovingRulesHandler;
    private SystemHandler systemHandler;
    private FileWriter fileWriter;

    private static int devCounter = 0;
    private static int testCounter = 0;

    FileMover(FilesMovingRulesHandler filesMovingRulesHandler, SystemHandler systemHandler, FileWriter fileWriter) {
        this.filesMovingRulesHandler = filesMovingRulesHandler;
        this.systemHandler = systemHandler;
        this.fileWriter = fileWriter;
    }

    public void moveFile(String filename) throws IOException {
        if (filesMovingRulesHandler.testIfShouldBeMovedToTest(filename)) {
            Files.move(Paths.get(System.getProperty("user.dir") + systemHandler.getHomePath() + filename),
                    Paths.get(System.getProperty("user.dir") + systemHandler.getTestPath() + filename),
                    StandardCopyOption.REPLACE_EXISTING);
            testCounter++;
            updateCounter();
        } else if (filesMovingRulesHandler.testIfShouldBeMovedToDev(filename)) {
            Files.move(Paths.get(System.getProperty("user.dir") + systemHandler.getHomePath() + filename),
                    Paths.get(System.getProperty("user.dir") + systemHandler.getTestPath() + filename),
                    StandardCopyOption.REPLACE_EXISTING);
            devCounter++;
            updateCounter();
        }
    }

    private void updateCounter() throws IOException {
        fileWriter.write("Pliki przeniesione do:" +
                "   (Ilość="
                + devCounter
                + ")"
                + System.getProperty("line.separator")
                + "Pliki przeniesione do:"
                + systemHandler.getTestPath() + "(Ilość="
                + testCounter + ")");
    }
}
