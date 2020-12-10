package com.example.music.np;


import android.app.TimePickerDialog;
import android.content.DialogInterface;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.example.music.np.adapter.MusicPagerAdapter;
import com.example.music.np.fragment.LogicFragment;
import com.example.music.np.fragment.OnlineFragment;
import com.master.permissionhelper.PermissionHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//实现OnClickListener的接口
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //关于权限
    private PermissionHelper permissionHelper;
    //定义activity_main.xml的控件对象
    private TextView logicTv;
    private TextView onlineTv;
    private ViewPager viewPager;
    private ImageView menuImagv;
    private ImageView seachImagv;
    private Calendar calendar;
    //drawer_layout有关的控件
    private DrawerLayout mDrawerLayout = null;
    private ListView mDrawerList;
    private List<String> mPlanetTitles;
    //将Fragment放入List集合中，存放fragment对象
    private List<Fragment> fragmentList = new ArrayList<>();
    //记录点击抽屉效果按钮的次数
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定id
        FindViewID();
        //设置监听
        listen();
        //抽屉效果对象
        mDrawerLayout = findViewById(R.id.drawer_layout);
        //抽屉界面的数据初始化
        initListView();
        //创建fragment对象
        LogicFragment logicFragment = new LogicFragment();
        OnlineFragment onlineFragment = new OnlineFragment();
        //将fragment对象添加到fragmentList中
        fragmentList.add(logicFragment);
        fragmentList.add(onlineFragment);
        //通过MusicPagerAdapter类的构造获取List<Fragment>集合；相关知识点 https://www.jianshu.com/p/c033ced92df7
        MusicPagerAdapter musicPagerAdapter = new MusicPagerAdapter(getSupportFragmentManager(), fragmentList);
        //viewPager绑定适配器
        viewPager.setAdapter(musicPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        logicTv.setTextColor(getResources().getColor(R.color.white));//高亮白字体
                        onlineTv.setTextColor(getResources().getColor(R.color.white_60P));//低亮白字体
                        break;
                    case 1:
                        onlineTv.setTextColor(getResources().getColor(R.color.white));
                        logicTv.setTextColor(getResources().getColor(R.color.white_60P));
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void listen() {
        logicTv.setOnClickListener(this);
        onlineTv.setOnClickListener(this);
        menuImagv.setOnClickListener(this);
        seachImagv.setOnClickListener(this);
    }

    private void FindViewID() {
        logicTv = findViewById(R.id.main_logic_tv);
        onlineTv = findViewById(R.id.main_online_tv);
        viewPager = findViewById(R.id.main_vp);
        menuImagv = findViewById(R.id.main_menu_imgv);
        seachImagv = findViewById(R.id.main_search_imgv);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_logic_tv:
                //实现点击TextView切换fragment
                viewPager.setCurrentItem(0);
                break;
            case R.id.main_online_tv:
                viewPager.setCurrentItem(1);
                break;
            case R.id.main_menu_imgv:
                i++;
                if(i==1)
                    // 按钮第一次按下，将抽屉打开
                    mDrawerLayout.openDrawer(Gravity.LEFT);
                else {
                    mDrawerLayout.closeDrawer(Gravity.LEFT); i=0;}
                break;
            case R.id.main_search_imgv:

                break;
            default:
                break;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME) {
            final View view = LayoutInflater.from(this).inflate(R.layout.dialog2_layout, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("退出提示");
            builder.setView(view);
            builder.setPositiveButton("帅", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("不帅", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "东马必须帅！！！", Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initListView() {
        mDrawerList = findViewById(R.id.left_drawer);
        List<String> mPlanetTitles = new ArrayList<String>();

        mPlanetTitles.add("我的歌单");
        mPlanetTitles.add("音乐闹铃");
        mPlanetTitles.add("均衡器");
        mPlanetTitles.add("主题");
        mPlanetTitles.add("设置");
        mPlanetTitles.add("关于软件");
        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
               android.R.layout.simple_expandable_list_item_1, mPlanetTitles));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                switch(position)
                {
                    case 0:
                        Intent intent = new Intent(getApplicationContext(),MusicMenuActivity.class);
                        startActivity(intent);
                    break;
                    case 1:  calendar = Calendar.getInstance();
                        int hour = calendar.get(Calendar.HOUR);
                        int minute = calendar.get(Calendar.MINUTE);
                        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Toast.makeText(MainActivity.this, "所选择的时间是：" + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();

                            }
                        }, hour, minute, true);
                        timePickerDialog.show(); break;
                    case 2: Toast.makeText(getApplicationContext(),"功能开发中", Toast.LENGTH_SHORT).show(); break;
                    case 3: Toast.makeText(getApplicationContext(),"功能开发中", Toast.LENGTH_SHORT).show(); break;
                    case 4: Toast.makeText(getApplicationContext(),"功能开发中", Toast.LENGTH_SHORT).show(); break;
                    case 5: Toast.makeText(getApplicationContext(),"功能开发中", Toast.LENGTH_SHORT).show(); break;
                }
            }
        });
    }
}
