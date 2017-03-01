package com.xiaojiu.mvpdmeo.model.dao.bean;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.xiaojiu.mvpdmeo.MyApplication;

/**
 * 作者：${xiaojiukeji} on 17/3/1 21:55
 * 作用:
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASENAME = "itxiaojiu.db";
    private static final int DATABASEVERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    /*
    * 单例模式
    * 双重校验:提高效率
    * */
    private static DBHelper dbHelper;

    public static DBHelper getInstance() {
        if (dbHelper == null) {
            //考虑加锁
            synchronized (DBHelper.class) {
                if (dbHelper == null) {
                    dbHelper = new DBHelper(MyApplication.getContext());
                }
            }
        }
        return dbHelper;
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
