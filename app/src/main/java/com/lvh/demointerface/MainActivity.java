package com.lvh.demointerface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lvh.demointerface.interfaces.OnSelectListener;

public class MainActivity extends AppCompatActivity {
    private Button btnSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelect = findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OptionsDialog optionsDialog = new OptionsDialog();
                optionsDialog.show(getSupportFragmentManager(),
                        OptionsDialog.class.getSimpleName());
                optionsDialog.setOnSelectListener(new OnSelectListener() {
                    // handle results here
                    @Override
                    public void onEdit() {
                        Toast.makeText(MainActivity.this, "Select edit", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDelete() {
                        Toast.makeText(MainActivity.this, "Select Delete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCanel() {
                        Toast.makeText(MainActivity.this, "Select Canel", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


}
