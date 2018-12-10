package cn.edu.hebtu.software.cai.Myself;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.hebtu.software.cai.DataBaseHelper;
import cn.edu.hebtu.software.cai.R;

public class LoginActivity extends Activity{
    private SQLiteDatabase sqLiteDatabase;
    private DataBaseHelper dataBaseHelper;
    private EditText etUser;
    private EditText etUserName;
    private EditText etPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //绑定注册TextView
        TextView textView = findViewById(R.id.login_registe);
        //登录返回按钮
        ImageView imageView = findViewById(R.id.myself_login_return);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });
        //单击TextView事件
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,RegisteActivity .class);
                startActivity(intent);
            }
        });
        TextView textView1 = findViewById(R.id.myself_login_forgetpassword);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,LoginForfetpassword .class);
                startActivity(intent);
            }
        });
        TextView textView2 = findViewById(R.id.myself_login_server);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"悄悄告诉你,这款APP不收费哦!",Toast.LENGTH_SHORT).show();
            }
        });
        dataBaseHelper = new DataBaseHelper(this,"cai.db",1);
        etUserName = findViewById(R.id.login_username);
        etPassword = findViewById(R.id.login_password);
        final String username = etUserName.getText().toString();
        final String password = etPassword.getText().toString();
        //绑定登录按钮
        Button button = findViewById(R.id.login_login);
        //单击登录按钮事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断账号、密码是否正确
                if(login(username,password)){
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent();
                    intent2.setClass(LoginActivity.this,MyselfOkActivity.class);
                    String user = getuser(username);
                    if(user != null){
                        Bundle bundle = new Bundle();
                        bundle.putString("name",user);
                        intent2.putExtras(bundle);
                    }
                    startActivity(intent2);
                }else{
                    Toast.makeText(LoginActivity.this,"账号或密码失败，请重新登录",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    //登录验证
    public boolean login(String username,String password){
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        String sql = "select * from user where name=? and password=?";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,new String[] {username,password});
        if(cursor.moveToFirst()){
            cursor.close();
            return true;
        }
        return false;
    }
    //获取用户名
    public String getuser(String username){
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        String name;
        Cursor cursor = sqLiteDatabase.query("user",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                name=cursor.getString(cursor.getColumnIndex("name"));
                break;
            }while (cursor.moveToNext());
            return name;
        }
        return null;
    }
}