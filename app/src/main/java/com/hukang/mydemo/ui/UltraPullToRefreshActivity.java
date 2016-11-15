package com.hukang.mydemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hukang.mydemo.R;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import in.srain.cube.views.ptr.util.PtrLocalDisplay;

public class UltraPullToRefreshActivity extends AppCompatActivity {
    private PtrClassicFrameLayout mPtrFrame;
    private String mTitlePre = "哈哈";
    final String[] mStringList = {"BEADWALLET", "TMALL 11-11"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultra_pull_to_refresh);

        final PtrFrameLayout frame = (PtrFrameLayout) findViewById(R.id.store_house_ptr_frame);
        final StoreHouseHeader header = new StoreHouseHeader(this);
        header.setPadding(0, PtrLocalDisplay.dp2px(15), 0, 0);
//        header.initWithStringArray(R.array.storehouse);
        header.initWithString(mStringList[0]);
        header.setTextColor(getResources().getColor(R.color.colorPrimary));
//        setHeaderTitle(mTitlePre + mStringList[0]);
        frame.addPtrUIHandler(new PtrUIHandler() {

            private int mLoadTime = 0;

            @Override
            public void onUIReset(PtrFrameLayout frame) {
                mLoadTime++;
                String string = mStringList[mLoadTime % mStringList.length];
                header.initWithString(string);
            }

            @Override
            public void onUIRefreshPrepare(PtrFrameLayout frame) {
                String string = mStringList[mLoadTime % mStringList.length];
//                setHeaderTitle(mTitlePre + string);
//                header.initWithStringArray(R.array.storehouse);
                header.initWithString(string);
            }

            @Override
            public void onUIRefreshBegin(PtrFrameLayout frame) {
            }
            @Override
            public void onUIRefreshComplete(PtrFrameLayout frame) {
            }

            @Override
            public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {

            }
        });

        frame.setDurationToCloseHeader(3000);
        frame.setHeaderView(header);
        frame.addPtrUIHandler(header);
    }
}
