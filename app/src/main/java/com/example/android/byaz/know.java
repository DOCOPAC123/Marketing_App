package com.example.android.byaz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class know extends AppCompatActivity {

    EditText person;
    Button knall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know);
        person =(EditText)findViewById(R.id.et_person_3);
        knall= (Button) findViewById(R.id.bt_knowall_3);
        final String s;
        knall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(know.this,table_know.class);
                intent.putExtra("a",person.getText().toString());
                //Toast.makeText(know_all.this,person.getText().toString(),Toast.LENGTH_SHORT).show();
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);
            }
        });
    }
}
