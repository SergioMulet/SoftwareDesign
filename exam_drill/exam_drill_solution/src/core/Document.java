package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Document {

    StringBuilder text = new StringBuilder("");

    public void loadText(String filename) {
        try{
            text = new StringBuilder(readFile(filename));
        }
        catch(IOException e){
            System.out.println("No se pudo leer el fichero");
        }
    }

    private static String readFile(String filename) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(filename));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = input.readLine()) != null) {
            result.append(line);
        }
        input.close();
        return result.toString();
    }

    public void insert(String[] words){
        for(String word : words){
            text.append(word);
        }
    }

    public void delete(){
        int indexOfLastWord = text.toString().trim().lastIndexOf(" ");
        if (indexOfLastWord == -1)
            text = new StringBuilder("");
        else
            text.setLength(indexOfLastWord + 1);
    }

    public void replace(String[] words){
        String find = words[0];
        String replace = words[1];
        text = new StringBuilder(text.toString().replaceAll(Pattern.quote(find), replace));
    }

    public String getText(){
        return text.toString();
    }

}
