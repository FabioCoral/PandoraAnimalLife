package com.example.pandoraanimallife

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.pandoraanimallife.databinding.ActivityDetalheBinding

class DetalheActivity: AppCompatActivity(){
    private lateinit var binding: ActivityDetalheBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val criaturaId = intent.getIntExtra("CRIATURA_ID", -1)
        val criatura = CriaturaRepo.buscarPorId(criaturaId)

        if(criatura == null){
            finish()
            return
        }

        binding.tvNome.text = criatura.nome
        binding.habitat.text = criatura.habitat
        binding.descricao.text = criatura.descricao
        binding.ivFoto.setImageResource(criatura.foto)

        if(criatura.nomeNavi != null){
            binding.nomeNavi.text = criatura.nomeNavi
            binding.nomeNavi.visibility = View.VISIBLE
        }else{
            binding.nomeNavi.visibility = View.GONE
        }

        binding.tamanho.text = criatura.tamanho ?: "Tamanho não catalogado"

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}