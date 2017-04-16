package com.example.android.byaz;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class delete2 extends AppCompatActivity {
    TextView tv1, tv2, tv3;
    Button bt;
    private DatabaseHelper databaseHelper;
    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete2);
        tv1=(TextView)findViewById(R.id.tvl_name);
        tv2=(TextView)findViewById(R.id.tvl_amount);
        tv3=(TextView)findViewById(R.id.tvl_id);
        bt=(Button)findViewById(R.id.bt_dlsubmit);
        final String s=tv2.getText().toString();
        databaseHelper= new DatabaseHelper(delete2.this);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result=databaseHelper.delete(tv1.getText().toString(),Integer.parseInt(tv2.getText().toString()),tv3.getText().toString());
                if(result==0)
                {
                    Toast.makeText(delete2.this,"No Record Exist",Toast.LENGTH_LONG).show();
                }
                else
                Toast.makeText(delete2.this,"Deleted Successfully",Toast.LENGTH_LONG).show();
            }
        });

    }
}
