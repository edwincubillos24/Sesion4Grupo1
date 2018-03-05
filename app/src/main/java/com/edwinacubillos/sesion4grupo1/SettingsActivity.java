package com.edwinacubillos.sesion4grupo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    EditText ePracticas, eAvance, eProy;
    int practica, avance, proy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ePracticas = findViewById(R.id.ePracticas);
        eAvance = findViewById(R.id.eAvances);
        eProy = findViewById(R.id.eProyecto);

        Bundle extras = getIntent().getExtras();
        practica = extras.getInt("practicas");
        avance = extras.getInt("avance");
        proy = extras.getInt("proyecto");

        ePracticas.setText(String.valueOf(practica));
        eAvance.setText(String.valueOf(avance));
        eProy.setText(String.valueOf(proy));
    }

    public void onClickButton(View view) {

        practica = Integer.parseInt(ePracticas.getText().toString());
        avance = Integer.parseInt(eAvance.getText().toString());
        proy = Integer.parseInt(eProy.getText().toString());

        Intent intent = new Intent();
        intent.putExtra("practica",practica);
        intent.putExtra("avance",avance);
        intent.putExtra("proy",proy);
        setResult(RESULT_OK,intent);
        finish();
    }

    public void onClickButtonCancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
