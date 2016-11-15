package com.hukang.mydemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hukang.mydemo.R;

public class ZxingcodeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxingcode);
    }
    public void scan(View view){
//        startActivityForResult(new Intent(this, CaptureActivity.class), this.RESULT_OK);
    }
}
