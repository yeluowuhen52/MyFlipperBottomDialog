package com.marsjiang.myflipperbottomdialog;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.marsjiang.myflipperbottomdialog.bottomsheet.BottomSheetFragment;

public class MainActivity extends FragmentActivity {
    private Button btn_comment;
    private LinearLayout ll_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_comment = (Button) findViewById(R.id.btn_comment);
        ll_bottom = (LinearLayout) findViewById(R.id.ll_bottom);
        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetFragment bottomSheetFragment = BottomSheetFragment.getInstance(MainActivity.this,ll_bottom);
                bottomSheetFragment.show(getSupportFragmentManager(), BottomSheetFragment.class.getSimpleName());
            }
        });
    }
}
