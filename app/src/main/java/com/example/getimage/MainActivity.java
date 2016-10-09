package com.example.getimage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.getimage.activity.GlideActivity;
import com.example.getimage.activity.PicassoActivity;
import com.example.getimage.activity.UILActivity;
import com.example.getimage.activity.VolleyActivity;

public class MainActivity extends Activity {

    private Button btnGlide;
    private Button btnPicasso;
    private Button btnVolley;
    private Button btnUIL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnGlide = (Button) findViewById(R.id.btn_glide);
        btnPicasso = (Button) findViewById(R.id.btn_picasso);
        btnVolley = (Button) findViewById(R.id.btn_volley);
        btnUIL = (Button) findViewById(R.id.btn_uil);

        btnGlide.setOnClickListener(btnClickListener);
        btnPicasso.setOnClickListener(btnClickListener);
        btnVolley.setOnClickListener(btnClickListener);
        btnUIL.setOnClickListener(btnClickListener);
    }

    private View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
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
                default :
                    break;
            }

        }
    };

    private void startActivity(Class<?> cls) {
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
    }
}
