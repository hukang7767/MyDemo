package com.hukang.mydemo.app;

import android.app.Application;
import android.view.WindowManager;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

import cn.jpush.android.api.JPushInterface;


/**
 * Created by Administrator on 2016/5/4.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        EMOptions options = new EMOptions();
// 默认添加好友时，是不需要验证的，改成需要验证
//        options.setAcceptInvitationAlways(false);
//初始化
        EMClient.getInstance().init(getApplicationContext(), options);
//在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);
    }
    private WindowManager.LayoutParams wmlp = new WindowManager.LayoutParams();

    public WindowManager.LayoutParams getLayoutParams() {
        return wmlp;
    }
}
