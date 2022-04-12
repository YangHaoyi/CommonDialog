package com.neusoft.commondialog;

import static com.neusoft.commondialog.dialog.DialogConstants.DIALOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;

import com.neusoft.commondialog.dialog.CommonDialog;
import com.neusoft.commondialog.dialog.CommonDialogBuilder;
import com.neusoft.commondialog.dialog.DialogConstants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
//        testShowLevel2_Level1_Level3();
        showByBuilder();
    }


    private void showByBuilder(){
        builder1.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                builder1.show();
            }
        },2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                builder3.show();
            }
        },5000);
    }

    private void testShowLevel1_Level2_Level3(){
        showLevel1();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showLevel2();
            }
        },2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showLevel3();
            }
        },5000);
    }

    private void testShowLevel1_Level1_Level2(){
        showLevel1();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showLevel1_2();
            }
        },2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showLevel2();
            }
        },5000);
    }

    private void testShowLevel2_Level1_Level3(){
        showLevel2();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showLevel1();
            }
        },2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showLevel3();
            }
        },5000);
    }


    private void showLevel1(){
        new CommonDialogBuilder(this)
                .title("Level 1 Dialog")
                .leftButton("Confirm", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve1 Confirm");
                        dialog.dismiss();
                    }
                })
                .rightButton("Cancel", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve1 Cancel");
                        dialog.dismiss();
                    }
                })
                .level(DialogConstants.DialogLevel.USER_SELECT)
                .build()
                .show();
    }

    private void showLevel1_2(){
        new CommonDialogBuilder(this)
                .title("Level 1 111111111111 Dialog")
                .leftButton("Confirm", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve1 Confirm");
                        dialog.dismiss();
                    }
                })
                .rightButton("Cancel", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve1 Cancel");
                        dialog.dismiss();
                    }
                })
                .level(DialogConstants.DialogLevel.USER_SELECT)
                .build()
                .show();
    }

    private void showLevel2(){
        new CommonDialogBuilder(this)
                .title("Level 2 Dialog")
                .leftButton("confirm", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve2 Confirm");
                        dialog.dismiss();
                    }
                })
                .rightButton("cancel", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve2 Cancel");
                        dialog.dismiss();
                    }
                })
                .level(DialogConstants.DialogLevel.USER_CONFIRM)
                .build()
                .show();
    }

    private void showLevel3(){
        new CommonDialogBuilder(this)
                .title("Level 3 Dialog")
                .leftButton("confirm", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve3 Confirm");
                        dialog.dismiss();
                    }
                })
                .rightButton("cancel", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve3 Cancel");
                        dialog.dismiss();
                    }
                })
                .level(DialogConstants.DialogLevel.SYSTEM)
                .build()
                .show();
    }


    private CommonDialogBuilder builder1;
    private CommonDialogBuilder builder2;
    private CommonDialogBuilder builder3;

    private void init(){
        builder1 = new CommonDialogBuilder(this)
                .title("Level 1 Dialog")
                .leftButton("Confirm", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve1 Confirm");
                        dialog.dismiss();
                    }
                })
                .rightButton("Cancel", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve1 Cancel");
                        dialog.dismiss();
                    }
                })
                .level(DialogConstants.DialogLevel.USER_SELECT)
                .build();
        builder2 = new CommonDialogBuilder(this)
                .title("Level 2 Dialog")
                .leftButton("Confirm", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve2 Confirm");
                        dialog.dismiss();
                    }
                })
                .rightButton("Cancel", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve2 Cancel");
                        dialog.dismiss();
                    }
                })
                .level(DialogConstants.DialogLevel.USER_CONFIRM)
                .build();
        builder3 = new CommonDialogBuilder(this)
                .title("Level 3 Dialog")
                .leftButton("Confirm", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve3 Confirm");
                        dialog.dismiss();
                    }
                })
                .rightButton("Cancel", new CommonDialogBuilder.ButtonClickLister() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        Log.e(DIALOG_TAG, "Leve3 Cancel");
                        dialog.dismiss();
                    }
                })
                .level(DialogConstants.DialogLevel.SYSTEM)
                .build();
    }

}