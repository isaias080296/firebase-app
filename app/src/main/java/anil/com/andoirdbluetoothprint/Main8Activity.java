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

public class Main8Activity extends Activity   {
    Button exelente,bien,regular,malo;
    private static String Respuesta4 = null;
    private static String  Estado="";
    private static String  Acompañantes="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos);

        exelente=(Button) findViewById(R.id.button4);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner3);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.estados, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ///////////////////////////////////////77
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner4);
        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.numero, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        Estado= (String) spinner.getSelectedItem();
        Acompañantes = (String) spinner2.getSelectedItem();
        exelente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main8Activity.this, Main3Activity.class);
                Estado= (String) spinner.getSelectedItem();
                Acompañantes = (String) spinner2.getSelectedItem();
                intent.putExtra("Estado", Estado);
                intent.putExtra("Acompañantes", Acompañantes);
                startActivity(intent);

            }
        });



        exelente=(Button) findViewById(R.id.button5);



        exelente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main8Activity.this, MainActivity.class));
            }
        });



    }
}
