package cn.edu.hebtu.software.cai.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.hebtu.software.cai.CustomDialog;
import cn.edu.hebtu.software.cai.Myself.LoginActivity;
import cn.edu.hebtu.software.cai.Myself.MyselfMoney;
import cn.edu.hebtu.software.cai.Myself.MyselfSetting;
import cn.edu.hebtu.software.cai.R;


public class Fragment5 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_myself,
                container,
                false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView imageView = getActivity().findViewById(R.id.img_touxiang);
        ImageView imageView1 = getActivity().findViewById(R.id.img_touxiangmoban);
        TextView textView = getActivity().findViewById(R.id.myself_login);
        LinearLayout linearLayout =getActivity().findViewById(R.id.myself_setting);
        LinearLayout linearLayout1 =getActivity().findViewById(R.id.myself_userfeedback);
        LinearLayout linearLayout2 = getActivity().findViewById(R.id.myself_money);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),LoginActivity .class);
                startActivity(intent);
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),LoginActivity .class);
                startActivity(intent);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),LoginActivity .class);
                startActivity(intent);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), MyselfSetting.class);
                startActivity(intent);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), MyselfMoney.class);
                startActivity(intent);
            }
        });
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        dialog();
                }
        });
    }
    private void dialog() {
        final CustomDialog dialog = new CustomDialog(getActivity(),"用户反馈","");//第二个参数是title,第三个参数是message
        dialog.setOnPositiveListener(new View.OnClickListener() {
            EditText editText = getActivity().findViewById(R.id.dialog_et);
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getActivity(), "反馈成功,谢谢您的支持" , Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setOnNegativeListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}