package ca.yorku.caps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
        score = 0;
        qNum = 1;

        ask();

    }

    private void ask() {
        String qa = game.qa();
        question = qa.split("\n")[0];
        answer = qa.split("\n")[1];
        ((TextView) findViewById(R.id.question)).setText(question);
    }


    public void onDone(View v) {
        if (qNum >= 10) {
            finish();
        }
        String userAnswer = ((EditText) findViewById(R.id.answer)).getText().toString();
        if (userAnswer.toLowerCase() == answer.toLowerCase()) {
            score++;
        }
        String log;
        qNum++;
        if (qNum>=10) {

        }
        else {
            ((TextView) findViewById(R.id.score)).setText(Integer.toString(score));
            ((TextView) findViewById(R.id.qNum)).setText(Integer.toString(qNum));
        }
        ask();
    }
}
