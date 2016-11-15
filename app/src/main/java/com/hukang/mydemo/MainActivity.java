package com.hukang.mydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hukang.mydemo.ui.AlertViewActivity;
import com.hukang.mydemo.ui.FlaotViewDemo1Activity;
import com.hukang.mydemo.ui.GifActivity;
import com.hukang.mydemo.ui.HeartLayoutActivity;
import com.hukang.mydemo.ui.IMActivity;
import com.hukang.mydemo.ui.LoginActivity;
import com.hukang.mydemo.ui.RadioGroupActivity;
import com.hukang.mydemo.ui.RxJavaActivity;
import com.hukang.mydemo.ui.TipViewActivity;
import com.hukang.mydemo.ui.UltraPullToRefreshActivity;
import com.hukang.mydemo.ui.VideoActivity;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView demoList;
    private List<String> list = new ArrayList<>();
    private List<Class> activityList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //注册失败会抛出HyphenateException
//                try {
//                    EMClient.getInstance().createAccount("heheyy", "h123456789");//同步方法
//                } catch (HyphenateException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });

        EMClient.getInstance().login("hukang","123456",new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        EMClient.getInstance().groupManager().loadAllGroups();
                        EMClient.getInstance().chatManager().loadAllConversations();
                        Log.d("main", "登陆聊天服务器成功！");
                    }
                });
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                Log.d("main", "登陆聊天服务器失败！");
            }
        });
        list.add("HeartLayout");
        list.add("CircleMenuLayout");
        list.add("Ultra Pull To Refresh");
        list.add("RxJava");
        list.add("TipView");
        list.add("AlertView");
        list.add("IM");
        list.add("FlaoView");
        list.add("Gif");
        list.add("Login");
        list.add("Danmu");
        activityList.add(HeartLayoutActivity.class);
        activityList.add(RadioGroupActivity.class);
        activityList.add(UltraPullToRefreshActivity.class);
        activityList.add(RxJavaActivity.class);
        activityList.add(TipViewActivity.class);
        activityList.add(AlertViewActivity.class);
        activityList.add(IMActivity.class);
        activityList.add(FlaotViewDemo1Activity.class);
        activityList.add(GifActivity.class);
        activityList.add(LoginActivity.class);
        activityList.add(VideoActivity.class);
        demoList = (ListView) findViewById(R.id.lv_demo);
        demoList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list));
        demoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,activityList.get(position));
                startActivity(intent);
            }
        });


    }
}
