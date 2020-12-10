package com.example.music.np;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MusicMenuActivity extends Activity {

    private SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_menu);
        //打开或创建数据库 参数一：数据库名 参数二：模式，私有模式 参数三：无
//        db = openOrCreateDatabase("work", Context.MODE_PRIVATE, null);
//        int version = db.getVersion();//获取数据库版本
//        if (version < 1) {
//            db.execSQL("create table " + "work_info" + "(" + "musicMenuID" + " text primary key," + "musicID" + " text)");
//            db.setVersion(1); //设置数据库版本号
//        }
//
//        //ListView相关功能
//        //查询数据库，显示
//        initview();
//        //按键相关功能
//        Button bt = new Button(this);
//        bt = findViewById(R.id.Bt);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                EditText edit1 = findViewById(R.id.Ed1);
//                EditText edit2 = findViewById(R.id.Ed2);
//                //获取用户输入的姓名和工作简历内容
//                String id = edit1.getText().toString();
//                String content = edit2.getText().toString();
//                if (!(id.equals("") || content.equals(""))) {
//                    //插入数据
//                    db.execSQL("insert into " + "work_info" + "(" + "姓名" + "," + "个人简介" + ") values(?,?)", new Object[]{id, content});
//                    Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_LONG).show();
//                    initview();
//                }
//            }
//        });
//    }
}

//    private void initview(){
//        ListView lv = new ListView(this);
//        lv = findViewById(R.id.Lv);
//        List<String> data = new ArrayList<String>();
//        try {
//            // 查询表中所有数据
//            Cursor cursor = db.query("work_info", null, null, null, null, null, null);
//            // 判断查询记录条数是否大于0
//            if (cursor.getCount() > 0) {
//                while (cursor.moveToNext()) {
//                    String record = "musicMenuID: " + cursor.getString(cursor.getColumnIndex("musicMenuID")) + "\n工作简历: "
//                            + cursor.getString(cursor.getColumnIndex("musicID"));
//                    data.add(record); //添加查询的记录
//                }
//            } else {
//                data.add("没有记录");
//            }
//        } catch (Exception e) {
//            Log.e("db-error", e.getMessage());
//        }
//        // 给ListView设置适配器,显示表中所有数据
//        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));
//    }
}
