package com.future.mqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.future.mqq.R;

/**
 * Created by lenovo on 2017/5/27.
 */
public class LogActivity extends AppCompatActivity implements View.OnClickListener {

    public static boolean log = false;

    private EditText login_account;
    private EditText login_password;
    private TextView forgetpassword;
    private Button login;
    private Button regist;
    private ImageView iv1;
    private TextView tv1;
    private RelativeLayout wechat;
    private ImageView iv2;
    private TextView tv2;
    private RelativeLayout qq;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();


    }

    private void initView() {

        login_account = (EditText) findViewById(R.id.login_account);
        login_password = (EditText) findViewById(R.id.login_password);
        forgetpassword = (TextView) findViewById(R.id.forgetpassword);
        login = (Button) findViewById(R.id.login);
        regist = (Button) findViewById(R.id.regist);
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv1 = (TextView) findViewById(R.id.tv1);
        wechat = (RelativeLayout) findViewById(R.id.wechat);
        iv2 = (ImageView) findViewById(R.id.iv2);
        tv2 = (TextView) findViewById(R.id.tv2);
        qq = (RelativeLayout) findViewById(R.id.qq);

        login.setOnClickListener(this);
        regist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                submit();
                break;
            case R.id.regist:
                //跳转到注册的界面
                Intent in=new Intent(LogActivity.this,RegistActivity.class);
                startActivity(in);
                break;
        }
    }

    private void submit() {
        // validate
        String account = login_account.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this, "+86", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = login_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "密码不少于6个字", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
       //登陆成功之后，进行记录登陆的状态
        log=true;
        //并且跳转到我的界面
        Intent in=new Intent(LogActivity.this,MainActivity.class);
        in.putExtra("num",3);
        startActivity(in);
        finish();

    }
}
