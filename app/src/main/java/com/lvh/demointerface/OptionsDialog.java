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
import com.lvh.demointerface.interfaces.OnSelectListener;

public class OptionsDialog extends DialogFragment {
    private OnSelectListener onSelectListener;
    private Button btnEdit, btnDelete, btnCanel;

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.onSelectListener = onSelectListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   setStyle(STYLE_NORMAL, R.style.Theme_AppCompat);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_option, container, false);
        btnEdit = view.findViewById(R.id.btnEdit);
        btnDelete = view.findViewById(R.id.btnDelete);
        btnCanel = view.findViewById(R.id.btnCanel);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onSelectListener != null) {
                    onSelectListener.onEdit();
                }
                dismiss();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfirmDeleteDialog confirmDeleteDialog = new ConfirmDeleteDialog();
                confirmDeleteDialog.show(getFragmentManager(), ConfirmDeleteDialog.class.getSimpleName());
                confirmDeleteDialog.setOnConfirmListener(new OnConfirmListener() {
                    @Override
                    public void onDelete() {
                        if (onSelectListener != null) {
                            onSelectListener.onDelete();
                        }
                        dismiss();
                    }

                    @Override
                    public void onCancle() {
                        if (onSelectListener != null) {
                            onSelectListener.onCanel();
                        }
                        dismiss();
                    }
                });
            }
        });

        btnCanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onSelectListener != null) {
                    onSelectListener.onCanel();
                }
                dismiss();
            }
        });
        return view;
    }
}
