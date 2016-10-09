package com.example.getimage.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.getimage.R;
import com.example.getimage.data.Data;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class UILActivity extends Activity {

	private static final String TAG = UILActivity.class.getSimpleName();



	private ImageView imgShow;
	private ImageView imgShow2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uil);

		initViews();
	}

	private void initViews() {
		imgShow = (ImageView) findViewById(R.id.img_show);
		imgShow2 = (ImageView) findViewById(R.id.img_show2);

		ImageLoader.getInstance().loadImage(Data.IMAGE_URL, new ImageLoadingListener() {
			@Override
			public void onLoadingStarted(String s, View view) {
				imgShow.setImageResource(R.mipmap.loading);
			}

			@Override
			public void onLoadingFailed(String s, View view, FailReason failReason) {
				imgShow.setImageResource(R.mipmap.circle_error);
			}

			@Override
			public void onLoadingComplete(String s, View view, Bitmap bitmap) {
				imgShow.setImageBitmap(bitmap);
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

		ImageLoader.getInstance().displayImage(Data.IMAGE_URL2, imgShow2, options);



	}



}
