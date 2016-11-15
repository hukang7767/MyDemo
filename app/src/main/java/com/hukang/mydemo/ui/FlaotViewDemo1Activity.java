package com.hukang.mydemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;

import com.hukang.mydemo.R;
import com.hukang.mydemo.app.App;
import com.hukang.mydemo.widget.FloatView;

public class FlaotViewDemo1Activity extends Activity {
    /** Called when the activity is first created. */
    private WindowManager wm;
    private WindowManager.LayoutParams wmlp;
    private FloatView fl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flaot_view_demo1);
        createFloatView();
    }

    private void createFloatView() {
        fl = new FloatView(getApplicationContext());
        fl.setImageResource(R.mipmap.ic_launcher);
        wm = (WindowManager) getApplicationContext().getSystemService(
                WINDOW_SERVICE);
        wmlp = ((App) getApplication()).getLayoutParams();

        wmlp.type = 2002;
        wmlp.format = 1;
        wmlp.flags |= 8;
        wmlp.gravity = Gravity.LEFT | Gravity.TOP; // let the float view to the right top

        wmlp.x = 0;
        wmlp.y = 0;

        wmlp.width = 100;
        wmlp.height = 150;

        wm.addView(fl, wmlp);// add the view

    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        wm.removeView(fl);
    }

}
