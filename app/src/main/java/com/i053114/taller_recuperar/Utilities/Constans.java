package com.i053114.taller_recuperar.Utilities;

/**
 * Created by chris on 13/11/2017.
 */

public class Constans {
    public static final String TABLA_NAME_FOOD = "food";
    public static final String TABLA_FIELD_ID = "id";
    public static final String TABLA_FIELD_NAME = "name";
    public static final String TABLA_FIELD_PRICE = "price";
    public static final String TABLA_FIELD_DESCRIPTION = "description";
    public static final String CREATE_TABLE_FOOD =
            "CREATE TABLE "+ TABLA_NAME_FOOD+" ("+
                    TABLA_FIELD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_NAME+" TEXT, "+
                    TABLA_FIELD_PRICE+" TEXT, "+
                    TABLA_FIELD_DESCRIPTION+" TEXT)";
}
