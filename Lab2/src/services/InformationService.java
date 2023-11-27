package services;

import document_flow.FileInfo;
import document_types.Document;
import document_types.Img;
import document_types.ProgrammingLanguage;
import document_types.Txt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InformationService implements IFileService {
    private final FileInfo fileInfo = new FileInfo();

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: info <filename>");
            return;
        }

        String filename = args[1];
        File file = fileInfo.getFile(filename);

        if (file.exists()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String extension = filename.substring(filename.lastIndexOf('.') + 1);
            String createdDate = fileInfo.getCreateDate(file.toPath());
            String lastModifiedDate = dateFormat.format(new Date(file.lastModified()));
            
            Document doc = null;

            switch (extension) {
                case "png", "jpg", "jpeg" -> {
                    doc = new Img(file.getName(), extension, createdDate, lastModifiedDate);
                }
                case "txt" -> {
                    doc = new Txt(file.getName(), extension, createdDate, lastModifiedDate);
                }
                case "py", "java" -> {
                    doc = new ProgrammingLanguage(file.getName(), extension, createdDate, lastModifiedDate);
                }
            }
            
            System.out.println(doc);
        } else {
            System.out.println("File not found: " + filename);
        }
    }
}
