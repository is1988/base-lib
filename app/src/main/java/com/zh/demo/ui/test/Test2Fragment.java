package com.zh.demo.ui.test;

import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.zh.base.BaseDialog;
import com.zh.demo.R;
import com.zh.demo.aop.SingleClick;
import com.zh.demo.common.MyFragment;
import com.zh.demo.http.glide.GlideApp;
import com.zh.demo.ui.dialog.MessageDialog;
import com.zh.demo.ui.dialog.WaitDialog;

/**
 * ———— author : 郑皓
 * ———— time : 2021/01/26   Tuesday
 * ———— desc :
 */
public class Test2Fragment extends MyFragment<TestHomeActivity> {
    private ImageView mImageView;

    @Override
    protected int getLayoutId() {
        return R.layout.test2_fragment;
    }

    @Override
    protected void initView() {
        mImageView = findViewById(R.id.iv_message_image);
        setOnClickListener(R.id.btn_message_image1, R.id.btn_message_image2, R.id.btn_message_image3,
                R.id.btn_dialog_wait, R.id.btn_dialog_message, R.id.btn_dialog_toast);
    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }

    @SingleClick
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_message_image1:
                mImageView.setVisibility(View.VISIBLE);
                GlideApp.with(this)
                        .load("https://www.baidu.com/img/bd_logo.png")
                        .into(mImageView);
                break;
            case R.id.btn_message_image2:
                mImageView.setVisibility(View.VISIBLE);
                GlideApp.with(this)
                        .load("https://www.baidu.com/img/bd_logo.png")
                        .circleCrop()
                        .into(mImageView);
                break;
            case R.id.btn_message_image3:
                mImageView.setVisibility(View.VISIBLE);
                GlideApp.with(this)
                        .load("https://www.baidu.com/img/bd_logo.png")
                        .transform(new RoundedCorners((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, this.getResources().getDisplayMetrics())))
                        .into(mImageView);
                break;
            case R.id.btn_dialog_wait:
                // 等待对话框
                final BaseDialog waitDialog = new WaitDialog.Builder(getAttachActivity())
                        // 消息文本可以不用填写
                        .setMessage(getString(R.string.common_loading_3s))
                        .show();
                postDelayed(waitDialog::dismiss, 3000);
                break;
            case R.id.btn_dialog_toast:
                toast("这是提示toast");
                break;
            case R.id.btn_dialog_message:
                // 消息对话框
                new MessageDialog.Builder(getAttachActivity())
                        // 标题可以不用填写
                        .setTitle("我是标题")
                        // 内容必须要填写
                        .setMessage("我是内容")
                        // 确定按钮文本
                        .setConfirm(getString(R.string.common_confirm))
                        // 设置 null 表示不显示取消按钮
                        .setCancel(getString(R.string.common_cancel))
                        // 设置点击按钮后不关闭对话框
                        .setAutoDismiss(false)
                        .setListener(new MessageDialog.OnListener() {

                            @Override
                            public void onConfirm(BaseDialog dialog) {
//                                toast("确定了");
                            }

                            @Override
                            public void onCancel(BaseDialog dialog) {
//                                toast("取消了");
                            }
                        })
                        .show();
                break;
//            case R.id.btn_message_toast:
//                toast("我是吐司");
//                break;
//            case R.id.btn_message_permission:
//                XXPermissions.with(getAttachActivity())
//                        // 可设置被拒绝后继续申请，直到用户授权或者永久拒绝
//                        //.constantRequest()
//                        // 支持请求6.0悬浮窗权限8.0请求安装权限
//                        //.permission(Permission.SYSTEM_ALERT_WINDOW, Permission.REQUEST_INSTALL_PACKAGES)
//                        // 不指定权限则自动获取清单中的危险权限
//                        .permission(Permission.CAMERA)
//                        .request(new OnPermission() {
//
//                            @Override
//                            public void hasPermission(List<String> granted, boolean isAll) {
//                                if (isAll) {
//                                    toast("获取权限成功");
//                                } else {
//                                    toast("获取权限成功，部分权限未正常授予");
//                                }
//                            }
//
//                            @Override
//                            public void noPermission(List<String> denied, boolean quick) {
//                                if(quick) {
//                                    toast("被永久拒绝授权，请手动授予权限");
//                                    //如果是被永久拒绝就跳转到应用权限系统设置页面
//                                    XXPermissions.startPermissionActivity(getAttachActivity());
//                                } else {
//                                    toast("获取权限失败");
//                                }
//                            }
//                        });
//                break;
//            case R.id.btn_message_setting:
//                XXPermissions.startPermissionActivity(getAttachActivity());
//                break;
//            case R.id.btn_message_black:
//                if (getAttachActivity().getStatusBarConfig() != null) {
//                    getAttachActivity().getStatusBarConfig().statusBarDarkFont(true).init();
//                }
//                break;
//            case R.id.btn_message_white:
//                if (getAttachActivity().getStatusBarConfig() != null) {
//                    getAttachActivity().getStatusBarConfig().statusBarDarkFont(false).init();
//                }
//                break;
            default:
                break;
        }
    }
}
