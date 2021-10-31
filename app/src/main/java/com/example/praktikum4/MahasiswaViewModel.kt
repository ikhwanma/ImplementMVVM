package com.example.praktikum4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MahasiswaViewModel(val mahasiswaRepo: MahasiswaRepo): ViewModel() {
    var mahasiswa = MutableLiveData<List<MahasiswaModel>>()

    fun addMahasiswa(mahasiswaModel: MahasiswaModel){
        mahasiswaRepo.addMahasiswa(mahasiswaModel)
        mahasiswa.value = mahasiswaRepo.getMahasiswa()
    }

    fun getMahasiswa():LiveData<List<MahasiswaModel>>{
        mahasiswa.value = mahasiswaRepo.getMahasiswa()
        return mahasiswa
    }

}