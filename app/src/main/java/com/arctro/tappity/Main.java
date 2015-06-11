package com.arctro.tappity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


public class Main extends Activity {

    String temp_text = "This is a sentence";
    String[] text;

    int position=-1;
    int correct=0;

    TextView text_display;
    EditText text_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=loadSentence().split("");

        text_display = (TextView) findViewById(R.id.text_display);
        text_input = (EditText) findViewById(R.id.text_input);

        TextView.OnEditorActionListener text_inputListener = new TextView.OnEditorActionListener(){
            public boolean onEditorAction(TextView exampleView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_NULL
                        && event.getAction() == KeyEvent.ACTION_DOWN) {
                    if(text_input.getText().toString().toLowerCase().equals(getCurrent().toLowerCase())){
                        correct++;
                    }
                    showNext();
                }
                return true;
            }
        };
        text_input.setOnEditorActionListener(text_inputListener);

        showNext();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showNext(){
        position++;
        text_display.setText(text[position]);
        text_input.setText("");
    }
    public String getCurrent(){
        return text[position];
    }

    public String loadSentence(){
        position=0;
        correct=0;
        return temp_text;
    }
}
