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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main7Activity extends Activity   {
    Button exelente,bien,regular,malo;
    private static String Respuesta1 = null;

    EditText comentarioo;

    DatabaseReference databaseReference;

    String comentario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encuesta);
        final String Respuesta1 = getIntent().getStringExtra("Respuesta1");
        final String Respuesta2 = getIntent().getStringExtra("Respuesta2");
        final String Respuesta3 = getIntent().getStringExtra("Respuesta3");
        final String Respuesta4 = getIntent().getStringExtra("Respuesta4");
        final String Respuesta5 = getIntent().getStringExtra("Respuesta5");
        final String Estado = getIntent().getStringExtra("Estado");
        final String Acompañantes = getIntent().getStringExtra("Acompañantes");

        comentarioo=(EditText)findViewById(R.id.editText4);




        databaseReference = FirebaseDatabase.getInstance().getReference();
        exelente=(Button) findViewById(R.id.button4);

        exelente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Respuesta1="Exelente";

                startActivity(new Intent(Main7Activity.this, Main8Activity.class));
                comentario=comentarioo.getText().toString();
                encuesta user=new encuesta(Respuesta1,Respuesta2,Respuesta3,Respuesta4,Respuesta5,Estado,Acompañantes,comentario);
                databaseReference.child("encuesta").push().setValue(user);
            }
        });


    }
}
