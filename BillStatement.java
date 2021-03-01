package com.nenecorp.majiapp.Interface.MajiUi;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nenecorp.majiapp.R;
import com.nenecorp.majiapp.Utility.Resources.Animations;
import com.nenecorp.majiapp.Utility.Resources.DataChannel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class BillStatement extends AppCompatActivity {
    View layoutBill, layoutHome;
    Animations animations;
    TextView btnviewbill;

    @Override
    public void onBackPressed() {
        boolean b = layoutBill.getVisibility() == View.VISIBLE;
        if (b) {
            layoutHome.setVisibility(View.VISIBLE);
            layoutHome.startAnimation(animations.fadeIn);
            layoutBill.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billn_statement);

        btnviewbill=(TextView)findViewById(R.id.ABnS_btnViewBill);
        layoutBill = findViewById(R.id.ABnS_layoutViewBill);
        layoutHome = findViewById(R.id.ABnS_layoutWelcome);
        animations = new Animations(this);
        
        findViewById(R.id.ABnS_btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.ABnS_btnStatement).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                DataChannel.home.bottomNavigationView.setCurrentItem(2);
            }
        });
        findViewById(R.id.ABnS_btnViewBill).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutHome.setVisibility(View.GONE);
                layoutBill.startAnimation(animations.fadeIn);
                layoutBill.setVisibility(View.VISIBLE);
            }
        });
    }
}
