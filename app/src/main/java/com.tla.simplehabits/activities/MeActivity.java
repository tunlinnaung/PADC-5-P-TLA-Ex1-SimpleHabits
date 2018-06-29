package com.tla.simplehabits.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.tla.simplehabits.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeActivity extends BaseActivity {

    @BindView(R.id.tv_progress_title)
    TextView tvProgressTitle;

    public static Intent newIntent(Context context) {
        return new Intent(context, MeActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        ButterKnife.bind(this);
    }

}
