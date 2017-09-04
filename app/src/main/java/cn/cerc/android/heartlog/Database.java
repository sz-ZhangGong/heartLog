package cn.cerc.android.heartlog;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jason<sz9214e@qq.com> on 2017/9/4.
 */

class Database extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "heartLogs.db";

    public Database(AppCompatActivity content) {
        super(content, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS trans (id_ integer primary key autoincrement not null, date_ char(23) not null, num1_ int, num2_ int, num3_ int, remark_ varchar(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("Database", "oldVersion: " + oldVersion);
        switch (oldVersion) {
            case 1:

            case 2:
            default:
        }
    }

    /**
     * @param num1 收缩压
     * @param num2 舒张压
     * @param num3 心率
     */
    public void save(int num1, int num2, int num3) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dt = formatter.format(date);
        String sql = String.format("insert into trans (date_,num1_,num2_,num3_) values ('%s', %s, %s, %s)", dt, "" + num1, "" + num2, "" + num3);
//        Log.d("Database", sql);
        this.getWritableDatabase().execSQL(sql);
    }

    public List<TransRecord> getTrans() {
        List<TransRecord> items = new ArrayList<>();

        Cursor cursor = getReadableDatabase().rawQuery("select * from trans", null);
        if (cursor.moveToFirst()) {
            do {
                TransRecord item = new TransRecord();
                item.setDate(cursor.getString(cursor.getColumnIndex("date_")));
                item.setNum1(cursor.getInt(cursor.getColumnIndex("num1_")));
                item.setNum2(cursor.getInt(cursor.getColumnIndex("num2_")));
                item.setNum3(cursor.getInt(cursor.getColumnIndex("num3_")));
                items.add(item);
            } while (cursor.moveToNext());
        }

        return items;
    }
}
