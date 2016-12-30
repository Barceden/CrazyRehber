package com.ufukunal.crazyrehber.Activities;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ufukunal.crazyrehber.Database.Database;
import com.ufukunal.crazyrehber.Model.Kisi;
import com.ufukunal.crazyrehber.R;

public class EkleRehber extends AppCompatActivity {


    EditText advesoyad;
    EditText email;
    EditText telno;
    Spinner cinsiyet;
    Button kaydet;

    private ArrayAdapter<String> cinsiyetAdapter;
    private String[] cinsiyetdeger = {"KADIN","ERKEK"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle_rehber);

        advesoyad = (EditText)findViewById(R.id.etAdveSoyad);
        email = (EditText)findViewById(R.id.etEmail);
        telno = (EditText)findViewById(R.id.etTelNo);
        cinsiyet = (Spinner)findViewById(R.id.spCinsiyet);
        kaydet=(Button)findViewById(R.id.btnKaydet);


        cinsiyetAdapter = new ArrayAdapter<String>(EkleRehber.this,android.R.layout.simple_spinner_item,cinsiyetdeger);
        cinsiyetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cinsiyet.setAdapter(cinsiyetAdapter);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Database db = new Database(EkleRehber.this);

                Kisi kisi = new Kisi();
                kisi.setAdveSoyad(advesoyad.getText().toString());
                kisi.setEmail(email.getText().toString());
                kisi.setTelNo(telno.getText().toString());
                kisi.setCinsiyet(cinsiyet.getSelectedItem().toString());

                db.KisiEkle(kisi);

                Toast.makeText(EkleRehber.this,"Kişi Eklendi.",Toast.LENGTH_SHORT).show();

                finish();

            }
        });

    }
}
