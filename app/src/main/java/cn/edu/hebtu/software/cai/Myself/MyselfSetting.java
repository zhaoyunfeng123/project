package cn.edu.hebtu.software.cai.Myself;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.cai.R;


public class MyselfSetting extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myself_setting);
        ImageView imageView = findViewById(R.id.myself_setting_return);
        LinearLayout linearLayout = findViewById(R.id.myself_setting_personaldata);
        LinearLayout linearLayout1 = findViewById(R.id.myself_setting_we);
        LinearLayout linearLayout2 = findViewById(R.id.myself_setting_help);
        LinearLayout linearLayout3 = findViewById(R.id.myself_setting_switchaccount);
        LinearLayout linearLayout4 = findViewById(R.id.myself_setting_break);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyselfSetting.this.finish();
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MyselfSetting.this,MyselfSettingPersonaldate .class);
                startActivity(intent);
            }
        });
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MyselfSetting.this,MyselfSettingWe .class);
                startActivity(intent);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyselfSetting.this, "帮助与反馈功能搬家了呢" , Toast.LENGTH_SHORT).show();
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyselfSetting.this, "暂时还没有该功能呢,期待我们的更新" , Toast.LENGTH_SHORT).show();
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adBuilder = new AlertDialog.Builder(MyselfSetting.this);
                adBuilder.setTitle("温馨提示");
                adBuilder.setMessage("您确定要退出当前登录吗?");
                adBuilder.setPositiveButton("确定退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MyselfSetting.this.finish();
                    }
                });
                adBuilder.setNegativeButton("取消",null);
                AlertDialog ad = adBuilder.create();
                ad.show();
            }
        });

    }
}