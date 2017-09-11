
package com.example.aditya.notificationtest;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends Activity {
    Button btn;
    Button cancelBtn;
    int id;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        cancelBtn=(Button)findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                PingMe pm = new PingMe();
                Date date1 = new Date();
                Date date = new Date( date1.getTime()+10000);
                id =  pm.setNotification("title","desc", date,v.getContext());

            }    });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PingMe pm = new PingMe();
                pm.cancel(v.getContext(),id);

            }
        });


    }
}



