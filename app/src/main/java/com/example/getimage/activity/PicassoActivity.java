package com.example.getimage.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.getimage.R;
import com.example.getimage.base.BaseActivity;
import com.squareup.picasso.Picasso;

public class PicassoActivity extends BaseActivity {

    public static final String IMG_URL = "http://i.imgur.com/zkaAooq.jpg ";

    private ImageView imgShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        initViews();
    }

    private void initViews() {
        imgShow = (ImageView) findViewById(R.id.img_show);

        Picasso.with(PicassoActivity.this)
                .load(IMG_URL)
                .into(imgShow);
    }
}
