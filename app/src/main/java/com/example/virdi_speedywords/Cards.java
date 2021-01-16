package com.example.virdi_speedywords;

import android.widget.ImageView;

public class Cards {
    private String cardCategory;
    private String cardColouredLetters;

    Cards(String c, String l) {
        cardCategory = c;
        cardColouredLetters = l;
    }

    //sets picture of cardCategory
    public void setPicCategory(ImageView picture) {
        if (cardCategory.equals("animal(blue)"))
            picture.setImageResource(R.drawable.animalblue);
        else if (cardCategory.equals("animal(green)"))
            picture.setImageResource(R.drawable.animalgreen);
        else if (cardCategory.equals("animal(orange)"))
            picture.setImageResource(R.drawable.animalorange);
        else if (cardCategory.equals("city(blue)"))
            picture.setImageResource(R.drawable.cityblue);
        else if (cardCategory.equals("city(green)"))
            picture.setImageResource(R.drawable.citygreen);
        else if (cardCategory.equals("city(orange)"))
            picture.setImageResource(R.drawable.cityorange);
        else if (cardCategory.equals("country(blue)"))
            picture.setImageResource(R.drawable.countryblue);
        else if (cardCategory.equals("country(green)"))
            picture.setImageResource(R.drawable.countrygreen);
        else if (cardCategory.equals("country(orange)"))
            picture.setImageResource(R.drawable.countryorange);
        else if (cardCategory.equals("famous person(blue)"))
            picture.setImageResource(R.drawable.famousblue);
        else if (cardCategory.equals("famous person(green)"))
            picture.setImageResource(R.drawable.famousgreenjpg);
        else if (cardCategory.equals("famous person(orange)"))
            picture.setImageResource(R.drawable.famousorange);
        else if (cardCategory.equals("food(blue)"))
            picture.setImageResource(R.drawable.foodblue);
        else if (cardCategory.equals("food(green)"))
            picture.setImageResource(R.drawable.foodgreen);
        else if (cardCategory.equals("food(orange)"))
            picture.setImageResource(R.drawable.foodorange);
        else if (cardCategory.equals("movie(blue)"))
            picture.setImageResource(R.drawable.moviegblue);
        else if (cardCategory.equals("movie(green)"))
            picture.setImageResource(R.drawable.moviegreen);
        else if (cardCategory.equals("movie(orange)"))
            picture.setImageResource(R.drawable.movieorange);
        else if (cardCategory.equals("name(blue)"))
            picture.setImageResource(R.drawable.nameblue);
        else if (cardCategory.equals("name(green)"))
            picture.setImageResource(R.drawable.namegreen);
        else if (cardCategory.equals("name(orange)"))
            picture.setImageResource(R.drawable.nameorange);
        else if (cardCategory.equals("object(blue)"))
            picture.setImageResource(R.drawable.objectblue);
        else if (cardCategory.equals("object(green)"))
            picture.setImageResource(R.drawable.objectgreen);
        else if (cardCategory.equals("object(orange)"))
            picture.setImageResource(R.drawable.objectorange);
        else if (cardCategory.equals("plant(blue)"))
            picture.setImageResource(R.drawable.plantblue);
        else if (cardCategory.equals("plant(green)"))
            picture.setImageResource(R.drawable.plantgreen);
        else
            picture.setImageResource(R.drawable.plantorange);
    }

    //sets picture of cardColouredLetters
    public void setPicColouredLetters(ImageView picture) {
        if (cardColouredLetters.equals("p1"))
            picture.setImageResource(R.drawable.p1);
        else if (cardColouredLetters.equals("p2"))
            picture.setImageResource(R.drawable.p2);
        else if (cardColouredLetters.equals("p3"))
            picture.setImageResource(R.drawable.p3);
        else if (cardColouredLetters.equals("p4"))
            picture.setImageResource(R.drawable.p4);
        else if (cardColouredLetters.equals("p5"))
            picture.setImageResource(R.drawable.p5);
        else if (cardColouredLetters.equals("p6"))
            picture.setImageResource(R.drawable.p6);
        else if (cardColouredLetters.equals("p7"))
            picture.setImageResource(R.drawable.p7);
        else if (cardColouredLetters.equals("p8"))
            picture.setImageResource(R.drawable.p8);
        else if (cardColouredLetters.equals("p9"))
            picture.setImageResource(R.drawable.p9);
        else if (cardColouredLetters.equals("p10"))
            picture.setImageResource(R.drawable.p10);
        else if (cardColouredLetters.equals("p11"))
            picture.setImageResource(R.drawable.p11);
        else if (cardColouredLetters.equals("p12"))
            picture.setImageResource(R.drawable.p12);
        else if (cardColouredLetters.equals("p13"))
            picture.setImageResource(R.drawable.p13);
        else if (cardColouredLetters.equals("p14"))
            picture.setImageResource(R.drawable.p14);
        else if (cardColouredLetters.equals("p15"))
            picture.setImageResource(R.drawable.p15);
        else if (cardColouredLetters.equals("p16"))
            picture.setImageResource(R.drawable.p16);
        else if (cardColouredLetters.equals("p17"))
            picture.setImageResource(R.drawable.p17);
        else if (cardColouredLetters.equals("p18"))
            picture.setImageResource(R.drawable.p18);
        else if (cardColouredLetters.equals("p19"))
            picture.setImageResource(R.drawable.p19);
        else if (cardColouredLetters.equals("p20"))
            picture.setImageResource(R.drawable.p20);
        else if (cardColouredLetters.equals("p21"))
            picture.setImageResource(R.drawable.p21);
        else
            picture.setImageResource(R.drawable.p22);
    }

    //returns cardCategory
    public String getCardCategory() {
        return cardCategory;
    }

    //returns cardColouredLetters
    public String getCardColouredLetters() {
        return cardColouredLetters;
    }
}
