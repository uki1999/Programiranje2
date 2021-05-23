package com.kurs.iserbia.geoistorijskviz;

import android.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Uroš on 25-May-17.
 */

public class DijalogFramgent extends DialogFragment  {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setIcon(android.R.drawable.stat_notify_error)
                .setTitle("Da li zelite da napustite aplikaciju?")
                .setPositiveButton(R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((Interfejs)getActivity()).kliknoOk();
                            }
                        }
                )
                .setNegativeButton(R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((Interfejs)getActivity()).kliknoJok();
                            }
                        }
                )
                .create();
    }

    public static interface Interfejs {
        public void kliknoOk();
        public void kliknoJok();
    }


}




