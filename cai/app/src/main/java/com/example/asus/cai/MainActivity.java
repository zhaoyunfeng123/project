package com.example.asus.cai;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import com.example.asus.cai.Fragment.FirstFragment;
public class MainActivity extends AppCompatActivity {

        private Map<String,View> tabspecViews=new HashMap<>();
        private Map<String,ImageView> imageViewMap=new HashMap<>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            FragmentTabHost fragmentTabHost = findViewById(android.R.id.tabhost);
            //初始化FragmentTabHost对象
            fragmentTabHost.setup(this,
                    getSupportFragmentManager(),
                    android.R.id.tabhost);
            TabHost.TabSpec tabSpec1 = fragmentTabHost.newTabSpec("tab1")
                    .setIndicator("首页")
                    .setIndicator(getTabSpecView("首页", R.drawable.tabhosthome, "tab1"));
            TabHost.TabSpec tabSpec2 = fragmentTabHost.newTabSpec("tab2")
                    .setIndicator("分类")
                    .setIndicator(getTabSpecView("分类", R.drawable.tabhostlist, "tab2"));
            TabHost.TabSpec tabSpec3 = fragmentTabHost.newTabSpec("tab3")
                    .setIndicator("")
                    .setIndicator(getTabSpecView("", R.drawable.tabhostadd, "tab3"));
            TabHost.TabSpec tabSpec4 = fragmentTabHost.newTabSpec("tab4")
                    .setIndicator("社区")
                    .setIndicator(getTabSpecView("社区", R.drawable.tabhostcommunity, "tab4"));
            TabHost.TabSpec tabSpec5 = fragmentTabHost.newTabSpec("tab5")
                    .setIndicator("我的")
                    .setIndicator(getTabSpecView("首页", R.drawable.tabhostmain, "tab5"));
            //绑定选项卡和页面
            fragmentTabHost.addTab(tabSpec1, FirstFragment.class, null);
            fragmentTabHost.addTab(tabSpec2, FirstFragment.class, null);
            fragmentTabHost.addTab(tabSpec3, FirstFragment.class, null);
            fragmentTabHost.addTab(tabSpec4, FirstFragment.class, null);
            fragmentTabHost.addTab(tabSpec5, FirstFragment.class, null);
        }
    private View getTabSpecView(String name, int imageId, String tag){
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.tabspc_layout,null);
        ImageView imageView = view.findViewById(R.id.image);
        imageView.setImageResource(imageId);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(name);
        tabspecViews.put(tag, view);
        imageViewMap.put(tag, imageView);
        return view;
    }
}
