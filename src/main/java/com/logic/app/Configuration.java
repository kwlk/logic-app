package com.logic.app;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Configuration {
    private Word logicWord;
    private List<Character> specialCharacters;
    private Comparator<Character> comparator;

    public Configuration(String logicWord, String fileName) throws IOException {
        this.logicWord = new Word(-1);
        List<Character> logicLetters = new ArrayList<>();
        for(char letter:logicWord.toCharArray()) {
            char chart = Character.toLowerCase(letter);
            logicLetters.add(chart);
            this.logicWord.addLogicLetter(chart);
        }
        this.specialCharacters = new ArrayList<>();
        if(fileName == null){
            fileName = "specialCharacters.txt";
        }

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }


        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        int intch;
        while ((intch = reader.read()) != -1) {
            char d = (char) intch;
            this.specialCharacters.add(d);
        }

        this.comparator = Comparator.comparingInt(logicLetters::indexOf);
    }

    public boolean isLogicLetter(char letter){
        return logicWord.hasLetter(letter);
    }

    public List<Character> getSpecialCharacters(){return this.specialCharacters;}

    public Comparator<Character> logicComparator(){
        return this.comparator;
    }
}
