package document_types;

import document_flow.FileInfo;

import java.io.File;
import java.util.Scanner;

public class ProgrammingLanguage extends Document {
    private final FileInfo fileInfo = new FileInfo();
    File file = fileInfo.getFile(fileName);
    int lineCount;
    int classCount;
    int methodCount;

    public ProgrammingLanguage(String fileName, String extension, String createdDate, String lastModifiedDate) {
        super(fileName, extension, createdDate, lastModifiedDate);
        this.lineCount = getLineCount();
        this.classCount = getClassCount();
        this.methodCount = getMethodCount();
    }

    public int getLineCount() {
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

    public int getClassCount() {
        int classCount = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.contains("class") || line.contains("enum")) {
                    classCount++;
                }
            }
        } catch (Exception e) {
            classCount = 0;
        }
        return classCount;
    }

    public int getMethodCount() {
        int methodCount = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.contains("def") || line.contains("public void")) {
                    methodCount++;
                }
            }
        } catch (Exception e) {
            methodCount = 0;
        }
        return methodCount;
    }

    @Override
    public String toString() {
        return "File name: " + fileName + "\n" +
                "Extension: " + extension + "\n" +
                "Created date: " + createdDate + "\n" +
                "Last modified date: " + lastModifiedDate + "\n" +
                "Line count: " + lineCount + "\n" +
                "Class count: " + classCount + "\n" +
                "Method count: " + methodCount + "\n" ;
    }
}
