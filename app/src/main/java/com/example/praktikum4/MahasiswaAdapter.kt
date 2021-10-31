package com.example.praktikum4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class MahasiswaAdapter(val mahasiswa: LiveData<List<MahasiswaModel>>) :
    RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>(){
    class MahasiswaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textNama: TextView = itemView.findViewById(R.id.textNama)
        val textNim: TextView = itemView.findViewById(R.id.textNim)
        val textKelas: TextView = itemView.findViewById(R.id.textKelas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_mahasiswa,parent,false)
        return MahasiswaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        var pos = itemCount-1-position
        holder.textNama.text  = mahasiswa.value!!.get(pos).nama
        holder.textNim.text = mahasiswa.value!!.get(pos).nim
        holder.textKelas.text = mahasiswa.value!!.get(pos).kelas
    }

    override fun getItemCount(): Int {
        return  mahasiswa.value!!.size
    }


}