package com.example.getimage.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.getimage.R;
import com.example.getimage.base.BaseActivity;
import com.example.getimage.data.Data;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UILActivity extends BaseActivity {

    private static final String TAG = UILActivity.class.getSimpleName();
    @BindView(R.id.img_show)
    ImageView mImgShow;
    @BindView(R.id.img_show2)
    ImageView mImgShow2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uil);
        ButterKnife.bind(this);

        initViews();
    }

    private void initViews() {

        ImageLoader.getInstance().loadImage(Data.IMAGE_URL, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String s, View view) {
                mImgShow.setImageResource(R.mipmap.loading);
            }

            @Override
            public void onLoadingFailed(String s, View view, FailReason failReason) {
                mImgShow.setImageResource(R.mipmap.circle_error);
            }

            @Override
            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                mImgShow.setImageBitmap(bitmap);
            }

            @Override
            public void onLoadingCancelled(String s, View view) {

            }
        });

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.loading)
                .showImageForEmptyUri(R.mipmap.ic_empty)
                .showImageOnFail(R.mipmap.circle_error)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        ImageLoader.getInstance().displayImage(Data.IMAGE_URL2,
                mImgShow2, options);


    }


}
