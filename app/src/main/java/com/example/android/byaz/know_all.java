package com.example.android.byaz;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class know_all extends AppCompatActivity {

    TextView txt1;
    String str;
    Button rohit;
    TextView tv_total;
    String dbstring="";
    TableLayout table ;
    private DatabaseHelper databaseHelper;
    Button bt_2wala;
    TextView record;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_all);
        //record= (TextView) findViewById(R.id.record);
       // Intent intent=getIntent();
        //str=intent.getStringExtra("a");
        table = (TableLayout) findViewById(R.id.myTableLayout_2);
        //String s;
       // s="RECORD OF "+ str;
        //bt_2wala= (Button) findViewById(R.id.btn_2wala);
        //record.setText(s);
        //int l=str.length();
       // Toast.makeText(know_all.this,String.valueOf(l), Toast.LENGTH_SHORT).show();
        databaseHelper= new DatabaseHelper(know_all.this);
        int count=0;
        int checker=1;
        Cursor cursor=databaseHelper.getData();
        while(cursor.moveToNext())
        {
            TableRow tableRow2=new TableRow(know_all.this);
            TextView tvid=new TextView(know_all.this);
            TextView tvid1=new TextView(know_all.this);
            TextView tvid2=new TextView(know_all.this);
            TextView tvid3=new TextView(know_all.this);
            TextView tvid4=new TextView(know_all.this);
            ////////////////////////////////////////////////////////////////////////////////////////

            tvid.setText(Integer.toString(checker));
            tableRow2.addView(tvid,0);

            tvid1.setText(cursor.getString(1));
            tableRow2.addView(tvid1,1);

            tvid2.setText(cursor.getString(2));
            tableRow2.addView(tvid2,2);

            tvid3.setText(cursor.getString(3));
            tableRow2.addView(tvid3,3);
            tvid4.setText(cursor.getString(4));
            tableRow2.addView(tvid4,4);
            count=count+Integer.parseInt(cursor.getString(2));
            table.addView(tableRow2);
            checker=checker+1;

        }
        tv_total= (TextView) findViewById(R.id.tv_total_2);
        tv_total.setText(Integer.toString(count));
        /*
        bt_2wala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(know_all.this,options.class);
                startActivity(intent);
            }
        });
        */
        rohit= (Button) findViewById(R.id.bt_rohit);
        rohit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(know_all.this,options.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);
            }
        });






    }
}
