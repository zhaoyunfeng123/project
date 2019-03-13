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

public class RegisteActivity extends Activity {
    public SharedPreferences sharedPreferences;
    ImageView imageView;
    TextView textView;
    Button button;
    private EditText etUser;
    private EditText etAccount;
    private EditText etPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);
        //注册返回按钮
        imageView = findViewById(R.id.myself_registe_return);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisteActivity.this.finish();
            }
        });
        textView = findViewById(R.id.myself_registe_server);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisteActivity.this,"悄悄告诉你,这款APP不收费哦!",Toast.LENGTH_SHORT).show();
            }
        });
        button = findViewById(R.id.btn_registe);
        etUser = findViewById(R.id.et_user);
        etAccount = findViewById(R.id.registe_account);
        etPassword = findViewById(R.id.registe_password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUser.getText().toString();
                String account = etAccount.getText().toString();
                String password = etPassword.getText().toString();
                //判断该用户是否符合注册项规范
                if(username.length() <3 ){
                    Toast.makeText(RegisteActivity.this,"用户名小于2个字符，请重新输入",Toast.LENGTH_LONG).show();
                }else if(account.length() < 6 ){
                    Toast.makeText(RegisteActivity.this,"账号小于6位，请重新输入",Toast.LENGTH_LONG).show();
                }else if(password.length() < 6){
                    Toast.makeText(RegisteActivity.this,"密码小于6位，请重新输入",Toast.LENGTH_LONG).show();
                }else{
                    //注册
                    regist();
                }
            }
        });
    }
    //注册
    public void regist(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //服务器端项目名+包名类名
                String service = "cai04/ServiceSignUp";
                String url= HttpUtilsHttpURLConncetion.BASE_URL + service;
                Map<String,String> params =new HashMap<String,String>();
                String name=etUser.getText().toString();
                Log.e("name",name);
                String password=etPassword.getText().toString();
                String account=etAccount.getText().toString();
                params.put("account",account);
                params.put("name",name);
                params.put("password",password);
                String result=HttpUtilsHttpURLConncetion.getContextByHttp(url,params);

                Message msg=new Message();
                msg.what=0x12;
                Bundle data=new Bundle();
                data.putString("result",result);
                msg.setData(data);
                handler.sendMessage(msg);
                Log.e("execute","注册1");
            }
            Handler handler=new Handler(){
                public void handleMessage(Message msg){
                    Log.e("execute","注册2");
                    if (msg.what==0x12){
                        Bundle data=msg.getData();
                        String key=data.getString("result");
                        Log.e("execute","注册3");
                        try{
                            JSONObject jsonObject=new JSONObject(key);
                            String result=(String)jsonObject.get("result");
                            Log.e("execute","注册4");
                            if("success".equals(result)){
                                Log.e("execute","注册5");
                                Log.e("execute","注册6");
                                Toast.makeText(RegisteActivity.this,"注册成功",Toast.LENGTH_LONG).show();
                                turnTo();
                            }else if("error".equals(result)){
                                Toast.makeText(RegisteActivity.this,"该账号已被注册，请重新输入", Toast.LENGTH_LONG).show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }
            };
        }).start();
    }
    //跳转页面，注册成功
    public void turnTo(){
        //获取用户名
        String user = etUser.getText().toString();
        String account=etAccount.getText().toString();
        String sex = "man";
        String employment = "我的职业";
        String userEmail="我的邮箱";
        String userMessage="既然要吃，就要吃胖！Ψ(￣∀￣)Ψ";
        String problem = "我的密保问题";
        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("loginstate",1);
        editor.putString("userEmail",userEmail);
        editor.putString("userMessage",userMessage);
        editor.putString("userName",user);
        editor.putString("account",account);
        editor.putString("userEmployment",employment);
        editor.putString("userSex",sex);
        editor.putString("problem",problem);
        editor.commit();
        Intent intent2 = new Intent();
        intent2.setClass(RegisteActivity.this,MainActivity.class);
        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent2);
    }
}
