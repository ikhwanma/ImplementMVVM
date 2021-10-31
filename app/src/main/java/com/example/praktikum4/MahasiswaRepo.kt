package com.example.praktikum4

class MahasiswaRepo {
    var mahasiswaList = mutableListOf<MahasiswaModel>()

    fun getMahasiswa() = mahasiswaList

    fun addMahasiswa(mahasiswaModel: MahasiswaModel){
        mahasiswaList.add(mahasiswaModel)
    }
}