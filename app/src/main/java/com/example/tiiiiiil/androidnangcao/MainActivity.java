package com.example.tiiiiiil.androidnangcao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
private Button btnOpen;
private  Button btnStop;
private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent= new Intent(this, MyService.class);
        intitViews();
    }
    public void  intitViews(){
        btnOpen = findViewById(R.id.btnOpen);
        btnStop = findViewById(R.id.btnStop);
        btnOpen.setOnClickListener( this);
        btnStop.setOnClickListener( this);

    }
    public  void onClick(View view){
        int id = view.getId();
        if(id==R.id.btnOpen){
            //showMessage("Open is clicked");

            Bundle bundle=new Bundle( );
            bundle.putInt("id",123);
            intent.putExtra("data",bundle);
            startService(intent);
        }else if(id==R.id.btnStop){
            showMessage("Stop is clicked");
            stopService(intent);
        }

        }
        public  void  showMessage(String text){
            Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
        }
}
