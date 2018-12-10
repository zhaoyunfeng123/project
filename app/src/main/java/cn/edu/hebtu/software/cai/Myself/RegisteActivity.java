package cn.edu.hebtu.software.cai.Myself;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.hebtu.software.cai.DataBaseHelper;
import cn.edu.hebtu.software.cai.R;

public class RegisteActivity extends Activity {
    private EditText etUser;
    private EditText etAccount;
    private EditText etPassword;
    private SQLiteDatabase sqLiteDatabase;
    private DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);
        //注册返回按钮
        ImageView imageView = findViewById(R.id.myself_registe_return);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisteActivity.this.finish();
            }
        });
        TextView textView = findViewById(R.id.myself_registe_server);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisteActivity.this,"悄悄告诉你,这款APP不收费哦!",Toast.LENGTH_SHORT).show();
            }
        });
        dataBaseHelper = new DataBaseHelper(this,"cai.db",1);
        Button button = findViewById(R.id.btn_registe);
        etUser = findViewById(R.id.et_user);
        etAccount = findViewById(R.id.registe_account);
        etPassword = findViewById(R.id.registe_password);
        //
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUser.getText().toString();
                String account = etAccount.getText().toString();
                String password = etPassword.getText().toString();
                //判断该用户是否已被注册
                if(registCheck(username,account)){
                    Toast.makeText(RegisteActivity.this,
                            "该用户名或者账号已被注册",
                            Toast.LENGTH_SHORT).show();
                }else{
                    if(register(username,account,password)){
                        Toast.makeText(RegisteActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent();
                        intent3.setClass(RegisteActivity.this,MyselfOkActivity.class);
                        //使用Bundle对象添加数据
                        Bundle bundle = new Bundle();
                        bundle.putString("name",username);
                        intent3.putExtras(bundle);
                        //跳转
                        startActivity(intent3);

                    }
                }
            }
        });
    }
    //检验用户名、账号是否已存在
    public boolean registCheck(String name,String account){
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        String query = "select * from user where name=? and account=?";
        Cursor cursor = sqLiteDatabase.rawQuery(query,new String[]{name,account});
        //有问题，验证出问题！！！！！！！！
        if (cursor.getCount()>0){
            cursor.close();
            return  true;
        }
        cursor.close();
        return false;
    }
    //向数据库插入数据
    public boolean register(String name,String account,String password) {
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("account",account);
        contentValues.put("password",password);
        sqLiteDatabase.insert("user",null,contentValues);
        sqLiteDatabase.close();
        return true;

    }
}
