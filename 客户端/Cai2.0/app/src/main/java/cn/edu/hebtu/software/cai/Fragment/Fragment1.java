package cn.edu.hebtu.software.cai.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.HashMap;
import java.util.Map;

import cn.edu.hebtu.software.cai.Home.HomePaihangbang;
import cn.edu.hebtu.software.cai.HttpUtilsHttpURLConncetion;
import cn.edu.hebtu.software.cai.R;
import cn.edu.hebtu.software.cai.WebActivity;


public class Fragment1 extends Fragment{
    EditText etSearch;
    TextView btSearch;
    String Sname;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home,
                container,
                false);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayout linearLayout = getActivity().findViewById(R.id.home_paihangbang);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), HomePaihangbang.class);
                startActivity(intent);
            }
        });
        btSearch = getActivity().findViewById(R.id.home_btn_search);
        etSearch = getActivity().findViewById(R.id.home_et_search);
        getActivity().findViewById(R.id.home_btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sname = etSearch.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //服务器端项目名+包名类名
                        String service = "cai04/ServiceSearch";
                        String url = HttpUtilsHttpURLConncetion.BASE_URL + service;
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("search", Sname);
                        String result = HttpUtilsHttpURLConncetion.getContextByHttp(url, params);
                        Message msg = new Message();
                        msg.what = 0x12;
                        Bundle data = new Bundle();
                        data.putString("result", result);
                        msg.setData(data);
                        handler.sendMessage(msg);
                        Log.e("execute", "搜索1");
                    }
                    Handler handler = new Handler() {
                        public void handleMessage(Message msg) {
                            Log.e("execute", "搜索2");
                        }
                    };
                }).start();
                Intent intent2 = new Intent();
                intent2.putExtra("name", Sname);
                intent2.setClass(getActivity(), WebActivity.class);
                startActivity(intent2);
            }
        });
    }
}