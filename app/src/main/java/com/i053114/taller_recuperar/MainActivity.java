package com.i053114.taller_recuperar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.i053114.taller_recuperar.Views.CreateComida;
import com.i053114.taller_recuperar.Views.ListFood;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickShowWindowCreateComida(View view){
        Intent intent = new Intent(this, CreateComida.class);
        startActivity(intent);
    }

    public void onClickShowWindowListarComida(View view){
        Intent intent = new Intent(this, ListFood.class);
        startActivity(intent);
    }
}
