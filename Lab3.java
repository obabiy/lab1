package com.company;

import java.util.ArrayList;
import java.io.*;

public class Lab3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src\\com.company\\file.txt")); //має бути txt файл
        String line = "";
        ArrayList<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null){
            if(line.compareTo("\n") < 0) {
                continue;
            }
            lines.add(line);
        }

        String [] linesAsArray = lines.toArray(new String[lines.size()]);

        for(int p = 0; p < lines.size(); p++){
            for(int j = 0; j < lines.size() - 1; j++){
                String temp = "";
                  if(linesAsArray[j].compareToIgnoreCase(linesAsArray[j+1]) > 0){
                      temp = linesAsArray [j];
                      linesAsArray[j] = linesAsArray[j+1];
                      linesAsArray[j+1] = temp;
                  }
            }
        }

        File crtFile = new File("src\\com.company\\finish.txt"); //файл виводу
        String parentFile = crtFile.getPath();

        try(FileWriter writer = new FileWriter(parentFile, false)) {
            for(int i = 0; i < lines.size(); i++){
                writer.write(linesAsArray[i]+ "\n");
            }
            System.out.println("Done!");
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
