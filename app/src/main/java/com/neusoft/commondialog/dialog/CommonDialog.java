package com.neusoft.commondialog.dialog;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.neusoft.commondialog.R;

/**
 * @author : YangHaoYi on 2021/11/24.
 * Email  :  yanghaoyi@neusoft.com
 * Description :通用提示窗
 * Change : YangHaoYi on 2021/11/24.
 * Version : V 1.0
 *
 * 提示框dialog，用于显示以下几种可选样式dialog
 * 标题（可选）
 * 标题下第一条显示内容（可选）
 * 标题下第二条显示内容（可选）
 * 左下角按钮，没有右下角按钮时居中显示，入参监听为空时，默认点击执行退出dialog操作
 * 右下角按钮（可选）
 *    _______________________________________________________
 *   丨                     Title                            丨
 *   丨----------------------------------------------------- 丨
 *   丨                                                      丨
 *   丨                     MessageOne                       丨
 *   丨                     MessageTwo                       丨
 *   丨                                                      丨
 *   丨         ___________               ___________        丨
 *    --------丨leftBtnOne丨------------丨rightBtnTwo丨---------
 *            丨_________丨            丨_________   丨
 *
 */
public class CommonDialog extends Dialog {

    /** 提示窗背景 **/
    private FrameLayout fmContent;
    /** 提示窗标题 **/
    private TextView tvTitle;
    /** 提示窗信息 **/
    private TextView tvMessage;
    /** 左侧按钮 **/
    private TextView tvLeftButton;
    /** 右侧按钮 **/
    private TextView tvRightButton;
    /** 提示窗配置参数 **/
    private CommonDialogParams dialogParams;

    /**
     * 构造函数
     * @param dialogParams 建造者参数
     *  **/
    public CommonDialog(CommonDialogParams dialogParams) {
        super(dialogParams.getContext(), R.style.CustomDialog);
        this.dialogParams = dialogParams;
        this.setContentView(R.layout.dialog_common);
        init();
    }

    /** 初始化 **/
    private void init(){
        initView();
        initWindow();
        initData();
        initEvent();
    }

    /** 初始化视图 **/
    private void initView(){
        fmContent = findViewById(R.id.fmContent);
        tvTitle = findViewById(R.id.tvTitle);
        tvMessage = findViewById(R.id.tvMessage);
        tvLeftButton = findViewById(R.id.tvLeftButton);
        tvRightButton = findViewById(R.id.tvRightButton);
        tvTitle.setVisibility(View.GONE);
        tvMessage.setVisibility(View.GONE);
        tvLeftButton.setVisibility(View.GONE);
        tvRightButton.setVisibility(View.GONE);
    }

    /** 初始化Window以解决高度不能正常显示问题 **/
    private void initWindow(){
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams lp = window.getAttributes();
            window.setGravity(Gravity.CENTER);
            window.setAttributes(lp);
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;;
            lp.height = WindowManager.LayoutParams.MATCH_PARENT;;
            window.setBackgroundDrawableResource(android.R.color.transparent);
            if(dialogParams.isTransparentBackground()){
                window.setDimAmount(0f);
            }
        }
    }

    /** 初始化数据 **/
    private void initData(){
        setCanceledOnTouchOutside(dialogParams.isCanCancel());
        setTitle(dialogParams.getTitle());
        setMessage(dialogParams.getMessage(),dialogParams.getMessageGravity());
        setLeftButton(dialogParams.getLeftButtonText(),dialogParams.getLeftListener());
        setRightButton(dialogParams.getRightButtonText(),dialogParams.getRightListener());
    }

    /** 初始化事件 **/
    private void initEvent(){
        fmContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dialogParams.isCanCancel()){
                    dismiss();
                }
            }
        });
    }

    /**
     * 更新数据
     * @param dialogParams 提示窗配置参数
     *  **/
    public void updateData(CommonDialogParams dialogParams){
        this.dialogParams = dialogParams;
        initWindow();
        initData();
        initEvent();
    }

    /**
     * 设置标题
     * @param title 标题信息
     *  **/
    private void setTitle(String title){
        if (TextUtils.isEmpty(title)) {
            return;
        }
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(title);
    }

    /**
     * 设置提示信息
     * @param message 提示信息
     * @param gravity 提示信息是否居中（单条显示的Message需要居中处理）
     *  **/
    private void setMessage(String message,int gravity){
        if (TextUtils.isEmpty(message)) {
            return;
        }
        tvMessage.setGravity(gravity);
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText(message);
    }

    /**
     * 设置左按钮
     * @param leftButtonText 按钮文字
     * @param buttonClickLister 按钮点击事件
     *  **/
    private void setLeftButton(String leftButtonText,CommonDialogBuilder.ButtonClickLister buttonClickLister){
        if (TextUtils.isEmpty(leftButtonText)) {
            return;
        }
        tvLeftButton.setVisibility(View.VISIBLE);
        tvLeftButton.setText(leftButtonText);
        tvLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null!=buttonClickLister){
                    buttonClickLister.onClick(CommonDialog.this);
                }
            }
        });
    }

    /**
     * 设置右按钮
     * @param rightButtonText 按钮文字
     * @param buttonClickLister 按钮点击事件
     *  **/
    private void setRightButton(String rightButtonText,CommonDialogBuilder.ButtonClickLister buttonClickLister){
        if (TextUtils.isEmpty(rightButtonText)) {
            return;
        }
        tvRightButton.setVisibility(View.VISIBLE);
        tvRightButton.setText(rightButtonText);
        tvRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null!=buttonClickLister){
                    buttonClickLister.onClick(CommonDialog.this);
                }
            }
        });
    }

    @Override
    public void dismiss() {
        CommonDialogManager.getInstance().removeDialog(this);
        super.dismiss();
    }

    /**
     * 获取提示窗参数
     * @return 提示窗参数
     *  **/
    public CommonDialogParams getDialogParams() {
        return dialogParams;
    }
}
