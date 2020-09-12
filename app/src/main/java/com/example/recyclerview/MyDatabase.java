package com.example.recyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

class MyDatabase extends SQLiteAssetHelper {
    public static final String DB_NAME="cars.db";
    public static final int DB_VERSION=1;
    public static final String CAR_TB_NAME ="car";
    public static final String CAR_CLN_ID ="id";
    public static final String CAR_CLN_MODEL ="model";
    public static final String CAR_CLN_COLOR ="color";
    public static final String CAR_CLN_BPL ="distancePerLetter";
    public static final String CAR_CLN_DESCRIPTION = "description";
    public static final String CAR_CLN_IMAGE = "image";





    public MyDatabase(Context context){
        super(context,DB_NAME,null, DB_VERSION );

    }
//   DatabaseAccess db = DatabaseAccess.getInstance(this);

//    @Override
//    public void onCreate(SQLiteDatabase  sqLiteDatabase) {
//        //يتم استدعاءها عند انشاء داتبيس فقط
//        sqLiteDatabase.execSQL("CREATE TABLE "+CAR_TB_NAME+"("+CAR_CLN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ CAR_CLN_MODEL+"  TEXT, "+CAR_CLN_COLOR+" TEXT, "+CAR_CLN_BPL+" REAL)");
//    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //يتم استدعاءها عند تحديث الداتبيس
        //DROP فقط تستخدم في مرحلة التطوير
        //في حالة كان جاهز استخدم ALTAER
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+CAR_TB_NAME);
        onCreate(sqLiteDatabase);

//    }
//    //دالة الاضافة
//    public boolean insertCar(Car car){
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues contentValues=new ContentValues();
//        contentValues.put(CAR_CLN_MODEL,car.getModel());
//        contentValues.put(CAR_CLN_COLOR,car.getColor());
//        contentValues.put(CAR_CLN_BPL,car.getDpl());
//        long result =  db.insert(CAR_TB_NAME,null,contentValues);
//        return  result!= -1;
//
//    }
//    //دالة التعديل
//    public boolean updateCar(Car car){
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues contentValues=new ContentValues();
//        contentValues.put(CAR_CLN_MODEL,car.getModel());
//        contentValues.put(CAR_CLN_COLOR,car.getColor());
//        contentValues.put(CAR_CLN_BPL,car.getDpl());
//        String args[]={car.getId()+""};
//        long result =  db.update(CAR_TB_NAME,contentValues,"id=?",args );
//        return result > 0;
//
//
//    }
//    //ارجاع عدد الصفوف
//    public long getCarsCount(){
//        SQLiteDatabase db =getReadableDatabase();
//        return DatabaseUtils.queryNumEntries(db,CAR_TB_NAME);
//    }
//    //دالة الحذف
//    public boolean deleteCar (Car car){
//        SQLiteDatabase db = getWritableDatabase();
//
//        String args[]={car.getId()+""};
//        long result =  db.delete(CAR_TB_NAME,"id=?",args );
//        return result > 0;
//
//
////     طريقة اخرى للحذف
////        public boolean deleteCar (String x){
////            SQLiteDatabase db = getWritableDatabase();
////
////            String args[]={"%"+x+"%"}
////            long result =  db.delete(CAR_TB_NAME,"model LIKE ?",args );
////            return result > 0;
//
//
//
//        }
//        //دالة الارجاع
//    public ArrayList<Car> getALLCars(){
//        ArrayList<Car>cars = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM "+CAR_TB_NAME,null);
//        //كود التعامل مع cursor
//        //فحص هل ال cursor يحنوي بيانات
//        if (cursor != null && cursor.moveToFirst()){
//            do { int id = cursor.getInt(cursor.getColumnIndex(CAR_CLN_ID));
//                String model = cursor.getString(cursor.getColumnIndex(CAR_CLN_MODEL));
//                String color = cursor.getString(cursor.getColumnIndex(CAR_CLN_COLOR));
//                double dpl = cursor.getDouble(cursor.getColumnIndex(CAR_CLN_BPL));
//                Car c = new Car(id,model,color,dpl);
//                cars.add(c);
//            }while (cursor.moveToNext());
//            cursor.close();
//        }
//        return cars;
//    }
//    //دالة البحث
//    public ArrayList<Car> getCars(String modelSearch){
//        ArrayList<Car>cars = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM "+CAR_TB_NAME+" WHERE "+CAR_CLN_MODEL+" =? ",new String[]{modelSearch});
//        //كود التعامل مع cursor
//        //فحص هل ال cursor يحنوي بيانات
//        if (cursor != null && cursor.moveToFirst()){
//            do { int id = cursor.getInt(cursor.getColumnIndex(CAR_CLN_ID));
//                String model = cursor.getString(cursor.getColumnIndex(CAR_CLN_MODEL));
//                String color = cursor.getString(cursor.getColumnIndex(CAR_CLN_COLOR));
//                double dpl = cursor.getDouble(cursor.getColumnIndex(CAR_CLN_BPL));
//                Car c = new Car(id,model,color,dpl);
//                cars.add(c);
//            }while (cursor.moveToNext());
//            cursor.close();
//        }
//        return cars;
//    }
}}

