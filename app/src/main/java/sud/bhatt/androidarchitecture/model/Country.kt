package sud.bhatt.androidarchitecture.model

import com.google.gson.annotations.SerializedName




//data class Country(@SerializedName("name") val countryName: String)

class Country {
    @SerializedName("name")
    var countryName: String? = null
}
