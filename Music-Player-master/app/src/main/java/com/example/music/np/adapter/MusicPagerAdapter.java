package com.example.music.np.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created on 2017/12/18.
 * 提示：FragmentPagerAdapter extends PagerAdapter
 * 相关知识点：https://www.cnblogs.com/kexing/p/8400929.html
 * 布局管理器允许左右翻转带数据的页面，你想要显示的视图可以通过实现PagerAdapter来显示。
 */

public class MusicPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragmentList ;
    //通过构造获取list集合
    public MusicPagerAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);//得到FragmentManager fm
        this.fragmentList = fragmentList;
    }
    //返回fragmentList.get(position)
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
    //返回fragmentList.size()
    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
