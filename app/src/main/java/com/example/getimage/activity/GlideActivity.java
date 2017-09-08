package com.example.getimage.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.getimage.R;
import com.example.getimage.base.BaseActivity;
import com.example.getimage.glide.GlideApp;

public class GlideActivity extends BaseActivity {

    private static final String TAG = GlideActivity.class.getSimpleName();

    public static final String IMG_URL = "http://i.imgur.com/CqmBjo5.jpg";

    private ImageView imgShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        initViews();
    }

    private void initViews() {
        imgShow = (ImageView) findViewById(R.id.img_show);

        GlideApp.with(GlideActivity.this)
                .load(IMG_URL)
                .into(imgShow);
    }
}
