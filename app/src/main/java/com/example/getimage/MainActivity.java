package com.example.getimage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.getimage.activity.GlideActivity;
import com.example.getimage.activity.PicassoActivity;
import com.example.getimage.activity.UILActivity;
import com.example.getimage.activity.VolleyActivity;
import com.example.getimage.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_glide)
    Button mBtnGlide;
    @BindView(R.id.btn_picasso)
    Button mBtnPicasso;
    @BindView(R.id.btn_volley)
    Button mBtnVolley;
    @BindView(R.id.btn_uil)
    Button mBtnUil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void startActivity(Class<?> cls) {
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
    }

    @OnClick({R.id.btn_glide, R.id.btn_picasso, R.id.btn_volley, R.id.btn_uil})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_glide:
                startActivity(GlideActivity.class);
                break;
            case R.id.btn_picasso:
                startActivity(PicassoActivity.class);
                break;
            case R.id.btn_volley:
                startActivity(VolleyActivity.class);
                break;
            case R.id.btn_uil:
                startActivity(UILActivity.class);
                break;
        }
    }
}
