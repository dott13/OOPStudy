package views;

import com.sun.tools.javac.Main;
import document_flow.FileService;
import document_flow.SnapshotReader;
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
    private final String folderPath;
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
            case "commit":
                FileService commitExecutor = new FileService(commitService);
                commitExecutor.execute(parts);
                lastSnapshotFile = SnapshotReader.getSnapshotFiles(folder);
                break;
            case "info":
                FileService infoExecutor = new FileService(new InformationService());
                infoExecutor.execute(parts);
                break;
            case "status":
                FileService statusExecutor = new FileService(
                        new StatusService(commitService.getSnapshotTime(), lastSnapshotFile));
                statusExecutor.execute(parts);
                break;
            case "exit":
                running = false;
                break;
            default:
                System.out.println("Invalid command");
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
