package ca.yorku.caps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CapsActivity extends AppCompatActivity
{
    private Game game;
    private String question;
    private String answer;
    private int score;
    private int qNum;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caps_layout);

        game = new Game();
        question = game.qa();

    }
}
