package cn.edu.hebtu.software.cai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context, String name, int version){
        super(context,name,null,version);
    }
    public void onCreate(SQLiteDatabase db){
        String sql = "create table user(id integer primary key," +
                "name text not null,account text not null," +
                "password text not null)";
        db.execSQL(sql);
        Log.e("DBHelper","onCreate创建user表成功");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.e("DBHelper","onUpgrade");
    }
}

