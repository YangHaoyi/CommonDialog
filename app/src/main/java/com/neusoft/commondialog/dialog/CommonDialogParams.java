package com.neusoft.commondialog.dialog;

import android.content.Context;
import android.view.Gravity;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author : YangHaoYi on 2021/11/24.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2021/11/24.
 * Version : V 1.0
 */
public class CommonDialogParams {
    /** 上下文 **/
    private Context context;
    /** 提示窗级别 **/
    private @DialogConstants.DialogLevel int dialogLevel;
    /** 提示窗位置 **/
    private @DialogLocation int dialogLocation;
    /** 背景透明 **/
    private boolean transparentBackground;
    /** 标题 **/
    private String title;
    /** 标题字体大小 **/
    private int titleSizeSp;
    /** 图标资源 **/
    private int imageResource;
    /** 图标宽 **/
    private int imageWidth;
    /** 图标高 **/
    private int imageHeight;
    /** 消息内容 **/
    private String message;
    /** 消息内容文字位置 **/
    private int messageGravity = Gravity.NO_GRAVITY;
    /** 点击外部是否可以取消 **/
    private boolean canCancel = false;
    /** 左边按钮内容 **/
    private String leftButtonText;
    /** 左边按钮内容 **/
    private int leftBtColor;
    /** 左边点击事件 **/
    private CommonDialogBuilder.ButtonClickLister leftListener;
    /** 右边按钮内容 **/
    private String rightButtonText;
    /** 右边边按钮颜色 **/
    private int rightBtColor;
    /** 右边按钮点击事件 **/
    private CommonDialogBuilder.ButtonClickLister rightListener;

    /** 居中 **/
    public static final int CENTER = 0;
    /** 底部 **/
    public static final int BOTTOM = 1;

    @IntDef({CENTER, BOTTOM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DialogLocation {}

    public int getDialogLevel() {
        return dialogLevel;
    }

    public void setDialogLevel(int dialogLevel) {
        this.dialogLevel = dialogLevel;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getDialogLocation() {
        return dialogLocation;
    }

    public void setDialogLocation(@DialogLocation int dialogLocation) {
        this.dialogLocation = dialogLocation;
    }

    public boolean isTransparentBackground() {
        return transparentBackground;
    }

    public void setTransparentBackground(boolean transparentBackground) {
        this.transparentBackground = transparentBackground;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTitleSizeSp() {
        return titleSizeSp;
    }

    public void setTitleSizeSp(int titleSizeSp) {
        this.titleSizeSp = titleSizeSp;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message1) {
        this.message = message1;
    }

    public int getMessageGravity() {
        return messageGravity;
    }

    public void setMessageGravity(int message1Gravity) {
        this.messageGravity = message1Gravity;
    }

    public boolean isCanCancel() {
        return canCancel;
    }

    public void setCanCancel(boolean canCancel) {
        this.canCancel = canCancel;
    }

    public String getLeftButtonText() {
        return leftButtonText;
    }

    public void setLeftButtonText(String leftButtonText) {
        this.leftButtonText = leftButtonText;
    }

    public int getLeftBtColor() {
        return leftBtColor;
    }

    public void setLeftBtColor(int leftBtColor) {
        this.leftBtColor = leftBtColor;
    }

    public CommonDialogBuilder.ButtonClickLister getLeftListener() {
        return leftListener;
    }

    public void setLeftListener(CommonDialogBuilder.ButtonClickLister leftListener) {
        this.leftListener = leftListener;
    }

    public String getRightButtonText() {
        return rightButtonText;
    }

    public void setRightButtonText(String rightButtonText) {
        this.rightButtonText = rightButtonText;
    }

    public int getRightBtColor() {
        return rightBtColor;
    }

    public void setRightBtColor(int rightBtColor) {
        this.rightBtColor = rightBtColor;
    }

    public CommonDialogBuilder.ButtonClickLister getRightListener() {
        return rightListener;
    }

    public void setRightListener(CommonDialogBuilder.ButtonClickLister rightListener) {
        this.rightListener = rightListener;
    }
}
