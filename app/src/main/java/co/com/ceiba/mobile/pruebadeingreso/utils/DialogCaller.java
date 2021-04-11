package co.com.ceiba.mobile.pruebadeingreso.utils;

import android.app.AlertDialog;
import android.content.Context;

public class DialogCaller {

    private static AlertDialog dialog;

    public static void showDialog(Context context){
        dialog = new AlertDialog.Builder(context).create();
        dialog.setMessage("Loading...");
        dialog.show();
    }

    public static void dismissDialog(){
        dialog.dismiss();
    }

}
