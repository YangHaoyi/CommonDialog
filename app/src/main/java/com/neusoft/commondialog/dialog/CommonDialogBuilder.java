package com.neusoft.commondialog.dialog;

import static com.neusoft.commondialog.dialog.DialogConstants.DIALOG_TAG;

import android.content.Context;
import android.util.Log;

/**
 * @author : YangHaoYi on 2021/11/24.
 * Email  :  yanghaoyi@neusoft.com
 * Description :提示窗构造器
 * Change : YangHaoYi on 2021/11/24.
 * Version : V 1.0
 */
public class CommonDialogBuilder {

    /** 提示窗参数 **/
    private CommonDialogParams dialogParams;
    private CommonDialog commonDialog;

    /** 构造函数 **/
    public CommonDialogBuilder(Context context) {
        dialogParams = new CommonDialogParams();
        dialogParams.setContext(context);
    }

    /**
     * 设置提示窗是否背景透明
     * @param transparentBackground 是否背景透明
     *  **/
    public CommonDialogBuilder transparentBackground(boolean transparentBackground){
        dialogParams.setTransparentBackground(transparentBackground);
        return this;
    }

    /**
     * 设置提示窗位置
     * @param location 提示窗位置
     *  **/
    public CommonDialogBuilder location(@CommonDialogParams.DialogLocation int location){
        dialogParams.setDialogLocation(location);
        return this;
    }

    /**
     * 设置显示级别
     * @param level 显示级别
     *  **/
    public CommonDialogBuilder level(@DialogConstants.DialogLevel int level){
        dialogParams.setDialogLevel(level);
        return this;
    }

    /**
     * 设置标题
     * @param title 标题信息
     *  **/
    public CommonDialogBuilder title(String title){
        dialogParams.setTitle(title);
        return this;
    }

    /**
     * 设置提示信息
     * @param message 提示信息
     *  **/
    public CommonDialogBuilder message(String message){
        dialogParams.setMessage(message);
        return this;
    }

    /**
     * 设置提示信息
     * @param gravity 提示信息是否居中（单条显示的Message需要居中处理）
     *  **/
    public CommonDialogBuilder messageGravity(int gravity){
        dialogParams.setMessageGravity(gravity);
        return this;
    }

    /**
     * 设置左按钮
     * @param leftButtonText 按钮文字
     * @param buttonClickLister 按钮点击事件
     *  **/
    public CommonDialogBuilder leftButton(String leftButtonText, ButtonClickLister buttonClickLister){
        dialogParams.setLeftButtonText(leftButtonText);
        dialogParams.setLeftListener(buttonClickLister);
        return this;
    }

    /**
     * 设置右按钮
     * @param rightButtonText 按钮文字
     * @param buttonClickLister 按钮点击事件
     *  **/
    public CommonDialogBuilder rightButton(String rightButtonText, ButtonClickLister buttonClickLister){
        dialogParams.setRightButtonText(rightButtonText);
        dialogParams.setRightListener(buttonClickLister);
        return this;
    }

    /**
     * 设置是否可以点击背景关闭
     * @param canCancel 是否可以点击背景关闭
     *  **/
    public CommonDialogBuilder canCancel(boolean canCancel){
        dialogParams.setCanCancel(canCancel);
        return this;
    }

    /** 构造提示窗 **/
    public CommonDialogBuilder build(){
//        CommonDialog dialog;
//        if(CommonDialogManager.getInstance().getCurrentDialogLevel()==dialogParams.getDialogLevel()){
//            dialog = CommonDialogManager.getInstance().getCurrentDialog();
//            dialog.updateData(dialogParams);
//        } else if (CommonDialogManager.getInstance().getCurrentDialogLevel() >dialogParams.getDialogLevel()) {
//            return new CommonDialog(dialogParams);
//        }else {
//            dialog = null;
//        }
//        return dialog;
//        CommonDialog dialog;
//        @DialogConstants.DialogLevel int currentShowLevel = CommonDialogManager.getInstance().getCurrentDialogLevel();
//        Log.e(DIALOG_TAG, "currentShowLevel is : " + currentShowLevel);
//        @DialogConstants.DialogLevel int newLevel = dialogParams.getDialogLevel();
//        Log.e(DIALOG_TAG, "newLevel is : " + newLevel);
//        if (currentShowLevel == newLevel) {
//            Log.e(DIALOG_TAG, "currentShowLevel == newLevel : get Current from Manager");
//            dialog = CommonDialogManager.getInstance().getCurrentDialog();
//        } else if (currentShowLevel < newLevel) {
//            Log.e(DIALOG_TAG, "currentShowLevel < newLevel : create new");
//            dialog = new CommonDialog(dialogParams);
//            CommonDialogManager.getInstance().addDialog(dialog);
//        } else {
//            Log.e(DIALOG_TAG, "currentShowLevel > newLevel : do not show");
//            dialog = null;
//        }
//        commonDialog = dialog;
        return this;
    }

    private CommonDialog getDialog(){
        CommonDialog dialog;
        @DialogConstants.DialogLevel int currentShowLevel = CommonDialogManager.getInstance().getCurrentDialogLevel();
        Log.e(DIALOG_TAG, "currentShowLevel is : " + currentShowLevel);
        @DialogConstants.DialogLevel int newLevel = dialogParams.getDialogLevel();
        Log.e(DIALOG_TAG, "newLevel is : " + newLevel);
        if (currentShowLevel == newLevel) {
            Log.e(DIALOG_TAG, "currentShowLevel == newLevel : get Current from Manager");
            dialog = CommonDialogManager.getInstance().getCurrentDialog();
        } else if (currentShowLevel < newLevel) {
            Log.e(DIALOG_TAG, "currentShowLevel < newLevel : create new");
            dialog = new CommonDialog(dialogParams);
        } else {
            Log.e(DIALOG_TAG, "currentShowLevel > newLevel : do not show");
            dialog = null;
        }
        commonDialog = dialog;
        return dialog;
    }

    public void show(){
        CommonDialog dialog = getDialog();
        if (null != dialog) {
            dialog.updateData(dialogParams);
            CommonDialogManager.getInstance().addDialog(dialog);
            dialog.show();
        }
    }

    public void dismissDialog(){
//        CommonDialogManager.getInstance().removeDialog(commonDialog);
//        commonDialog.dismiss();
    }

    /** 按钮点击回调 **/
    public interface ButtonClickLister {
        /**
         * 按钮点击事件
         * @param dialog 点击提示窗
         *  **/
        void onClick(CommonDialog dialog);
    }

}
