package services;

import java.util.Date;

public class CommitService extends FileService{
    private Date snapshotTime;

    public CommitService() {
        snapshotTime = new Date();
    }

    @Override
    public void execute(String[] args){
        snapshotTime = new Date();
        System.out.println("Snapshot time updated: " + snapshotTime);
    }

    public Date getSnapshotTime() {
        return snapshotTime;
    }
}
