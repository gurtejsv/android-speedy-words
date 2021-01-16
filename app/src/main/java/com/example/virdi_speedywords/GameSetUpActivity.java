package com.example.virdi_speedywords;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GameSetUpActivity extends AppCompatActivity {
    LinearLayout p3layout;
    LinearLayout p4layout;
    LinearLayout EditTextLayout;
    EditText p1EditText;
    EditText p2EditText;
    EditText p3EditText;
    EditText p4EditText;
    Button twoPlayerButton;
    Button threePlayerButton;
    Button fourPlayerButton;
    Drawable oldButtonBg;
    int numOfPlayers;
    String p1name;
    String p2name;
    String p3name;
    String p4name;
    Space spaceAfterNextButton;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_set_up);
        p3layout = findViewById(R.id.p3layout);
        p4layout = findViewById(R.id.p4layout);
        EditTextLayout = findViewById(R.id.EditTextLayout);
        p1EditText = findViewById(R.id.p1EditText);
        p2EditText = findViewById(R.id.p2EditText);
        p3EditText = findViewById(R.id.p3EditText);
        p4EditText = findViewById(R.id.p4EditText);
        nextButton = findViewById(R.id.nextButton);
        spaceAfterNextButton = findViewById(R.id.spaceAfterNextButton);
        twoPlayerButton = findViewById(R.id.twoPlayerButton);
        threePlayerButton = findViewById(R.id.threePlayerButton);
        fourPlayerButton = findViewById(R.id.fourPlayerButton);
        oldButtonBg = twoPlayerButton.getBackground();
        p3layout.setVisibility(View.VISIBLE);
        p4layout.setVisibility(View.VISIBLE);
        numOfPlayers = 0;
        EditTextLayout.setVisibility(View.GONE);
        spaceAfterNextButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);
    }

    public void nextClick(View view) {
        p1name = p1EditText.getText().toString();
        p2name = p2EditText.getText().toString();
        p3name = p3EditText.getText().toString();
        p4name = p4EditText.getText().toString();
        if (p1name.equals("") || p2name.equals("") || (p3name.equals("") && numOfPlayers >= 3) || (p4name.equals("") && numOfPlayers == 4)) {
            Toast.makeText(this, "Player name(s) aren't entered! Please try again.",
                    Toast.LENGTH_LONG).show();
        } else if (p1name.contains(" ") || p2name.contains(" ") || (p3name.contains(" ") && numOfPlayers >= 3) || (p4name.contains(" ") && numOfPlayers == 4)) {
            Toast.makeText(this, "Player name(s) use spaces! Please try again.",
                    Toast.LENGTH_LONG).show();
        } else {
            try {
                FileOutputStream out = openFileOutput("names.txt", Activity.MODE_PRIVATE);
                out.write(numOfPlayers);
                out.write(p1name.length());
                for (int i = 0; i < p1name.length(); i++) {
                    out.write((int) (p1name.charAt(i)));
                }
                out.write(p2name.length());
                for (int i = 0; i < p2name.length(); i++) {
                    out.write((int) (p2name.charAt(i)));
                }
                out.write(p3name.length());
                for (int i = 0; i < p3name.length(); i++) {
                    out.write((int) (p3name.charAt(i)));
                }
                out.write(p4name.length());
                for (int i = 0; i < p4name.length(); i++) {
                    out.write((int) (p4name.charAt(i)));
                }
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            startActivity(new Intent(this, GameActivity.class));
        }
    }

    public void twoPlayerClick(View view) {
        p3layout.setVisibility(View.GONE);
        p4layout.setVisibility(View.GONE);
        twoPlayerButton.setBackgroundColor(Color.parseColor("#898989"));
        threePlayerButton.setBackground(oldButtonBg);
        fourPlayerButton.setBackground(oldButtonBg);
        EditTextLayout.setVisibility(View.VISIBLE);
        spaceAfterNextButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.VISIBLE);
        numOfPlayers = 2;
    }

    public void threePlayerClick(View view) {
        p3layout.setVisibility(View.VISIBLE);
        p4layout.setVisibility(View.GONE);
        threePlayerButton.setBackgroundColor(Color.parseColor("#898989"));
        twoPlayerButton.setBackground(oldButtonBg);
        fourPlayerButton.setBackground(oldButtonBg);
        EditTextLayout.setVisibility(View.VISIBLE);
        spaceAfterNextButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.VISIBLE);
        numOfPlayers = 3;
    }

    public void fourPlayerClick(View view) {
        p3layout.setVisibility(View.VISIBLE);
        p4layout.setVisibility(View.VISIBLE);
        fourPlayerButton.setBackgroundColor(Color.parseColor("#898989"));
        twoPlayerButton.setBackground(oldButtonBg);
        threePlayerButton.setBackground(oldButtonBg);
        EditTextLayout.setVisibility(View.VISIBLE);
        spaceAfterNextButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.VISIBLE);
        numOfPlayers = 4;
    }

    public void backClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}