package com.example.dialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class TrimDialogFragment extends DialogFragment
{
    public interface TrimDialogListener
    {
        public void useTrimmedInput();
        public void usePlainInput();
    }

    private TrimDialogListener myActivity;

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        myActivity = (TrimDialogListener)context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Do you need a trim?");
        builder.setMessage("Your input has spaces at the beginning or end. Do you want to remove those spaces before using the input?");
        builder.setPositiveButton("Trim the spaces", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Log.d("Dialog Click", "Positive Dialog Button pressed");
                myActivity.useTrimmedInput();
            }
        });
        builder.setNegativeButton("Use without trim", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Log.d("Dialog Click", "Negative Dialog Button pressed");
                myActivity.usePlainInput();
            }
        });
        return builder.create();
    }
}
