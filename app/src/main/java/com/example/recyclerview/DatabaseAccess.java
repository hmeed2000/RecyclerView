package com.example.recyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAccess {
    private  SQLiteDatabase database;
    private SQLiteOpenHelper openHelper;
    private static DatabaseAccess instance;
    private DatabaseAccess(Context context){
       this.openHelper= new MyDatabase(context);
    }
    public static DatabaseAccess getInstance(Context context){
        if (instance==null){
            instance = new DatabaseAccess(context);
        }return instance;
    }
    public void open(){
        this.database = this.openHelper.getWritableDatabase();
    }
    public void close(){
        if(this.database != null){
            this.database.close();
        }}


    //دالة الاضافة
    public boolean insertCar(Car car){
        //SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(MyDatabase.CAR_CLN_MODEL,car.getModel());
        contentValues.put(MyDatabase.CAR_CLN_COLOR, car.getColor());
        contentValues.put( MyDatabase.CAR_CLN_BPL, car.getDpl());
        contentValues.put(MyDatabase.CAR_CLN_DESCRIPTION, car.getDescription());
        contentValues.put(MyDatabase.CAR_CLN_IMAGE, car.getImage());
        long result =  database.insert(MyDatabase.CAR_TB_NAME, null,contentValues);
        return  result!= -1;

    }
    //دالة التعديل
    public boolean updateCar(Car car){
        // SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(MyDatabase.CAR_CLN_MODEL,car.getModel());
        contentValues.put(MyDatabase.CAR_CLN_COLOR, car.getColor());
        contentValues.put( MyDatabase.CAR_CLN_BPL, car.getDpl());
        contentValues.put(MyDatabase.CAR_CLN_DESCRIPTION, car.getDescription());
        contentValues.put(MyDatabase.CAR_CLN_IMAGE, car.getImage());
        String args[]={car.getId()+""};
        long result =  database.update(MyDatabase.CAR_TB_NAME, contentValues,"id=?",args );
        return result > 0;


    }
    //ارجاع عدد الصفوف
    public long getCarsCount(){
        // SQLiteDatabase db =getReadableDatabase();
        return DatabaseUtils.queryNumEntries(database,MyDatabase.CAR_TB_NAME);
    }
    //دالة الحذف
    public boolean deleteCar (Car car){
        //  SQLiteDatabase db = getWritableDatabase();

        String args[]={car.getId()+""};
        long result =  database.delete(MyDatabase.CAR_TB_NAME,"id=?",args );
        return result > 0;


//     طريقة اخرى للحذف
//        public boolean deleteCar (String x){
//            SQLiteDatabase db = getWritableDatabase();
//
//            String args[]={"%"+x+"%"}
//            long result =  db.delete(CAR_TB_NAME,"model LIKE ?",args );
//            return result > 0;



    }
    //دالة الارجاع
    public ArrayList<Car> getALLCars(){
        ArrayList<Car>cars = new ArrayList<>();
        // SQLiteDatabase db = getReadableDatabase();
        Cursor cursor =database.rawQuery("SELECT * FROM "+MyDatabase.CAR_TB_NAME,null);
        //كود التعامل مع cursor
        //فحص هل ال cursor يحنوي بيانات
        if (cursor != null && cursor.moveToFirst()){
            do { int id = cursor.getInt(cursor.getColumnIndex(MyDatabase.CAR_CLN_ID));
                String model = cursor.getString(cursor.getColumnIndex(MyDatabase.CAR_CLN_MODEL));
                String color = cursor.getString(cursor.getColumnIndex(MyDatabase.CAR_CLN_COLOR));
                double dpl = cursor.getDouble(cursor.getColumnIndex(MyDatabase.CAR_CLN_BPL));
                String image = cursor.getString(cursor.getColumnIndex(MyDatabase.CAR_CLN_IMAGE));
                String description = cursor.getString(cursor.getColumnIndex(MyDatabase.CAR_CLN_DESCRIPTION));


                Car c = new Car(id,model,color,dpl,image,description);
                cars.add(c);
            }while (cursor.moveToNext());
            cursor.close();
        }
        return cars;
    }
    //دالة البحث
    public ArrayList<Car> getCars(String modelSearch){
        ArrayList<Car>cars = new ArrayList<>();
        //  SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM "+(MyDatabase.CAR_TB_NAME+" WHERE "+(MyDatabase.CAR_CLN_MODEL+" =? ")),new String[]{modelSearch});
        //كود التعامل مع cursor
        //فحص هل ال cursor يحنوي بيانات
        if (cursor != null && cursor.moveToFirst()){
            do { int id = cursor.getInt(cursor.getColumnIndex(MyDatabase.CAR_CLN_ID));
                String model = cursor.getString(cursor.getColumnIndex(MyDatabase.CAR_CLN_MODEL));
                String color = cursor.getString(cursor.getColumnIndex(MyDatabase.CAR_CLN_COLOR));
                double dpl = cursor.getDouble(cursor.getColumnIndex(MyDatabase.CAR_CLN_BPL));
                String image = cursor.getString(cursor.getColumnIndex(MyDatabase.CAR_CLN_IMAGE));
                String description = cursor.getString(cursor.getColumnIndex(MyDatabase.CAR_CLN_DESCRIPTION));

                Car c = new Car(id,model,color,dpl,image,description);
                cars.add(c);
            }while (cursor.moveToNext());
            cursor.close();
        }
        return cars;
    }
}

