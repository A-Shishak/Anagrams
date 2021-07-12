package com.shishakalex.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramConsoleApp {

    public static void main(String[] args) {
        String inputStringToBeReversed = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            inputStringToBeReversed = reader.readLine();
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        String resultReversedString = new AnagramCreator().makeAnagram(inputStringToBeReversed);
        System.out.println(resultReversedString);
    }
}
