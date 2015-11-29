package com.testing.ghassen.testing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    //TextView tv = new TextView(this.getApplicationContext());
    //TextView tv = (TextView) findViewById(R.id.jsonRes);
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
        tv = (TextView) findViewById(R.id.jsonRes);
        tv.setMovementMethod(new ScrollingMovementMethod());

    }

    public void addListenerOnButton() {
        Button button = (Button) findViewById(R.id.btn);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

               /* Toast.makeText(getApplicationContext(), "Hello Android Dev again ;)",
                        Toast.LENGTH_LONG).show();*/

                RequestTask task = (RequestTask) new RequestTask().execute("http://ambrosed.net/api/v1/restaurants");
                try {
                    String message = task.get();
                    tv.setText(message);
                   //Log.i("REST RESULT", task.get());
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        });

    }
}
