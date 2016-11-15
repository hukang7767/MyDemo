package com.hukang.mydemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hukang.mydemo.R;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import java.util.ArrayList;
import java.util.List;

public class IMActivity extends AppCompatActivity {
    private List<String> list = new ArrayList<>();
    private ListView listView ;
    private ArrayAdapter<String> adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im);
        listView = (ListView) findViewById(R.id.lv_demo);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
//        try {
//            EMClient.getInstance().contactManager().addContact("kanghu", "测试");
//        } catch (HyphenateException e) {
//            e.printStackTrace();
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    List<String> usernames = EMClient.getInstance().contactManager().getAllContactsFromServer();
                    list.addAll(usernames);
//                    adapter.notifyDataSetChanged();
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
