package com.example.getimage.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.getimage.R;
import com.example.getimage.base.BaseActivity;
import com.example.getimage.data.Data;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VolleyActivity extends BaseActivity {

    private static final String TAG = VolleyActivity.class.getSimpleName();
    @BindView(R.id.img_show)
    ImageView mImgShow;
    @BindView(R.id.img_show2)
    ImageView mImgShow2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        RequestQueue mQueue = Volley.newRequestQueue(this.getApplicationContext());

        final ImageRequest imageRequest = new ImageRequest(
                Data.IMAGE_URL,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        mImgShow.setImageBitmap(bitmap);
                    }
                },
                0,
                0,
                Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        mImgShow.setImageResource(R.mipmap.circle_error);
                    }
                }
        );
        mQueue.add(imageRequest);

        ImageLoader imageLoader = new ImageLoader(mQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String s) {
                return null;
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {

            }
        });
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(mImgShow2,
                R.mipmap.loading, R.mipmap.circle_error);
        imageLoader.get(Data.IMAGE_URL2, listener);
    }
}
