package com.example.getimage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.getimage.R;

public class GlideActivity extends Activity {

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

        Glide.with(GlideActivity.this)
                .load(IMG_URL)
                .into(imgShow);
    }
}
