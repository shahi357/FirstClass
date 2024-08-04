package com.example.firstclass.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Cats {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("origin")
    @Expose
    var origin: String? = null

    @SerializedName("temperament")
    @Expose
    var temperament: String? = null

    @SerializedName("colors")
    @Expose
    var colors: List<String>? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null
}
