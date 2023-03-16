package com.joan.webservice.ui.usuarios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.joan.webservice.databinding.ActivityUserBinding
import com.joan.webservice.ui.actividades.ActividadesActivity

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGoToActividades.setOnClickListener {
            val actividadesActivity = Intent(this, ActividadesActivity::class.java)
            startActivity(actividadesActivity)
        }
    }
}