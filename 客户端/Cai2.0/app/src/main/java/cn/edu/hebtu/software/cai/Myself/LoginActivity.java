package cn.edu.hebtu.software.cai.Myself;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.edu.hebtu.software.cai.HttpUtilsHttpURLConncetion;
import cn.edu.hebtu.software.cai.MainActivity;
import cn.edu.hebtu.software.cai.R;

public class LoginActivity extends Activity{
    TextView textView,textView1,textView2;
    ImageView imageView;
    Button button;
    SharedPreferences sharedPreferences;
    private EditText etUserAccount;
    private EditText etPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //绑定注册TextView
        textView = findViewById(R.id.login_registe);
        //登录返回按钮
        imageView = findViewById(R.id.myself_login_return);
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
        textView1 = findViewById(R.id.myself_login_forgetpassword);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,ForgetPassword .class);
                startActivity(intent);
            }
        });
        textView2 = findViewById(R.id.myself_login_server);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"悄悄告诉你,这款APP不收费哦!",Toast.LENGTH_SHORT).show();
            }
        });
        etUserAccount = findViewById(R.id.login_account);
        etPassword = findViewById(R.id.login_password);

        //绑定登录按钮
        button = findViewById(R.id.login_login);
        //单击登录按钮事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断账号、密码是否正确
                //调用登录方法
                login();
            }
        });
    }
    //登录验证
    public void login() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //服务器端项目名+包名类名
                String service = "cai04/ServiceSignIn";
                String url = HttpUtilsHttpURLConncetion.BASE_URL + service;
                Map<String, String> params = new HashMap<String, String>();
                String account = etUserAccount.getText().toString();
                String password = etPassword.getText().toString();
                params.put("account", account);
                params.put("password", password);
                String result = HttpUtilsHttpURLConncetion.getContextByHttp(url, params);
                Message msg = new Message();
                msg.what = 0x12;
                Bundle data = new Bundle();
                data.putString("result", result);
                msg.setData(data);
                handler.sendMessage(msg);
                Log.e("execute", "登录1");
            }
            Handler handler = new Handler() {
                public void handleMessage(Message msg) {
                    Log.e("execute", "登录2");
                    if (msg.what == 0x12) {
                        Bundle data = msg.getData();
                        String key = data.getString("result");
                        Log.e("execute", "登录3");
                        try {
                            JSONObject jsonObject = new JSONObject(key);
                            String name = (String) jsonObject.get("name");
                            String sex=(String)jsonObject.get("sex");
                            String employment=(String)jsonObject.get("employment");
                            String email=(String)jsonObject.get("email");
                            String messages=(String)jsonObject.get("messages");
                            String problem = (String)jsonObject.get("problem");
                            Log.e("execute", "登录4");
                            if ("error".equals(name)) {
                                Toast.makeText(LoginActivity.this,"账号或密码错误，请重新登录或注册",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                                turnTo(name,email,messages,sex,employment,problem);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
        }).start();
    }
    //跳转页面，登陆成功时
    public void turnTo(String userName ,String userEmail,String userMessage,String sex,String employment,String problem){
        //保存用户名和密码
        String account = etUserAccount.getText().toString();
        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("loginstate",1);
        editor.putString("userName",userName);
        editor.putString("userMessage",userMessage);
        editor.putString("userEmail",userEmail);
        editor.putString("account",account);
        editor.putString("userEmployment",employment);
        editor.putString("userSex",sex);
        editor.putString("problem",problem);
        editor.commit();
        Intent intent2 = new Intent();
        intent2.setClass(LoginActivity.this,MainActivity.class);
        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent2);
    }
}