package com.logic.app;

import java.util.*;

public class Word {
    private int id;
    private Map<Character, Integer> characters;
    private int length;
    private int count;

    public Word(Comparator<Character> comparator, int id){
        this.id = id;
        this.characters = new TreeMap<>(comparator);
        this.length = 0;
        this.count = 0;
    }

    public Word(int id) {
        this.id = id;
        this.characters = new TreeMap<>();
        this.length = 0;
        this.count = 0;
    }

    public void addLetter(){
        this.length += 1;
    }

    public void addLogicLetter(char letter){
        this.characters.merge(letter, 1, Integer::sum);
        addLetter();
        this.count += 1;
    }

    public int getWordLength(){return this.length;}

    public int getUniqueCharactersLength(){return this.characters.size();}

    public int getUniqueCharactersCount(){return this.count;}

    public int getId(){return this.id;}

    public boolean hasLetter(char letter){
        return this.characters.containsKey(letter);
    }

    public String toString(){
        StringBuilder logicLetters = new StringBuilder();
        if(this.characters.size()>0){
            for(char letter: this.characters.keySet()){
                logicLetters.append(letter).append(", ");
            }
            logicLetters.setLength(logicLetters.length()-2);
        }
        return "{("+logicLetters+"), "+this.length+"}";
    }
}
