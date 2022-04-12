package com.neusoft.commondialog.dialog;

import static com.neusoft.commondialog.dialog.DialogConstants.DIALOG_TAG;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : YangHaoYi on 2022/1/28.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2022/1/28.
 * Version : V 1.0
 */
public class CommonDialogManager {

    private List<CommonDialog> list = new ArrayList<>();

    public static class InstanceHolder{
        private static final CommonDialogManager INSTANCE = new CommonDialogManager();
    }

    public static CommonDialogManager getInstance(){
        return InstanceHolder.INSTANCE;
    }

    public void addDialog(CommonDialog dialog){
        list.add(dialog);
    }

    public void removeDialog(CommonDialog dialog){
        list.remove(dialog);
    }

    public CommonDialog getCurrentDialog() {
        for (int i = 0; i < list.size(); i++) {
            Log.e(DIALOG_TAG, "list dialog is : " + list.get(i).getDialogParams().getTitle());
        }
        return list.get(list.size() - 1);
    }


    public @DialogConstants.DialogLevel int getCurrentDialogLevel(){
        if (list.size() > 0) {
            return list.get(list.size() - 1).getDialogParams().getDialogLevel();
        }else {
            return DialogConstants.DialogLevel.IDLE;
        }
    }
}
