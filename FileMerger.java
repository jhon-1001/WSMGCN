package com.itheima.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileMerger {
    public static void mergeFiles(File outputFile, File[] inputFiles) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            for (File inputFile : inputFiles) {
                try (FileInputStream inputStream = new FileInputStream(inputFile)) {
                    byte[] buffer = new byte[8192];
                    int bytesRead = 0;

                    while ((bytesRead = inputStream.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Jack Jiang\\Documents\\Work Documents\\Work\\Java Development\\13、Spring原理解析");
        List<File> list = new ArrayList<>();
        File[] files = file.listFiles();
        for (File file1 : files) {

            if (file1.toString().contains("pdf.")) {
                list.add(file1);
            }
        }
        File[] orgFiles = new File[list.size()];
        int i = 0;
        for (File file1 : list) {
            orgFiles[i++] = file1;
        }
        File out = new File("C:\\Users\\Jack Jiang\\Documents\\Work Documents\\Work\\Java Development\\13、Spring原理解析\\output.pdf");
        mergeFiles(out, orgFiles);
    }
}