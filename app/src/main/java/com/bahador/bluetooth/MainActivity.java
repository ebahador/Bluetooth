package com.bahador.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button control;
    TextView status;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = findViewById(R.id.bluth);
        status = findViewById(R.id.status);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                En_Dis_Bluetooth();
            }
        });

    }

    private void En_Dis_Bluetooth() {
        if (bluetoothAdapter == null) {
            status.setText("Your device does not support bluetooth");
            return;
        }
        if (!bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.enable();
            status.setText("Your Bluetooth is On");
        } else {
            bluetoothAdapter.disable();
            status.setText("Your Bluetooth is Off");
        }

    }
}