package com.example.virdi_speedywords;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stack {
    private int count;
    private Cards data[] = new Cards[22];

    public Stack() {
        shuffle();
    }

    //shuffles array
    public void shuffle() {
        //TO DO: Make an array for each instance variable. A card's pieces are all in the same index
        String categories[] = {"animal(blue)", "animal(green)", "animal(orange)",
                "city(blue)", "city(green)", "city(orange)",
                "country(blue)", "country(green)", "country(orange)",
                "famous person(blue)", "famous person(green)", "famous person(orange)",
                "food(blue)", "food(green)", "food(orange)",
                "movie(blue)", "movie(green)", "movie(orange)",
                "name(blue)", "name(green)", "name(orange)",
                "object(blue)", "object(green)", "object(orange)",
                "plant(blue)", "plant(green)", "plant(orange)"};
        String colouredLetters[] = {"p1", "p2", "p3", "p4", "p5",
                "p6", "p7", "p8", "p9", "p10",
                "p11", "p12", "p13", "p14", "p15",
                "p16", "p17", "p18", "p19", "p20",
                "p21", "p22"};

        //TO DO: Randomize the order of the arrays
        List<String> StringList = Arrays.asList(categories);
        Collections.shuffle(StringList);
        StringList.toArray(categories);
        StringList = Arrays.asList(colouredLetters);
        Collections.shuffle(StringList);
        StringList.toArray(colouredLetters);
        count = 0;

        //TO DO: push all (now in random order) into the Deck
        for (int i = 0; i < colouredLetters.length; i++) {
            Cards c = new Cards(categories[i], colouredLetters[i]);
            push(c);
        }
    }

    //pushes card to stack
    public void push(Cards addMe) {
        data[count] = addMe;
        count++;
    }

    //returns the size of stack
    public int size() {
        return count;
    }

    //returns if stack full or not
    public boolean isFull() {
        return (count == 50);
    }

    //pops card from stack
    public Cards pop() {
        count--;
        return data[count];
    }

    //returns last card from deck
    public Cards peek() {
        return data[count--];
    }

    //returns if stack empty or not
    public boolean isEmpty() {
        return count == 0;
    }

    //clears stack of cards
    public void clear() {
        count = 0;
    }
}
