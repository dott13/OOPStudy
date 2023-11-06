package views;

import com.sun.tools.javac.Main;
import services.CommitService;
import services.InformationService;
import services.StatusService;

import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class MainView {
    private final CommitService commitService;
    private Set<String> lastSnapshotFile;
    private String folderPath;
    private final File folder;
    private final Scanner scanner;
    private boolean running;

    public MainView() {
        this.commitService = new CommitService();
        this.lastSnapshotFile = new HashSet<>();
        this.folderPath = "C:\\Study\\OOP\\OOPStudy\\Lab2\\repos";
        this.folder = new File(folderPath);
        this.scanner = new Scanner(System.in);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("No such file path");
            return;
        }
        this.running = true;
    }

    public void run() {
        while (running) {
            System.out.println("Enter command: ");

            commandSwitch();
        }
    }

    private void commandSwitch() {
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        String command = parts[0].toLowerCase();
        switch (command) {
            case "commit" -> {
                commitService.execute(parts);
                lastSnapshotFile = getSnapshotFile(folder);
            }
            case "info" -> {
                InformationService infoService = new InformationService();
                infoService.execute(parts);
            }
            case "status" -> {
                StatusService statusService = new StatusService(commitService.getSnapshotTime(), lastSnapshotFile);
                statusService.execute(parts);
            }
            case "exit" -> running = false;
            default -> System.out.println("Invalid command");
        }
    }
    private static Set<String> getSnapshotFile(File folder){
        Set<String> snapshotFiles = new HashSet<>();
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    snapshotFiles.add(file.getName());
                }
            }
        }
        return snapshotFiles;
    }
}
