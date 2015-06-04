package com.android.jxcore.jxcoresample;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunJavaScriptAsync task = new RunJavaScriptAsync();
                task.execute();
            }
        });

    }

    public class RunJavaScriptAsync extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            /**
             * Hi Oguz!
             * What I'd like to show here is how you start the engine in this method.
             * Then you call the "writeMyName()" JS method and return the result (String).
             *
             * This is a different thread then the UI thread so imagine one can perform heavy
             * network/db tasks in his JS Code.
             *
             * Also please consider a case where the engine is already started (the button remains
             * enabled at all times) and you just want to invoke the JS method.
             *
             * Thanks,
             * Ori
             */

            EditText firstNameInput = (EditText)findViewById(R.id.editText1);
            EditText lastNameInput = (EditText)findViewById(R.id.editText2);
            return "Here comes the JS result about: "+firstNameInput.getText()+" and "+lastNameInput.getText();
        }

        @Override
        protected void onPostExecute(String result) {

            //This displays the result on the screen (done on the UI thread)
            TextView jsResult = (TextView)findViewById(R.id.result);
            jsResult.setText(result);

        }
    }
}
