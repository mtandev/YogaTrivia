package com.mtandev.yogatrivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    int correctAnswers = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }

    private void checkQ1Answer() {
        CheckBox q1Vinyasa = (CheckBox) findViewById(R.id.answerVinyasa);
        CheckBox q1Ashtanga = (CheckBox) findViewById(R.id.answerAshtanga);
        CheckBox q1Hatha = (CheckBox) findViewById(R.id.answerHatha);
        CheckBox q1Bikram = (CheckBox) findViewById(R.id.answerBikram);

        boolean isQ1VinyasaChecked = q1Vinyasa.isChecked();
        boolean isQ1AshtangaChecked = q1Ashtanga.isChecked();
        boolean isQ1HathaChecked = q1Hatha.isChecked();
        boolean isQ1BikramChecked = q1Bikram.isChecked();

        if (isQ1VinyasaChecked && isQ1AshtangaChecked && !isQ1HathaChecked && !isQ1BikramChecked) {
            correctAnswers += 1;
        }
    }

    private void  checkQ2Answer() {
        RadioButton radioButtonUnion = (RadioButton) findViewById(R.id.radioUnion);

        boolean isRadioButtonUnionChecked = radioButtonUnion.isChecked();

        if (isRadioButtonUnionChecked) {
            correctAnswers += 1;
        }
    }

    private void checkQ3Answer () {
        EditText userInputName = (EditText) findViewById(R.id.answerInputName);
        String name = userInputName.getText().toString();
        String answer = "iyengar";
        boolean isQ3Correct = answer.equals(name);

        if (name.trim().equalsIgnoreCase("iyengar")) {
            correctAnswers += 1;
        }
    }

    private void checkQ4Answer () {
        RadioButton radioButtonAma = (RadioButton) findViewById(R.id.answerAma);
        boolean isRadioButtonAmaChecked = radioButtonAma.isChecked();
        if (isRadioButtonAmaChecked) {
            correctAnswers += 1;
        }
    }

    private void checkQ5Answer () {
        CheckBox answerAhimsa = (CheckBox) findViewById(R.id.answerAhimsa);
        CheckBox answerSatya = (CheckBox) findViewById(R.id.answerSatya);
        CheckBox answerAsteya = (CheckBox) findViewById(R.id.answerAsteya);

        boolean isAnswerAhimsaChecked = answerAhimsa.isChecked();
        boolean isAnswerSatyaChecked = answerSatya.isChecked();
        boolean isAnswerAsteyaChecked = answerAsteya.isChecked();

        if (isAnswerAhimsaChecked && isAnswerSatyaChecked && !isAnswerAsteyaChecked) {
            correctAnswers += 1;
        }
    }

    private void checkAllQs () {
        checkQ1Answer();
        checkQ2Answer();
        checkQ3Answer();
        checkQ4Answer();
        checkQ5Answer();
    }

    private void resetCounter () {

        correctAnswers = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            checkAllQs();
            Toast.makeText(MainActivity.this, "You got " + correctAnswers + " out of five.", Toast.LENGTH_LONG).show();
            resetCounter();
        }
    };

}
