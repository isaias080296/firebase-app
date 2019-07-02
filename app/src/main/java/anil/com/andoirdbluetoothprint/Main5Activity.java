package anil.com.andoirdbluetoothprint;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Main5Activity extends Activity   {
    Button exelente,bien,regular,malo;
    private static String Respuesta4 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p4);

        final String Respuesta1 = getIntent().getStringExtra("Respuesta1");
        final String Respuesta2 = getIntent().getStringExtra("Respuesta2");
        final String Respuesta3 = getIntent().getStringExtra("Respuesta3");
        final String Estado = getIntent().getStringExtra("Estado");
        final String Acompañantes = getIntent().getStringExtra("Acompañantes");


        exelente=(Button) findViewById(R.id.button13);

        exelente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Respuesta4="Exelente";
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Exelente", Toast.LENGTH_SHORT);

                toast1.show();

                Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
                intent.putExtra("Respuesta3", Respuesta3);
                intent.putExtra("Respuesta1", Respuesta1);
                intent.putExtra("Respuesta2", Respuesta2);
                intent.putExtra("Respuesta4", Respuesta4);
                intent.putExtra("Estado", Estado);
                intent.putExtra("Acompañantes", Acompañantes);
                startActivity(intent);
            }
        });

        bien=(Button) findViewById(R.id.button14);

        bien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Respuesta4="Bien";

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Bien", Toast.LENGTH_SHORT);

                toast1.show();

                Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
                intent.putExtra("Respuesta3", Respuesta3);
                intent.putExtra("Respuesta1", Respuesta1);
                intent.putExtra("Respuesta2", Respuesta2);
                intent.putExtra("Respuesta4", Respuesta4);
                intent.putExtra("Estado", Estado);
                intent.putExtra("Acompañantes", Acompañantes);
                startActivity(intent);
            }
        });

        regular=(Button) findViewById(R.id.button15);

        regular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Respuesta4="Regular";

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Regular", Toast.LENGTH_SHORT);

                toast1.show();

                Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
                intent.putExtra("Respuesta3", Respuesta3);
                intent.putExtra("Respuesta1", Respuesta1);
                intent.putExtra("Respuesta2", Respuesta2);
                intent.putExtra("Respuesta4", Respuesta4);
                intent.putExtra("Estado", Estado);
                intent.putExtra("Acompañantes", Acompañantes);
                startActivity(intent);
            }
        });

        malo=(Button) findViewById(R.id.button16);

        malo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Respuesta4="Malo";
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Malo", Toast.LENGTH_SHORT);

                toast1.show();

                Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
                intent.putExtra("Respuesta3", Respuesta3);
                intent.putExtra("Respuesta1", Respuesta1);
                intent.putExtra("Respuesta2", Respuesta2);
                intent.putExtra("Respuesta4", Respuesta4);
                intent.putExtra("Estado", Estado);
                intent.putExtra("Acompañantes", Acompañantes);
                startActivity(intent);
            }
        });


    }
}

