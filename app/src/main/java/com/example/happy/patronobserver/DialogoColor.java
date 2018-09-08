package com.example.happy.patronobserver;

import android.app.Dialog;
import android.content.DialogInterface;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

public class DialogoColor extends AppCompatDialogFragment{

    //Observable

    //Paso 2: Crear objeto como variable globañ
    MiListener listener;


    //Paso 1: Crear interface
    interface MiListener {
        void onChangeColor(String color);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Cambiar Color");
        builder.setMessage("Seleccione un Color");

        builder.setPositiveButton("Blanco", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onChangeColor("Blanco");
            }
        });


        builder.setNeutralButton("Gris", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               listener.onChangeColor("Gris");
            }
        });


        builder.setNegativeButton("Negro", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              listener.onChangeColor("Negro");
            }
        });

        return builder.create();
    }

    //Paso 3: Metodo set para el listener
    public void setListener(MiListener listener) {
        this.listener = listener;
    }
}
