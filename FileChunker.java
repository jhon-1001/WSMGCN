package com.itheima.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileChunker {
    public static void chunkFile(File inputFile, int chunkSize) throws IOException {

        FileInputStream inputStream = new FileInputStream(inputFile);

        byte[] buffer = new byte[chunkSize];
        int bytesRead = 0;
        int chunkIndex = 0;

        while ((bytesRead = inputStream.read(buffer)) > 0) {
            String chunkFileName = inputFile.getName() + "." + chunkIndex++;
            File chunkFile = new File(inputFile.getParent(), chunkFileName);

            try (FileOutputStream outputStream = new FileOutputStream(chunkFile)) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        inputStream.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Jack Jiang\\Documents\\Work Documents\\Work\\Java Development\\13、Spring原理解析\\SPRING技术内幕：深入解析SPRING架构与设计原理.pdf");
        int chunkSize = 1024*1024*10;
        chunkFile(file, chunkSize);
    }
}