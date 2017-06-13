package com.future.mqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.future.mqq.R;

/**
 * Created by lenovo on 2017/5/27.
 */
public class RegistActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText regist_phone;
    private EditText regist_num;
    private TextView regist_getnum;
    private EditText regist_password;
    private Button regist_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist_layout);
        initView();
    }

    private void initView() {
        regist_phone = (EditText) findViewById(R.id.regist_phone);
        regist_num = (EditText) findViewById(R.id.regist_num);
        regist_getnum = (TextView) findViewById(R.id.regist_getnum);
        regist_password = (EditText) findViewById(R.id.regist_password);
        regist_btn = (Button) findViewById(R.id.regist_btn);

        regist_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regist_btn:
                //点击注册的时候进行判断
                submit();


                break;
        }
    }

    private void submit() {
        // validate
        String phone = regist_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "+86", Toast.LENGTH_SHORT).show();
            return;
        }

        String num = regist_num.getText().toString().trim();
        if (TextUtils.isEmpty(num)) {
            Toast.makeText(this, "输入你收到的验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = regist_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "密码不少于6个字", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something

        //注册成功跳转到登陆的界面
        Intent intent = new Intent(RegistActivity.this, LogActivity.class);
        startActivity(intent);
        finish();

    }
}
