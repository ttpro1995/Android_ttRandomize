package com.hahattpro.ttrandomize;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.hahattpro.ttrandomlib.ttRandom;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    ttRandom random;
    Button mInteger;
    Button mReal;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar c = Calendar.getInstance();


        random = new ttRandom();

        mTextView = (TextView) findViewById(R.id.mTextViewID);
        mReal = (Button) findViewById(R.id.mReadButtonID);
        mInteger = (Button) findViewById(R.id.mIntegerButtonID);

        mReal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num;
                num = random.random_real();
                mTextView.setText( Double.toString(num));
            }
        });

        mInteger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num;
                num = random.random_integer(1,10);
                mTextView.setText(Integer.toString(num));
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
}
