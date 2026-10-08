package com.example.pandoraanimallife

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pandoraanimallife.databinding.ItemCriaturaBinding

class CriaturaAdapter(
    private val lista: List<Criatura>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<CriaturaAdapter.CriaturaViewHolder>() {

    class CriaturaViewHolder(val binding: ItemCriaturaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriaturaViewHolder {
        val binding = ItemCriaturaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CriaturaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CriaturaViewHolder, position: Int) {
        val criatura = lista[position]
        val binding = holder.binding

        binding.tvNome.text = criatura.nome
        binding.habitat.text = criatura.habitat
        binding.ivFoto.setImageResource(criatura.foto)

        if (criatura.nomeNavi != null) {
            binding.nomeNavi.text = criatura.nomeNavi
            binding.nomeNavi.visibility = View.VISIBLE
        } else {
            binding.nomeNavi.visibility = View.GONE
        }


        binding.root.setOnClickListener {
            onClick(criatura.id)
        }
    }

    override fun getItemCount(): Int = lista.size
}

