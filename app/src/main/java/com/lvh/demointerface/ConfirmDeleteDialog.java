package com.lvh.demointerface;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.lvh.demointerface.interfaces.OnConfirmListener;

public class ConfirmDeleteDialog extends DialogFragment {
    private Button btnYes,btnCancel;
    private OnConfirmListener onConfirmListener;

    public void setOnConfirmListener(OnConfirmListener onConfirmListener){
        this.onConfirmListener = onConfirmListener;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_confirm_delete,container,false);
        btnYes = view.findViewById(R.id.btnYesConfirm);
        btnCancel = view.findViewById(R.id.btnCanelConfirm);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onConfirmListener!=null){
                    onConfirmListener.onDelete();
                }
                dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onConfirmListener!=null){
                    onConfirmListener.onCancle();
                }
                dismiss();

            }
        });
        return view;
    }
}
