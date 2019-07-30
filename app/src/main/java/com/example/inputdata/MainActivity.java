package com.example.inputdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText mEdtNama;
    RadioGroup mRadioGroup;
    Button mBtnKurang;
    Button mBtnTambah;
    Button mBtnPesan;
    TextView mTvJumlah;
    TextView mTvHargasatuan;
    TextView mTvHargatotal;

    int jumlahPesan;
    int hargaTotal;
    int hargaSatuan;
    String kelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtNama = findViewById(R.id.edt_nama);
        mRadioGroup = findViewById(R.id.Radiogroup);
        mBtnKurang = findViewById(R.id.btn_kurang);
        mBtnTambah = findViewById(R.id.btn_tambah);
        mBtnPesan = findViewById(R.id.btn_pesan);
        mTvJumlah = findViewById(R.id.tv_jumlah);
        mTvHargasatuan = findViewById(R.id.tv_harga_satuan);
        mTvHargatotal = findViewById(R.id.tv_harga_total);

        jumlahPesan = 0;
        hargaSatuan = 7;
        hargaTotal = 0;

        mTvHargasatuan.setText("" + hargaSatuan);
        mTvHargatotal.setText("" + hargaTotal);
        mTvJumlah.setText("" + jumlahPesan);

        mBtnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pesanSekarang();
            }
        });
        mBtnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kurangJumlah();
            }
        });
        mBtnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahJumlah();
            }
        });

    }

    private void tambahJumlah() {
        jumlahPesan = jumlahPesan + 1;
        hargaTotal = jumlahPesan * hargaSatuan;

        mTvJumlah.setText("" + jumlahPesan);
        mTvHargatotal.setText("" + hargaTotal);
    }

    private void kurangJumlah() {
        jumlahPesan = jumlahPesan - 1;

        if (jumlahPesan >= 0) {
            jumlahPesan = 0;
            hargaTotal = jumlahPesan * hargaSatuan;
            mTvJumlah.setText("" + jumlahPesan);
            mTvJumlah.setText("" + jumlahPesan);
        } else {
            Toast.makeText(this, "jumlah tidak boleh minus", Toast.LENGTH_SHORT).show();
        }
    }

    String nama;
    String kelas;
    private void pesanSekarang () {

        int radioDipilih = mRadioGroup.getCheckedRadioButtonId();
        RadioButton radiobutton = (RadioButton)findViewById(radioDipilih);
        kelamin = radiobutton.getText().toString();



        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        intent.putExtra("nama",nama);
        intent.putExtra("kelas",kelas);
        intent.putExtra("hargaSatuan",hargaSatuan);
        intent.putExtra("hargaTotal",hargaTotal);
        intent.putExtra("jumlah",jumlahPesan);

        startActivity(intent);
        finish();


    }
}

