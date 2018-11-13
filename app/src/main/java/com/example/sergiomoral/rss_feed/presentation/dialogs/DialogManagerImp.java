package com.example.sergiomoral.rss_feed.presentation.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.example.sergiomoral.rss_feed.R;

import javax.inject.Inject;

public class DialogManagerImp implements DialogManager {

    private Activity mActivity;
    private static final String TAG = "DialogManagerImp";

    @Inject
    public DialogManagerImp(Activity activity) {
        Log.d(TAG, "DialogManagerImp: Constructor");
        this.mActivity = activity;
    }

    @Override
    public void showErrorMessage(String title, String message) {
        Log.d(TAG, "showErrorMessage: Error dialog");
        AlertDialog alertDialog = new AlertDialog.Builder(mActivity).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, mActivity.getResources().getString(R.string.ok),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}

