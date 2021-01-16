package com.example.virdi_speedywords;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameActivity extends AppCompatActivity {
    Stack s = new Stack();
    Button p1;
    Button p2;
    Button p3;
    Button p4;
    ImageView i1;
    ImageView i2;
    TextView categoryTextView;
    String names[] = {"Player 1", "Player 2", "Player 3", "Player 4"};
    int scores[] = {0, 0, 0, 0};
    int numOfPlayers;
    LinearLayout p3and4buttonLayout;
    Space spaceAfterP4;
    MediaPlayer ring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        try {
            FileInputStream in = openFileInput("names.txt");
            numOfPlayers = in.read();
            String display = "";
            int p1nameLength = in.read();
            for (int i = 0; i < p1nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display += letter;
            }
            names[0] = display;
            display = "";
            int p2nameLength = in.read();
            for (int i = 0; i < p2nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display += letter;
            }
            names[1] = display;
            display = "";
            int p3nameLength = in.read();
            for (int i = 0; i < p3nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display += letter;
            }
            names[2] = display;
            display = "";
            int p4nameLength = in.read();
            for (int i = 0; i < p4nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display += letter;
            }
            names[3] = display;
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        i1 = findViewById(R.id.pic1);
        i2 = findViewById(R.id.pic2);
        categoryTextView = findViewById(R.id.categoryTextView);
        p3and4buttonLayout = findViewById(R.id.p3and4buttonLayout);
        spaceAfterP4 = findViewById(R.id.spaceAfterP4);
        p1.setText(names[0] + ": -");
        p2.setText(names[1] + ": -");
        p3.setText(names[2] + ": -");
        p4.setText(names[3] + ": -");
        if (numOfPlayers == 2) {
            p3and4buttonLayout.setVisibility(View.GONE);
        } else if (numOfPlayers == 3) {
            p3and4buttonLayout.setVisibility(View.VISIBLE);
            spaceAfterP4.setVisibility(View.GONE);
            p4.setVisibility(View.GONE);
        } else if (numOfPlayers == 4) {
            p3and4buttonLayout.setVisibility(View.VISIBLE);
            spaceAfterP4.setVisibility(View.VISIBLE);
            p4.setVisibility(View.VISIBLE);
        }
        showCards();
    }

    public void backClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void resetClick(View view) {
        //sets the scores to 0
        for (int i = 0; i < scores.length; i++) {
            scores[i] = 0;
        }
        p1.setText(names[0] + ": -");
        p2.setText(names[1] + ": -");
        p3.setText(names[2] + ": -");
        p4.setText(names[3] + ": -");
        s.shuffle();
        showCards();
    }

    public void newCardClick(View view) {
        showCards();
    }

    //sets images on the screen and checks for winner
    public void showCards() {
        //sets images if stack not empty else checks for winner
        if (!s.isEmpty()) {
            Cards c = s.pop();
            c.setPicCategory(i1);
            c.setPicColouredLetters(i2);
            categoryTextView.setText("Category: " + c.getCardCategory());
        } else {
            Toast.makeText(this, names[maximum_index(scores)] + " wins!",
                    Toast.LENGTH_LONG).show();
        }
    }

    //returns max index of an array
    static int maximum_index(int a[]) {
        int maximum, index = 0, i = 1;
        maximum = a[0];
        while (i < a.length) {
            if (maximum < a[i]) {
                maximum = a[i];
                index = i;
            }
            i++;
        }
        return index;
    }

    public void p1click(View view) {
        scores[0]++;
        p1.setText(names[0] + ": " + scores[0]);
    }

    public void p2click(View view) {
        scores[1]++;
        p2.setText(names[1] + ": " + scores[1]);
    }

    public void p3click(View view) {
        scores[2]++;
        p3.setText(names[2] + ": " + scores[2]);
    }

    public void p4click(View view) {
        scores[3]++;
        p4.setText(names[3] + ": " + scores[3]);
    }
}