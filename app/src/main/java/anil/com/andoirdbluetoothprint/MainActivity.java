package anil.com.andoirdbluetoothprint;

/**
 * Created by hp on 12/23/2016.
 */

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Date;
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
import android.text.format.DateFormat;
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

import java.util.UUID;



public class MainActivity extends Activity implements Runnable {
    protected static final String TAG = "TAG";
    private static final int REQUEST_CONNECT_DEVICE = 1;
    private static final int REQUEST_ENABLE_BT = 2;
    EditText etnota1,etnota2,etnota3,sh,sm;
    Switch sw1 , sw2;
    String itemText = null;
    Button encuestaplay;
    String datel = String.valueOf(android.text.format.DateFormat.format("dd-MM-yyyy-hh:mm:ss", new java.util.Date()));
    String Totalweb=null;
    String Transporteweb=null;
    DatabaseReference databaseReference;
    int pequeño1;
    int grande1;
    int xd;





    Button mScan, mPrint, mDisc;
    BluetoothAdapter mBluetoothAdapter;
    private UUID applicationUUID = UUID
            .fromString("00001101-0000-1000-8000-00805F9B34FB");
    private ProgressDialog mBluetoothConnectProgressDialog;
    private BluetoothSocket mBluetoothSocket;
    BluetoothDevice mBluetoothDevice;




    @Override
    public void onCreate(Bundle mSavedInstanceState) {



        super.onCreate(mSavedInstanceState);
        setContentView(R.layout.activity_main);

        encuestaplay=(Button) findViewById(R.id.button2);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        encuestaplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main8Activity.class));
            }
        });

        mScan = (Button) findViewById(R.id.Scan);
        sh=(EditText)findViewById(R.id.editText);
        sm =(EditText)findViewById(R.id.editText3);
        etnota1=(EditText)findViewById(R.id.editText11);
        etnota3=(EditText)findViewById(R.id.editText13);
        sw1 = (Switch) findViewById (R.id.switch1);
        mScan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View mView) {
                mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (mBluetoothAdapter == null) {
                    Toast.makeText(MainActivity.this, "Message1", Toast.LENGTH_SHORT).show();
                } else {
                    if (!mBluetoothAdapter.isEnabled()) {
                        Intent enableBtIntent = new Intent(
                                BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(enableBtIntent,
                                REQUEST_ENABLE_BT);
                    } else {
                        ListPairedDevices();
                        Intent connectIntent = new Intent(MainActivity.this,
                                DeviceListActivity.class);
                        startActivityForResult(connectIntent,
                                REQUEST_CONNECT_DEVICE);
                    }
                }
            }
        });


        mPrint = (Button) findViewById(R.id.mPrint);




        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.transporte, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);




        mPrint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View mView) {
                Thread t = new Thread() {
                    public void run() {

                        String smo=sm.getText().toString();
                        String sho=sh.getText().toString();
                        String val1=etnota1.getText().toString();

                        String val3=etnota3.getText().toString();
                        /*Convertimos de String A  Int*/
                        int num1=Integer.parseInt(val1);
                        int num3=Integer.parseInt(val3);

                        int pequeño=0 ;
                        Transporteweb = (String) spinner.getSelectedItem();

                        int Grande =0;

                        int total =Grande+pequeño;
                        if ( sw1 .isChecked ()){
                            pequeño =100*num1;


                            Grande =120*num3;
                            total =Grande+pequeño;
                        }

                        else{

                            pequeño =80*num1;

                            Grande =100*num3;
                            total =Grande+pequeño;}

                        pequeño1=num1;




                        try {
                            OutputStream os = mBluetoothSocket
                                    .getOutputStream();
                            String BILL = "";
                            String date = String.valueOf(DateFormat.format("dd-MM-yyyy-hh:mm", new Date()));

                            grande1=num3;
                            pequeño1=num1;

                            String datel = String.valueOf(android.text.format.DateFormat.format("dd-MM-yyyy-hh:mm:ss", new java.util.Date()));

                            BILL = BILL
                                    + "-----------------------------------------------\n";
                            BILL = " Recorridos Turisticos \n"
                                    +"La Vitorina \n " +
                                    "Atlixco Puebla    \n" +
                                    date      +"\n";
                            BILL = BILL
                                    + "-----------------------------------------------\n";

                            BILL = " Hora de Salida :"+sho+":"+smo;
                            BILL = BILL
                                    + "-----------------------------------------------\n";
                            BILL = " Recorridos Turisticos \n"
                                    +"La Vitorina \n " +
                                    "Atlixco Puebla    \n" +
                                    date      +"\n"+" Hora de Salida :"+sho+":"+smo;
                            BILL = BILL
                                    + "-----------------------------------------------\n";

                            BILL = BILL + String.format("%1$-10s %2$10s %3$13s %4$10s", "", "Cantidad", "", "Total");
                            BILL = BILL + "\n";
                            BILL = BILL
                                    + "-----------------------------------------------";
                            BILL = BILL + "\n " + String.format("%1$-10s %2$10s %3$11s %4$10s","Grande",num3," ", "$ "+Grande);
                            BILL = BILL + "\n " + String.format("%1$-10s %2$10s %3$11s %4$10s","Chico", num1, "", "$ "+pequeño);
                            BILL = BILL + "\n " + String.format("%1$-10s %2$10s ","Transporte", " "+Transporteweb);


                            BILL = BILL
                                    + "\n-----------------------------------------------";
                            BILL = BILL + "\n\n ";


                            BILL = BILL + "Total a Pagar: $ " + total + ""+ "\n";

                            BILL = BILL
                                    + "-----------------------------------------------\n";

                            BILL = BILL + "Presentarse 5 min antes de su hora de salida.\n";
                            BILL = BILL + "Como van llegando se hara una fila he ingresaran al transporte ";
                            BILL = BILL + "No nos hacemos responsables por objetos olvidados en el vehiculo\n";
                            BILL = BILL + "FELIZ VIAJE";
                            BILL = BILL + "\n\n ";
                            os.write(BILL.getBytes());
                            //This is printer specific code you can comment ==== > Start

                            // Setting height
                            int gs = 29;
                            os.write(intToByteArray(gs));
                            int h = 104;
                            os.write(intToByteArray(h));
                            int n = 162;
                            os.write(intToByteArray(n));

                            // Setting Width
                            int gs_width = 29;
                            os.write(intToByteArray(gs_width));
                            int w = 119;
                            os.write(intToByteArray(w));
                            int n_width = 2;
                            os.write(intToByteArray(n_width));
                            boletos user=new boletos(datel,num1,num3,Transporteweb,total);
                            databaseReference.child("boleto").child(datel).setValue(user);

                            Toast.makeText(getApplicationContext(),
                                    "Boleto registrado",
                                    Toast.LENGTH_SHORT).show();


                        } catch (Exception e) {
                            Log.e("MainActivity", "Exe ", e);
                        }
                    }
                };
                t.start();




            }
        });

        mDisc = (Button) findViewById(R.id.dis);
        mDisc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View mView) {
                if (mBluetoothAdapter != null)
                    mBluetoothAdapter.disable();
            }
        });

    }// onCreate

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        try {
            if (mBluetoothSocket != null)
                mBluetoothSocket.close();
        } catch (Exception e) {
            Log.e("Tag", "Exe ", e);
        }
    }

    @Override
    public void onBackPressed() {
        try {
            if (mBluetoothSocket != null)
                mBluetoothSocket.close();
        } catch (Exception e) {
            Log.e("Tag", "Exe ", e);
        }
        setResult(RESULT_CANCELED);
        finish();
    }

    public void onActivityResult(int mRequestCode, int mResultCode,
                                 Intent mDataIntent) {
        super.onActivityResult(mRequestCode, mResultCode, mDataIntent);

        switch (mRequestCode) {
            case REQUEST_CONNECT_DEVICE:
                if (mResultCode == Activity.RESULT_OK) {
                    Bundle mExtra = mDataIntent.getExtras();
                    String mDeviceAddress = mExtra.getString("DeviceAddress");
                    Log.v(TAG, "Coming incoming address " + mDeviceAddress);
                    mBluetoothDevice = mBluetoothAdapter
                            .getRemoteDevice(mDeviceAddress);
                    mBluetoothConnectProgressDialog = ProgressDialog.show(this,
                            "Connecting...", mBluetoothDevice.getName() + " : "
                                    + mBluetoothDevice.getAddress(), true, false);
                    Thread mBlutoothConnectThread = new Thread(this);
                    mBlutoothConnectThread.start();
                    // pairToDevice(mBluetoothDevice); This method is replaced by
                    // progress dialog with thread
                }
                break;

            case REQUEST_ENABLE_BT:
                if (mResultCode == Activity.RESULT_OK) {
                    ListPairedDevices();
                    Intent connectIntent = new Intent(MainActivity.this,
                            DeviceListActivity.class);
                    startActivityForResult(connectIntent, REQUEST_CONNECT_DEVICE);
                } else {
                    Toast.makeText(MainActivity.this, "Message", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void ListPairedDevices() {
        Set<BluetoothDevice> mPairedDevices = mBluetoothAdapter
                .getBondedDevices();
        if (mPairedDevices.size() > 0) {
            for (BluetoothDevice mDevice : mPairedDevices) {
                Log.v(TAG, "PairedDevices: " + mDevice.getName() + "  "
                        + mDevice.getAddress());
            }
        }
    }

    public void run() {
        try {
            mBluetoothSocket = mBluetoothDevice
                    .createRfcommSocketToServiceRecord(applicationUUID);
            mBluetoothAdapter.cancelDiscovery();
            mBluetoothSocket.connect();
            mHandler.sendEmptyMessage(0);
        } catch (IOException eConnectException) {
            Log.d(TAG, "CouldNotConnectToSocket", eConnectException);
            closeSocket(mBluetoothSocket);
            return;
        }
    }

    private void closeSocket(BluetoothSocket nOpenSocket) {
        try {
            nOpenSocket.close();
            Log.d(TAG, "SocketClosed");
        } catch (IOException ex) {
            Log.d(TAG, "CouldNotCloseSocket");
        }
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mBluetoothConnectProgressDialog.dismiss();
            Toast.makeText(MainActivity.this, "DeviceConnected", Toast.LENGTH_SHORT).show();
        }
    };

    public static byte intToByteArray(int value) {
        byte[] b = ByteBuffer.allocate(4).putInt(value).array();

        for (int k = 0; k < b.length; k++) {
            System.out.println("Selva  [" + k + "] = " + "0x"
                    + UnicodeFormatter.byteToHex(b[k]));
        }

        return b[3];
    }

    public byte[] sel(int val) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.putInt(val);
        buffer.flip();
        return buffer.array();
    }


}
