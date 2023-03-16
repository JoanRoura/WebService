package com.joan.webservice.ui.actividades

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.joan.webservice.databinding.ActivityActividadesBinding
import com.joan.webservice.repository.GimnasioAPI
import com.joan.webservice.repository.model.Actividades
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActividadesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActividadesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/usuarios/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        val api = retrofit.create(GimnasioAPI::class.java);
        var actividadesList: List<Actividades> = listOf()
        api.getActividades()?.enqueue(object : Callback<List<Actividades?>?> {
            override fun onResponse(call: Call<List<Actividades?>?>?,
                                    response: Response<List<Actividades?>?>) {
                actividadesList  = response.body() as List<Actividades>

                val actividades = arrayOfNulls<String>(actividadesList.size)


                for (i in actividadesList.indices) {
                    actividades[i] = actividadesList[i].name
                    Log.i("Resposta Web Service", "$actividadesList")
                }

                //displaying the string array into listview
//                binding.listViewNameActividades.setAdapter(
//                    ArrayAdapter(
//                        applicationContext,
//                        R.layout.simple_list_item_1,
//                        heroes
//                    )
//                ) //Part Extra
            }

            override fun onFailure(call: Call<List<Actividades?>?>?, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                Log.i("Errro Retrofit", "${t.message}");
            }
        });
        Log.i("asd","$actividadesList")
    }
}

