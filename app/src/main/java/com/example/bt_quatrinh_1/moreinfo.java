package com.example.bt_quatrinh_1;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;



public class moreinfo extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){
         AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
         LayoutInflater inflate= getActivity().getLayoutInflater();
        builder.setView(inflate.inflate(R.layout.moreinfoview,null)).setNegativeButton(R.string.reback,null);
       return builder.create();

        }


    public void cancel() {

    }

    @Override
    public void dismiss() {

    }
}
