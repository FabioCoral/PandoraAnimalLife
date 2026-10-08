package com.example.pandoraanimallife

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pandoraanimallife.databinding.ActivityMainBinding
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvCriaturas.layoutManager = LinearLayoutManager(this)
        binding.rvCriaturas.adapter = CriaturaAdapter(CriaturaRepo.lista){
            idCriatura -> val intent = Intent(this, DetalheActivity::class.java)
            intent.putExtra("CRIATURA_ID", idCriatura)
            startActivity(intent)
        }
    }
}