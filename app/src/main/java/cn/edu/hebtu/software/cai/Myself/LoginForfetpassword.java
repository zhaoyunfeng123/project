package cn.edu.hebtu.software.cai.Myself;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.hebtu.software.cai.R;

public class LoginForfetpassword extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myself_login_forgetpassword);
        ImageView imageView = findViewById(R.id.myself_forgetpassword_return);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginForfetpassword.this.finish();
            }
        });
        Button button = findViewById(R.id.myself_forgetpassword_preservation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginForfetpassword.this,"更新成功!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
