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

import static com.example.android.byaz.R.id.tv_total_3;

public class table_know extends AppCompatActivity {

    TextView txt1;
    TextView tv;
    String str;
    String dbstring="";
    TableLayout table ;
    Button bt;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_know);
        Intent intent=getIntent();
        str=intent.getStringExtra("a");
        table = (TableLayout) findViewById(R.id.myTableLayout_2);
        tv= (TextView) findViewById(tv_total_3);
        int l=str.length();
        //txt1= (TextView) findViewById(R.id.tv_large);
        //Toast.makeText(table_know.this,String.valueOf(l), Toast.LENGTH_SHORT).show();
        databaseHelper= new DatabaseHelper(table_know.this);
        Cursor cursor=databaseHelper.getData2(str);
        bt= (Button) findViewById(R.id.btn_return_options_3);
        int count=0;
        int checker=1;
        while(cursor.moveToNext())
        {
            TableRow tableRow2=new TableRow(table_know.this);
            TextView tvid=new TextView(table_know.this);
            TextView tvid1=new TextView(table_know.this);
            TextView tvid2=new TextView(table_know.this);
            TextView tvid3=new TextView(table_know.this);
            TextView tvid4=new TextView(table_know.this);
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
            //table.addView(tableRow2);

            table.addView(tableRow2);
            checker=checker+1;

        }
        tv= (TextView) findViewById(tv_total_3);
        tv.setText(Integer.toString(count));
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(table_know.this,options.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);
            }
        });



    }
}
