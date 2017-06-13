package com.future.mqq.utils;

import com.future.mqq.bean.BannerBeans;
import com.future.mqq.bean.ChoseBean;
import com.future.mqq.bean.FirstBean;
import com.future.mqq.bean.JingBean;
import com.future.mqq.bean.ListTryBean;
import com.future.mqq.bean.MyCourseBean;
import com.future.mqq.bean.MyTopicBean;
import com.future.mqq.bean.OrderBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by lenovo on 2017/5/23.
 * 这是提供请求方法的接口，返回的是被观察者对象
 */

public interface ApiServer {


    /**
     *FirstHand 首次握手
     * @param type app类型 为ANDROID
     * @param dev_id 设备标识
     * @param ver_code 版本号
     * @param tick 时间戳
     * @param sign 签名
     * @return
     */

    @POST(UrlConnect.FRIST_HAND)
    @FormUrlEncoded

    Flowable<FirstBean> firstHand(@Field("type")String type, @Field("dev_id")String dev_id,
                                        @Field("ver_code")int ver_code, @Field("tick")String tick,
                                        @Field("sign")String sign);


     @POST(UrlConnect.BESE_lISTBANNEN)
    @FormUrlEncoded
    Flowable<BannerBeans> getListBanner(@Field("app_id")String appId, @Field("dev_id")String dev_id,
                                        @Field("ver_code")int ver_code, @Field("tick")String tick,
                                        @Field("sign")String sign);

    //进行免费试听列表数据的解析
    @POST(UrlConnect.BASE_FREE)
    @FormUrlEncoded
    Flowable<ListTryBean> getListTry(@Field("app_id") String appId,@Field("dev_id")String dev_id,
                                     @Field("ver_code")int ver_code,@Field("tick")String tick,
                                     @Field("page_size")int page_size,@Field("page_index")int page_index,
                                     @Field("sign")String sign
                                    );

    //进行精品列表的数据解析
    @POST(UrlConnect.BASE_CHOOSE)
    @FormUrlEncoded
    Flowable<ChoseBean> getChoose(@Field("app_id") String appId, @Field("dev_id")String dev_id,
                                  @Field("ver_code")int ver_code, @Field("tick")String tick,
                                  @Field("page_size")int page_size, @Field("page_index")int page_index,
                                  @Field("sign")String sign
    );

    //进行专辑列表的数据解析
    @POST(UrlConnect.BASE_Top)
    @FormUrlEncoded
    Flowable<MyTopicBean> getTopic(@Field("app_id") String appId, @Field("dev_id")String dev_id,
                                    @Field("ver_code")int ver_code, @Field("tick")String tick,
                                    @Field("page_size")int page_size, @Field("page_index")int page_index,
                                    @Field("sign")String sign
    );


    //获取课程详情的数据
    @POST(UrlConnect.BASE_COURSE)
    @FormUrlEncoded
    Flowable<MyCourseBean> getCourse(@Field("app_id") String appId, @Field("dev_id")String dev_id,
                                     @Field("ver_code")int ver_code, @Field("tick")String tick,
                                     @Field("object_id")String object_id,
                                     @Field("sign")String sign
    );


    //获取专辑详情的数据
    @POST(UrlConnect.BASE_TopBase)
    @FormUrlEncoded
    Flowable<JingBean> getJing(@Field("app_id") String appId, @Field("dev_id")String dev_id,
                                 @Field("ver_code")int ver_code, @Field("tick")String tick,
                                 @Field("object_id")String object_id,
                                 @Field("sign")String sign
    );


    //进行第一次与后台交互
    @POST(UrlConnect.FIRST_EATCH)
    @FormUrlEncoded
    Flowable<OrderBean> getOrder(@Header("userid") String userid,@Header("cltid") String cltid,
                                 @Header("token") String token,@Header("mobile") String mobile,
                                 @Field("activity_id") int appId, @Field("time_id") int time_id,
                                 @Field("child_num") int child_num, @Field("contact") String contact,
                                 @Field("mobile") String mobiles, @Field("remark") int remark

                                 );

}
