package cn.edu.hebtu.software.cai.Myself;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.hebtu.software.cai.R;
import cn.edu.hebtu.software.cai.birthday.ChooseDateInterface;
import cn.edu.hebtu.software.cai.birthday.ChooseDateUtil;

public class MyselfSettingPersonaldate extends Activity {
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myself_setting_personaldata);
        //头部返回按钮
        ImageView imageView = findViewById(R.id.myself_setting_personaldata_return);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyselfSettingPersonaldate.this.finish();
            }
        });
        tvDate = findViewById(R.id.tvDate);
    }
    //        Choose Date 选择日期
    public void chooseDateDialog(View view) {
        final ChooseDateUtil dateUtil = new ChooseDateUtil();
        String[] oldDateArray = tvDate.getText().toString().split("-");
        dateUtil.createDialog(this, oldDateArray, new ChooseDateInterface() {
            @Override
            public void sure(int[] newDateArray) {
                tvDate.setText(newDateArray[0] + "-" + newDateArray[1] + "-" + newDateArray[2]);
            }
        });
    }
}