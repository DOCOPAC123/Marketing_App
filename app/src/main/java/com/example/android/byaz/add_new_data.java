package com.example.android.byaz;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class add_new_data extends AppCompatActivity {

    TextView tv1,tv2,tv3;
    Button bt;
    private DatabaseHelper databaseHelper;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_data);
        tv1= (TextView) findViewById(R.id.tv_name);
        tv2= (TextView) findViewById(R.id.tv_amount);
        tv3= (TextView) findViewById(R.id.tv_duration);
        bt= (Button) findViewById(R.id.bt_details);

       Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d-E", Locale.US);
      final String strDate= sdf.format(cal.getTime());
        Toast.makeText(this,strDate,Toast.LENGTH_LONG).show();


        databaseHelper= new DatabaseHelper(add_new_data.this);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result=databaseHelper.insertData(tv1.getText().toString(),Integer.parseInt(tv2.getText().toString()),Integer.parseInt(tv3.getText().toString()),strDate);
                if(result)
                    Toast.makeText(add_new_data.this,"Inserted successfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(add_new_data.this, "not Inserted successfully",Toast.LENGTH_LONG).show();
                Intent intent= new Intent(add_new_data.this,options.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);
            }
        });

    }
}
