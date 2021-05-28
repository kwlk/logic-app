package com.logic.app;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Solution {
    private Configuration configuration;
    private SortedSet<Word> words;
    private int logicCharactersCount;
    private int wholeSentenceCount;

    public Solution(Configuration conf){
        this.configuration = conf;
        this.logicCharactersCount = 0;
        this.wholeSentenceCount = 0;
        Comparator<Word> comparator = Comparator.comparingInt(Word::getUniqueCharactersLength)
                .thenComparingInt(Word::getWordLength).thenComparing(Word::getId);
        this.words = new TreeSet<>(comparator);
    }

    public void solve(String sentence){
        for (String w:getWords(sentence)){
            Word current = new Word(configuration.logicComparator(), wholeSentenceCount);
            for(char l: w.toCharArray()){
                char letter = Character.toLowerCase(l);
                this.wholeSentenceCount += 1;
                if(configuration.isLogicLetter(letter)){
                    current.addLogicLetter(letter);
                    this.logicCharactersCount += 1;
                } else {
                    current.addLetter();
                }
            }
            this.words.add(current);
        }

    }

    private List<String> getWords(String sentence){
        return Arrays.asList(sentence.split(String.valueOf(this.configuration.getSpecialCharacters())));
    }


    public void printSolution(){
        DecimalFormat df = new DecimalFormat();
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setMaximumFractionDigits(2);
        for(Word word:this.words){
            float frequency = (float) word.getUniqueCharactersCount()/this.logicCharactersCount;
            System.out.println(word+" = "+df.format(frequency)+" ("+word.getUniqueCharactersLength()+"/"
                    +this.logicCharactersCount+")");
        }
        System.out.println("TOTAL Frequency: "
                +df.format((float)this.logicCharactersCount/this.wholeSentenceCount)
                +" ("+this.logicCharactersCount+"/"+this.wholeSentenceCount+")");
    }
}
