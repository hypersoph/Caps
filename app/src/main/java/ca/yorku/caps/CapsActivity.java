package ca.yorku.caps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
        Log.d("question", question);
        Log.d("answer", answer);
    }


    public void onDone(View v) {
        if (qNum == 10) {
            finish();
        }
        String userAnswer = ((EditText) findViewById(R.id.answer)).getText().toString().toUpperCase();

        /* IMPORTANT: do not use == to compare strings */
        if (userAnswer.equals(answer.toUpperCase())) {
            score++;
        }
        Log.d("score",String.format("SCORE = %d",score));
        String log = String.format("Q# %d: %s\nYour answer: %s\nCorrect answer: %s\n\n", qNum, question, userAnswer, answer);
        TextView tLog = ((TextView) findViewById(R.id.log));
        tLog.setText(log + tLog.getText());
        ((TextView) findViewById(R.id.score)).setText(String.format("SCORE = %d",score));
        qNum++;

        if (qNum>=10) {
            ((TextView) findViewById(R.id.qNum)).setText("Game Over!");
            ((Button) findViewById(R.id.done)).setEnabled(false);
        }
        else {
            ((TextView) findViewById(R.id.qNum)).setText(String.format("Q# %d",qNum));
            ((EditText) findViewById(R.id.answer)).setText("");
            ask();
        }

    }
}
