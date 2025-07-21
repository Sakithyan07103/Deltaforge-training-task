package day9.readtextjsontoobject;

import day9.readtextjsontoobject.constants.Constants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class readJsonMain {
    private static final String name = System.getProperty("user.dir") + Constants.sampleTxtFile;

    public static void main(String[] args) {
        System.out.println("Working Directory: " + System.getProperty("user.dir"));
        createOrUpdateFile("Hello from Java!");
        readFile();
        //deleteFile();
    }

    public static void createOrUpdateFile(String content) {
        try {
            FileWriter writer = new FileWriter(name, true);
            writer.write(content + "\n");
            writer.close();
            System.out.println("Data written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try {
            File file = new File(name);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile() {
        File file = new File(name);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}

