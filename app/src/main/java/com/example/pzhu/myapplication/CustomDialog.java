package com.example.pzhu.myapplication;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;


/**
 * Created by pzhu on 6/8/2016.
 */
public class CustomDialog extends Dialog {

    private String name;
//  public static EditText etName;
    int percentage;
    Spinner spinner;
    public String zip;
    OnMyDialogResult mDialogResult; // the callback

    public CustomDialog(Context context, String name) {
        super(context);
        this.name = name;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoom_in);
        setTitle("Zoom in");
        Button buttonOK = (Button) findViewById(R.id.OK);
        buttonOK.setOnClickListener(new OKListener());
        spinner = (Spinner) findViewById(R.id.spinner);

    }

    private class OKListener implements android.view.View.OnClickListener {
        @Override
        public void onClick(View v) {
            if( mDialogResult != null ){
                mDialogResult.finish(String.valueOf(spinner.getSelectedItem()));
            }
            CustomDialog.this.dismiss();
        }
    }

    private class CancelListener implements android.view.View.OnClickListener {
        @Override
        public void onClick(View v) {
            mDialogResult = null;
            CustomDialog.this.dismiss();
        }
    }

    public void setDialogResult(OnMyDialogResult dialogResult){
        mDialogResult = dialogResult;
    }

    public interface OnMyDialogResult{
        void finish(String result);
    }
}





