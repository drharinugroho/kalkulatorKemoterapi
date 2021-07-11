package com.example.android.kalkulatorkemoterapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Fungsi tombol hitung
     */

    public void hitung(View view) {

        //mengubah input usia ke variable finalUsiaPasien
        EditText usia = (EditText) findViewById(R.id.usia);
        String usiaPasien = usia.getText().toString();
        int finalUsiaPasien = Integer.parseInt(usiaPasien);

        //mengubah input berat badan ke variable finalBeratBadan
        EditText berat = (EditText) findViewById(R.id.beratBadan);
        String beratBadan = berat.getText().toString();
        int finalBeratBadan = Integer.parseInt(beratBadan);

        //mengubah input tinggi badan ke variable finalTinggiBadan
        EditText tinggi = (EditText) findViewById(R.id.tinggiBadan);
        String tinggiBadan = tinggi.getText().toString();
        int finalTinggiBadan = Integer.parseInt(tinggiBadan);

        //mengubah input serum Kreatinin ke variable finalSerumKreatinin
        EditText kadarSK = (EditText) findViewById(R.id.serumKreatinin);
        String serumKreatinin = kadarSK.getText().toString();
        double finalSerumKreatinin = Double.parseDouble(serumKreatinin);

        //menghitung dosis Paclitaxel = LPT x 175 mg
        //LPT = akar kuadrat dari ((BB x TB)/3600)

        double isiLPT = (finalBeratBadan * finalTinggiBadan) / 3600;
        double luasPermukaanTubuh = Math.sqrt(isiLPT);
        double dosisPaclitaxel = luasPermukaanTubuh * 175;

        //menghitung dosis Carboplatin = (GFR + 25) x 6
        //GFR = ((140-Umur) x BeratBadan x 0.85) / (72 x SK)

        double dosisCarboplatin = ((((140 - finalUsiaPasien) * finalBeratBadan * 0.85) / (72 * finalSerumKreatinin)) + 25) * 6;


        //menampilkan kadar Paclitaxel
        TextView kadarPaclitaxel = (TextView) findViewById(R.id.paclitaxel);
        kadarPaclitaxel.setText((int) dosisPaclitaxel + " mg");

        //menampilkan kadar Carboplatin
        TextView kadarCarboplatin = (TextView) findViewById(R.id.carboplatin);
        kadarCarboplatin.setText((int) dosisCarboplatin + " mg");


    }


}
