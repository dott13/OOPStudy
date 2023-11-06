package services;

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

public class InformationService extends FileService{
    private final String folderPath = "C:\\Study\\OOP\\OOPStudy\\Lab2\\repos";

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: info <filename>");
            return;
        }

        String fileName = args[1];
        File file = new File(folderPath + File.separator + fileName);
        if (file.exists()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

            System.out.println("File Name: " + file.getName());
            System.out.println("Extension: " + extension);
            String createdDate = getCreatedDate(file.toPath());
            System.out.println("Created Date: " + createdDate);
            System.out.println("Last Modified Date: " + dateFormat.format(new Date(file.lastModified())));

            switch (extension) {
                case "png", "jpg", "jpeg" -> {
                    String imageSize = getImageDimensions(file);
                    System.out.println("Image Size: " + imageSize);
                }
                case "txt" -> {
                    int lineCount = getLineCount(file);
                    int wordCount = getWordCount(file);
                    int characterCount = getCharacterCount(file);
                    System.out.println("Line Count: " + lineCount);
                    System.out.println("Word Count: " + wordCount);
                    System.out.println("Character Count: " + characterCount);
                }
                case "py", "java" -> {
                    int lineCount = getLineCount(file);
                    int classCount = getClassCount(file);
                    int methodCount = getMethodCount(file);
                    System.out.println("Line Count: " + lineCount);
                    System.out.println("Class Count: " + classCount);
                    System.out.println("Method Count: " + methodCount);
                }
            }
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    private String getCreatedDate(Path path){
        try{
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            FileTime fileTime = attributes.creationTime();
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(fileTime.toMillis()));
        } catch (IOException e){
            return "N/A";
        }
    }

    private int getLineCount(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }
            return lineCount;
        } catch (Exception e) {
            return 0;
        }
    }

    private int getWordCount(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int wordCount = 0;
            while (scanner.hasNext()) {
                scanner.next();
                wordCount++;
            }
            return wordCount;
        } catch (Exception e) {
            return 0;
        }
    }

    private int getCharacterCount(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int characterCount = 0;
            while (scanner.hasNext()) {
                String word = scanner.next();
                characterCount += word.length();
            }
            return characterCount;
        } catch (Exception e) {
            return 0;
        }
    }

    private int getClassCount(File file) {
        int classCount = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.startsWith("public class ")) {
                    classCount++;
                }
            }
        } catch (Exception e) {
            classCount = 0;
        }
        return classCount;
    }

    private int getMethodCount(File file) {
        int methodCount = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.startsWith("def ") || line.startsWith("public void ")) {
                    methodCount++;
                }
            }
        } catch (Exception e) {
            methodCount = 0;
        }
        return methodCount;
    }

    private String getImageDimensions(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            return width + "x" + height;
        } catch (IOException e) {
            return "N/A";
        }
    }
}
