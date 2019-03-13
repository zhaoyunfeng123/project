package cn.edu.hebtu.software.cai.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.edu.hebtu.software.cai.HttpUtilsHttpURLConncetion;
import cn.edu.hebtu.software.cai.MainActivity;
import cn.edu.hebtu.software.cai.Myself.ChangePassword;
import cn.edu.hebtu.software.cai.Myself.LoginActivity;
import cn.edu.hebtu.software.cai.Myself.MyPrivateDish;
import cn.edu.hebtu.software.cai.Myself.MyselfSetting;
import cn.edu.hebtu.software.cai.R;


public class Fragment3 extends Fragment{
    Button button;
    SharedPreferences sharedPreferences;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_addmenu,
                container,
                false);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button = getActivity().findViewById(R.id.addmenu1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getActivity().getSharedPreferences("login",Context.MODE_PRIVATE);
                int loginstate=sharedPreferences.getInt("loginstate",0);
                if(loginstate==1){
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), MyPrivateDish.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getActivity(), "请先登录" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
