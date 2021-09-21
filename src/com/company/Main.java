package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string of letters: ");
        String letterIn = input.next();
        int count = 0;
        String prevLetter = "";
        String RLEFull = "";
        char prevChar = 0;
        for (int i=0; i < letterIn.length(); i++) {
            if (prevLetter == "") {
                prevChar = letterIn.charAt(i);
                prevLetter = Character.toString(letterIn.charAt(i));
                RLEFull = prevLetter;
                count = 1;
            }
            else {
                if (letterIn.charAt(i) == prevChar) {
                    count += 1;
                }
                else {
                    RLEFull += count;
                    RLEFull += Character.toString(letterIn.charAt(i));
                    count = 1;
                }
                prevLetter = Character.toString(letterIn.charAt(i));
                prevChar = letterIn.charAt(i);
            }
        }
        RLEFull += count;
        if (letterIn.length() > RLEFull.length()) {
            System.out.println("Original text: " + letterIn + "\nNew text: " + RLEFull + "\nYou just saved " + (letterIn.length() - RLEFull.length() + " character(s)"));
        }
        else if (letterIn.length() == RLEFull.length()) {
            System.out.println("Original text: " + letterIn + "\nNew text: " + RLEFull + "\nYou have not saved nor gained any characters");
        }
        else {
            System.out.println("Original text: " + letterIn + "\nNew text: " + RLEFull + "\nYou just gained " + (RLEFull.length() - letterIn.length()) + " characters");
        }
    }
}
