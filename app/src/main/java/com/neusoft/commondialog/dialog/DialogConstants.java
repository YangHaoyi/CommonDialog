package com.neusoft.commondialog.dialog;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author : YangHaoYi on 2022/1/28.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2022/1/28.
 * Version : V 1.0
 */
public class DialogConstants {

    public static final String DIALOG_TAG = "CommonDialog";

    @IntDef({DialogLevel.IDLE, DialogLevel.SYSTEM, DialogLevel.USER_CONFIRM, DialogLevel.USER_SELECT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DialogLevel {
        /** 系统推送 **/
        int SYSTEM = 3;
        /** 用户确认 **/
        int USER_CONFIRM = 2;
        /** 用户选择 **/
        int USER_SELECT = 1;
        /** 无状态 **/
        int IDLE = 0;
    }

}
