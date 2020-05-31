package com.emrebozkurt.mobekspertiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper2 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="register.db";
    public static final String TABLE_NAME ="registeruser";
    public static final String TABLE_NAME2 ="tbl_Reports";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="username";
    public static final String COL_3 ="password";
    private static final String CREATE_TABLE_REPORTS ="CREATE TABLE tbl_Reports (report_ID INTEGER PRIMARY KEY AUTOINCREMENT,report_numberPlate TEXT, report_ceiling TEXT,report_frontPanel TEXT,report_chassis TEXT,report_masts TEXT,report_glass TEXT)";
    private static final String CREATE_TABLE_REGISTERUSER = "CREATE TABLE registeruser (ID INTEGER PRIMARY  KEY AUTOINCREMENT, username TEXT, password TEXT)";
    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE_REPORTS);
        sqLiteDatabase.execSQL(CREATE_TABLE_REGISTERUSER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS '" + TABLE_NAME+"'");
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS '" + TABLE_NAME2+"'");
        onCreate(sqLiteDatabase);
    }
    public long addReport(String numberPlate,String ceiling,String frontPanel,String chassis,String masts,String glass)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("report_numberPlate",numberPlate);
        contentValues.put("report_ceiling",ceiling);
        contentValues.put("report_frontPanel",frontPanel);
        contentValues.put("report_chassis",chassis);
        contentValues.put("report_masts",masts);
        contentValues.put("report_glass",glass);
        long donecek = db.insert("tbl_Reports",null,contentValues);
        db.close();
        return donecek;

    }

    public long addUser(String user, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("CREATE TABLE tbl_Reports (report_ID INTEGER PRIMARY KEY AUTOINCREMENT,report_numberPlate TEXT,report_ceiling TEXT,report_numberPlate TEXT,report_frontPanel TEXT,report_chassis TEXT,report_masts TEXT,report_glass TEXT)");
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        long res = db.insert("registeruser",null,contentValues);
        db.close();
        return  res;
    }

    public boolean checkUser(String username, String password){
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;
    }

    public List<String> VeriListele() {
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {"report_ID", "report_numberPlate", "report_ceiling", "report_frontPanel", "report_chassis", "report_masts", "report_glass"};
            Cursor cursor = db.query("tbl_Reports", stunlar, null, null, null, null, null);
            while (cursor.moveToNext()) {
                veriler.add("Sıra No :"+cursor.getInt(0)
                        + " \n"
                        + "Plaka :" +cursor.getString(1)
                        + "\n"
                        + "Tavan :" +cursor.getString(2)
                        + "\n"
                        + "Ön Panel :" +cursor.getString(3)
                        + "\n"
                        +"Şase : " + cursor.getString(4)
                        + "\n"
                        +"Direkler :"+ cursor.getString(5)
                        + "\n"
                        +"Camlar : " + cursor.getString(6));
            }
        } catch (Exception e) {
        }
        db.close();
        return veriler;


    }
}
