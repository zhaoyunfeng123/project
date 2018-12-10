package cn.edu.hebtu.software.cai.Myself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.hebtu.software.cai.R;

public class MyselfOkActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myselfok);
        //获取Intent对象中携带的数据
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String user = bundle.getString("name");
        TextView textView = findViewById(R.id.myselfok_user);
        textView.setText(user);
        ImageView imageView = findViewById(R.id.myselfok_return);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyselfOkActivity.this.finish();
            }
        });
    }
}
