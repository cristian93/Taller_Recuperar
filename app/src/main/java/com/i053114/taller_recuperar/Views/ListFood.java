package com.i053114.taller_recuperar.Views;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.i053114.taller_recuperar.Adapters.FoodAdapter;
import com.i053114.taller_recuperar.Helpers.SqliteHelper;
import com.i053114.taller_recuperar.Models.Food;
import com.i053114.taller_recuperar.R;

import java.util.ArrayList;
import java.util.List;

public class ListFood extends AppCompatActivity {
    RecyclerView recyclerViewFood;
    FoodAdapter foodAdapter;
    List<Food> foodList = new ArrayList<>();
    SqliteHelper sqliteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);


        sqliteHelper = new SqliteHelper(this, "db_food", null, 1);
        recyclerViewFood = (RecyclerView) findViewById(R.id.id_rv_food22);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewFood.setLayoutManager(linearLayoutManager);

        listComidas();
    }
    public void listComidas(){
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select id,name,price,description from food order by id desc" , null);

        while (cursor.moveToNext()){

            Food food = new Food();
            food.setId(cursor.getInt(0));
            food.setName(cursor.getString(1));
            food.setPrice(cursor.getString(2));
            food.setDescription(cursor.getString(3));
            foodList.add(food);
        }

        cursor.close();

        if (foodList.size() != 0){
            processData();
        }else{
            Toast.makeText(this, "Lista vacia", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData(){
         foodAdapter= new FoodAdapter(foodList, getApplicationContext());
        recyclerViewFood.setAdapter(foodAdapter);
    }

}
