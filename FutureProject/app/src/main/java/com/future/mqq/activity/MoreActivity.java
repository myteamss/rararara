package com.future.mqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.future.mqq.R;
import com.future.mqq.bean.JingBean;
import com.future.mqq.bean.MyCourseBean;
import com.future.mqq.bean.OrderBean;
import com.future.mqq.present.CoursePresent;
import com.future.mqq.view.CourseView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by lenovo on 2017/5/26.
 */
public class MoreActivity extends AppCompatActivity implements CourseView{

    private LinearLayout linear_more;
    private JCVideoPlayerStandard jc_more;
    private ImageView im_more;
    private ImageView im_person;
    private TextView name_more;
    private TextView course_more;
    private RelativeLayout relate_more;
    private TextView textView;
    private String object_id;
    private CoursePresent present;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_activity);
        Intent intent = getIntent();
        object_id = intent.getStringExtra("object_id");

        //拿到P对象
        present = new CoursePresent(this, MoreActivity.this, object_id);
        present.getDatas();
        initView();

    }

    private void initView() {
        linear_more = (LinearLayout) findViewById(R.id.linear_more);
        jc_more = (JCVideoPlayerStandard) findViewById(R.id.jc_more);
        im_more = (ImageView) findViewById(R.id.im_more);
        im_person = (ImageView) findViewById(R.id.im_person);
        name_more = (TextView) findViewById(R.id.name_more);
        course_more = (TextView) findViewById(R.id.course_more);
        relate_more = (RelativeLayout) findViewById(R.id.relate_more);
        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.buy_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到立即购买的界面，就是提交订单
                //这里调用
               present.getOrderDatas();

            }
        });
        //设置数据
    }

    @Override
    public void showCourse(MyCourseBean bean) {
        //拿到数据
        String video = bean.getData().getCourse_video();
        Log.i("xxxv",video);
       // jc_more.videoController.setUp("视频/MP3地址","视频/MP3标题");
       // videoController.ivThumb.setThumbInCustomProject("视频/MP3缩略图地址");
        boolean up = jc_more.setUp(video,JCVideoPlayer.SCREEN_LAYOUT_NORMAL, "");
        if(up){
            jc_more.thumbImageView.setImageResource(R.drawable.course_video);
        }

    }

    @Override
    public void showTop(JingBean bean) {

    }

    @Override
    public void showOrder(OrderBean orderBean) {
        //拿到预支付订单的信息
        if(orderBean!=null){
            orderBean.getData().getOrder_sn();
            Log.i("order", orderBean.getData().getOrder_sn());

        }

    }


}
