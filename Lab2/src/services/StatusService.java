package services;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class StatusService implements IFileService{
    private final Date lastSnapshotTime;
    private final Set<String> lastSnapshotFiles;

    public StatusService(Date lastSnapshotTime, Set<String> lastSnapshotFiles) {
        this.lastSnapshotTime = lastSnapshotTime;
        this.lastSnapshotFiles = lastSnapshotFiles;
    }

    @Override
    public void execute(String[] args) {
        String folderPath = "C:\\Study\\OOP\\OOPStudy\\Lab2\\repos";
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                System.out.println("Created Snapshot at: " + lastSnapshotTime);

                Set<String> currentFiles = new HashSet<>();
                for (File file : files) {
                    Date lastModifiedTime = new Date(file.lastModified());
                    String status = "No Change";

                    if (lastModifiedTime.after(lastSnapshotTime)) {
                        status = "Changed";
                    }

                    currentFiles.add(file.getName());

                    if (!lastSnapshotFiles.contains(file.getName())) {
                        status = "New File";
                    }

                    System.out.println(file.getName() + " - " + status);
                }

                for (String fileName : lastSnapshotFiles) {
                    if (!currentFiles.contains(fileName)) {
                        System.out.println(fileName + " - Deleted File");
                    }
                }
            }
        }
    }
}
