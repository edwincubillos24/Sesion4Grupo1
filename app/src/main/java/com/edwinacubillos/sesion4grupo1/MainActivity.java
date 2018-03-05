package com.edwinacubillos.sesion4grupo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ePracticas, eAvance, eProy;
    TextView tNotaF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Metodo","OnCreate");

        ePracticas = findViewById(R.id.ePracticas);
        eAvance = findViewById(R.id.eAvances);
        eProy = findViewById(R.id.eProyecto);
        tNotaF = findViewById(R.id.tNotaF);
    }

    public void onClickButton(View view) {
        Double practica, avance, proy, notaf;

        practica = Double.parseDouble(ePracticas.getText().toString());
        avance = Double.parseDouble(eAvance.getText().toString());
        proy = Double.parseDouble(eProy.getText().toString());

        notaf = practica * 0.6 + avance * 0.2 + proy * 0.2;

        tNotaF.setText(String.valueOf(notaf));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mSettings){
            Toast.makeText(this,"Menu Presionado",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
            intent.putExtra("practicas",60);
            intent.putExtra("avance",20);
            intent.putExtra("proyecto",20);
          //  startActivity(intent);
            startActivityForResult(intent,1234);
           // finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK){
            ePracticas.setText(String.valueOf(data.getExtras().getInt("practica")));
            eAvance.setText(String.valueOf(data.getExtras().getInt("avance")));
            eProy.setText(String.valueOf(data.getExtras().getInt("proy")));
        } else {
            if (resultCode == RESULT_CANCELED){
                Toast.makeText(MainActivity.this, "Configuracion cancelada",
                        Toast.LENGTH_SHORT).show();
            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {

        super.onStart();
        Log.d("Metodo","OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Metodo","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Metodo","OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Metodo","OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Metodo","OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Metodo","OnDestroy");
    }


}
