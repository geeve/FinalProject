package com.example.android.showjokelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        String joke = getIntent().getStringExtra("joke");
        TextView jokeTextView = (TextView) findViewById(R.id.txt_joke_show);
        jokeTextView.setText(joke);
    }
}
