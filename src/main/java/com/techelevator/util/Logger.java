package com.techelevator.util;

import java.io.*;

public class Logger {
    File file;
    PrintWriter writer;

    public Logger(String pathName){
        this.file = new File(pathName);
        if (!file.exists()){
            try {
                this.writer = new PrintWriter(this.file);
            } catch (FileNotFoundException e){
                System.out.println("FILE NOT FOUND");
            }
        } else {
            try {
                this.writer = new PrintWriter(new FileWriter(this.file, true));
            } catch (IOException ie){
                System.out.println("ERROR FILE NOT WRITTEN");
            }
        }
    }

    public void write(String logMessage){
        this.writer.println(logMessage);
        this.writer.flush();
        this.writer.close();
    }
}
