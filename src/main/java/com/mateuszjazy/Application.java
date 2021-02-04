package com.mateuszjazy;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

public class Application {

    public static void main(String[] args) throws IOException, InterruptedException {
        SystemHandler systemHandler = new SystemHandler();
        systemHandler.generateDirectoriesIfNotExists();
        systemHandler.generateCountFileIfNotExists();
        FileMover fileMover = new FileMover(new FilesMovingRulesHandler(new SystemHandler()), new SystemHandler(), new FileWriter(System.getProperty("user.dir") + systemHandler.getHomePath() + "/count.txt"));
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path homePath = Paths.get(System.getProperty("user.dir") + systemHandler.getHomePath());
        homePath.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);


        WatchKey watchKey;


        while (true) {
            if (!((watchKey = watchService.take()) != null))
                break;
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                String test = event.context().toString();

                if (!test.equals("count.txt")) {
                    String change = "/" + event.context();
                    fileMover.moveFile(change);
                }
            }
            watchKey.reset();
        }

    }
}
