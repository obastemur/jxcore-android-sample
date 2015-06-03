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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class RunJavaScriptAsync extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            EditText firstNameInput = (EditText)findViewById(R.id.editText1);
            EditText lastNameInput = (EditText)findViewById(R.id.editText2);
            return "Here comes the JS result about: "+firstNameInput.getText()+" and "+lastNameInput.getText();
        }

        @Override
        protected void onPostExecute(String result) {

            TextView jsResult = (TextView)findViewById(R.id.result);
            jsResult.setText(result);

        }
    }
}
