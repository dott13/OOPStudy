package document_flow;

import services.IFileService;

public class FileService {
    private final IFileService fileService;
    public FileService(IFileService fileService){
        this.fileService = fileService;
    }

    public void execute(String[] args){
        fileService.execute(args);
    }
}
