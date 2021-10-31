package com.example.praktikum4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMahasiswa:RecyclerView
    private lateinit var btnInput:Button
    private lateinit var inputNama:EditText
    private lateinit var inputNim:EditText
    private lateinit var inputKelas:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMahasiswa = findViewById(R.id.rvMahasiswa)
        btnInput = findViewById(R.id.btnInput)
        inputNama = findViewById(R.id.inputNama)
        inputNim = findViewById(R.id.inputNim)
        inputKelas = findViewById(R.id.inputKelas)

        val mahasiswaVM = ViewModelProvider(this).get(MahasiswaViewModel::class.java)
        rvMahasiswa.adapter = MahasiswaAdapter(mahasiswaVM.getMahasiswa())
        rvMahasiswa.layoutManager = LinearLayoutManager(this)

        btnInput.setOnClickListener {
            mahasiswaVM.addMahasiswa(MahasiswaModel(inputNama.text.toString(),inputNim.text.toString(), inputKelas.text.toString()))
            rvMahasiswa.adapter = MahasiswaAdapter(mahasiswaVM.getMahasiswa())
            rvMahasiswa.layoutManager = LinearLayoutManager(this)
            inputNim.setText("")
            inputNama.setText("")
            inputKelas.setText("")
        }

    }

}