package com.example.android.byaz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button hit;
    private TextView tv_mar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_mar = (TextView) this.findViewById(R.id.mywidget);
        tv_mar.setSelected(true);  // Set focus to the textview
        tv_mar.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tv_mar.setSingleLine(true);
        tv= (TextView) findViewById(R.id.tv_password);
        hit= (Button) findViewById(R.id.btn);
        final String st="12345";

        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().toString().equals(st))
                {
                    Intent intent=new Intent(MainActivity.this,options.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
