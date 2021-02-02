package com.zh.demo.ui.test;

import android.util.TypedValue;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.zh.demo.R;
import com.zh.demo.common.MyActivity;
import com.zh.demo.http.glide.GlideApp;

/**
 * ———— author : 郑皓
 * ———— time : 2021/01/28   Thursday
 * ———— desc :
 */
public class TestImgActivity extends MyActivity {

    private AppCompatImageView mIvImage;
    private String url = "https://www.baidu.com/img/bd_logo.png";

    @Override
    protected int getLayoutId() {
        return R.layout.test_img_activity;
    }

    @Override
    protected void initView() {

        setOnClickListener(R.id.btn_message_image1, R.id.btn_message_image2, R.id.btn_message_image3);
        mIvImage = findViewById(R.id.iv_image);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_message_image1:
                mIvImage.setVisibility(View.VISIBLE);
                GlideApp.with(this)
                        .load(url)
                        .into(mIvImage);
                break;
            case R.id.btn_message_image2:
                mIvImage.setVisibility(View.VISIBLE);
                GlideApp.with(this)
                        .load(url)
                        .circleCrop()
                        .into(mIvImage);
                break;
            case R.id.btn_message_image3:
                mIvImage.setVisibility(View.VISIBLE);
                GlideApp.with(this)
                        .load(url)
                        .transform(new RoundedCorners((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, this.getResources().getDisplayMetrics())))
                        .into(mIvImage);
                break;
            default:
                break;
        }
    }
}
