package mbk.io.sabrina_hm7_5m

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mbk.io.sabrina_hm7_5m.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            RetrofitService().api.getWeather(binding.etSearch.text.toString())
                .enqueue(object : Callback<WeatherModel> {
                    @SuppressLint("SetTextI18n")
                    override fun onResponse(
                        call: Call<WeatherModel>,
                        response: Response<WeatherModel>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.let {
                                binding.tvResult.text =
                                    "City: ${it.name}\n\nTemp: ${it.main.temp}°C\n\nFeels like: ${it.main.feels_like}°C"
                            }
                        }
                    }

                    override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                        TODO("Not yet implemented")
                    } })
        }
    }
}