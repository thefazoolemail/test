package com.example.fileprocessor;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Log4j2
public class FileProcessorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FileProcessorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        readFile();
    }

    private void readFile() {
        long startTime = System.nanoTime();
        long j = 0;
        try (FileReader fr = new FileReader("E:\\Learning\\Java\\Boot\\gs-batch-processing-main\\complete\\src\\main\\resources\\Sample1.csv");
             BufferedReader br = new BufferedReader(fr);) {
            String str;
            while ((str = br.readLine()) != null) {
                String[] strAr = str.split(",");
                log.info(str);
                ++j;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("----------->>>>>>>Total Time (Sec): " + TimeUnit.NANOSECONDS.toSeconds(estimatedTime));
        System.out.println("----------->>>>>>>J --> IS : " + j);
    }

}
