package mbk.io.sabrina_hm7_5m

data class WeatherModel(
    var main: MainModel,
    var wind: WindModel,
    var name: String
)

data class WindModel (
    var speed: Double
)

data class MainModel (
    var temp: Double,
    var feels_like : Double
)
