package com.majada.jhona.practica4_4;

import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] TIPO_LLAMADA = {"","Entrante","Saliente","Perdida"};

        TextView salida = (TextView) findViewById(R.id.salida);

        Uri llamadas = Uri.parse("content://call_log/calls");

        Cursor c = managedQuery(llamadas, null, null, null, null);

        while (c.moveToNext()) {

            salida.append("\n"
                    + DateFormat.format("dd/MM/yy k:mm (",
                    c.getLong(c.getColumnIndex(CallLog.Calls.DATE)))
                    + c.getString(c.getColumnIndex(CallLog.Calls.DURATION)) + ") "
                    + c.getString(c.getColumnIndex(CallLog.Calls.NUMBER)) + ", "
                    + TIPO_LLAMADA[Integer.parseInt(c.getString(c
                    .getColumnIndex(CallLog.Calls.TYPE)))]);
        }
    }
}
