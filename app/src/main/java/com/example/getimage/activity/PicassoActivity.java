package com.example.getimage.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.getimage.R;
import com.example.getimage.base.BaseActivity;
import com.example.getimage.data.Data;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PicassoActivity extends BaseActivity {

    @BindView(R.id.img_show)
    ImageView mImgShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {

        Picasso.with(PicassoActivity.this)
                .load(Data.IMAGE_URL_2)
                .into(mImgShow);
    }
}
