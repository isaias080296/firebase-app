
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

public class Main3Activity extends Activity   {
    Button exelente,bien,regular,malo;
    private static String Respuesta1 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p2);


        final String Estado = getIntent().getStringExtra("Estado");
        final String Acompañantes = getIntent().getStringExtra("Acompañantes");
        exelente=(Button) findViewById(R.id.button13);

        exelente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Respuesta1="Exelente";
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Exelente", Toast.LENGTH_SHORT);

                toast1.show();
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                intent.putExtra("Respuesta1", Respuesta1);
                intent.putExtra("Estado", Estado);
                intent.putExtra("Acompañantes", Acompañantes);
                startActivity(intent);
            }
        });

        bien=(Button) findViewById(R.id.button14);

        bien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Respuesta1="Bien";
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Bien", Toast.LENGTH_SHORT);

                toast1.show();
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                intent.putExtra("Respuesta1", Respuesta1);
                intent.putExtra("Estado", Estado);
                intent.putExtra("Acompañantes", Acompañantes);
                startActivity(intent);
            }
        });

        regular=(Button) findViewById(R.id.button15);

        regular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Respuesta1="Regular";
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Regular", Toast.LENGTH_SHORT);

                toast1.show();
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                intent.putExtra("Respuesta1", Respuesta1);
                intent.putExtra("Estado", Estado);
                intent.putExtra("Acompañantes", Acompañantes);
                startActivity(intent);
            }
        });

        malo=(Button) findViewById(R.id.button16);

        malo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Respuesta1="Malo";

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Malo", Toast.LENGTH_SHORT);

                toast1.show();

                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                intent.putExtra("Respuesta1", Respuesta1);
                intent.putExtra("Estado", Estado);
                intent.putExtra("Acompañantes", Acompañantes);
                startActivity(intent);
            }
        });


    }
}

