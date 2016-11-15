package com.hukang.mydemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.hukang.mydemo.R;

public class TipViewActivity extends AppCompatActivity {

    private SVProgressHUD mSVProgressHUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_view);
        mSVProgressHUD = new SVProgressHUD(this);
        mSVProgressHUD.showWithStatus("加载中....");
    }
    public void show(View view){
        mSVProgressHUD.show();
    }
    public void showWithMaskType(View view){
        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.None);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.Black);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.BlackCancel);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.Clear);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.ClearCancel);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.Gradient);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.GradientCancel);
    }
    public void showWithStatus(View view){
        mSVProgressHUD.showWithStatus("加载中...");
    }
    public void showInfoWithStatus(View view){
        mSVProgressHUD.showInfoWithStatus("这是提示", SVProgressHUD.SVProgressHUDMaskType.None);
    }
    public void showSuccessWithStatus(View view){
        mSVProgressHUD.showSuccessWithStatus("恭喜，提交成功！");
    }
    public void showErrorWithStatus(View view){
        mSVProgressHUD.showErrorWithStatus("不约，叔叔我们不约～", SVProgressHUD.SVProgressHUDMaskType.GradientCancel);
    }
}
