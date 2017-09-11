package com.example.getimage.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.getimage.R;
import com.example.getimage.base.BaseActivity;
import com.example.getimage.data.Data;
import com.example.getimage.glide.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlideActivity extends BaseActivity {

    private static final String TAG = GlideActivity.class.getSimpleName();

    @BindView(R.id.img_show)
    ImageView mImgShow;

    private ImageView imgShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {

        GlideApp.with(GlideActivity.this)
                .load(Data.IMAGE_URL)
                .into(mImgShow);
    }

}
