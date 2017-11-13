package com.i053114.taller_recuperar.Views;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.i053114.taller_recuperar.Helpers.SqliteHelper;
import com.i053114.taller_recuperar.MainActivity;
import com.i053114.taller_recuperar.R;
import com.i053114.taller_recuperar.Utilities.Constans;

public class CreateComida extends Activity {
    TextInputEditText textInputEditTextName;
    TextInputEditText textInputEditTextPrice;
    TextInputEditText textInputEditTextDescription;
    SqliteHelper sqliteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_comida);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.id_tv_detail_name);
        textInputEditTextPrice = (TextInputEditText) findViewById(R.id.id_tv_detail_phone);
        textInputEditTextDescription = (TextInputEditText) findViewById(R.id.id_tv_detail_email);

        sqliteHelper = new SqliteHelper(this, "db_foods", null, 1);
    }

    public void onClickCreateUser(View view){

        String stringName = textInputEditTextName.getText().toString();
        String stringPrice = textInputEditTextPrice.getText().toString();
        String stringDescription = textInputEditTextDescription.getText().toString();

        if (TextUtils.isEmpty(stringName)){
            Toast.makeText(this, "El campo de nombre esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringPrice)){
            Toast.makeText(this, "El campo de telefono esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringDescription)){
            Toast.makeText(this, "El campo de email esta vacio", Toast.LENGTH_SHORT).show();
        }else{
            createUser();
        }
    }
    public void createUser(){
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constans.TABLA_FIELD_NAME, textInputEditTextName.getText().toString());
        values.put(Constans.TABLA_FIELD_PRICE, textInputEditTextPrice.getText().toString());
        values.put(Constans.TABLA_FIELD_DESCRIPTION, textInputEditTextDescription.getText().toString());

        Long idResult = db.insert(Constans.TABLA_NAME_FOOD, Constans.TABLA_FIELD_ID, values);

        textInputEditTextName.setText("");
        textInputEditTextPrice.setText("");
        textInputEditTextDescription.setText("");
        Toast.makeText(this, "usuario registrado", Toast.LENGTH_SHORT).show();
       Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickShowWindowregresar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
