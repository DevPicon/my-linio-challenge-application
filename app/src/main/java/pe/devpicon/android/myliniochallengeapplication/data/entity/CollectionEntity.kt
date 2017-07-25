package pe.devpicon.android.myliniochallengeapplication.data.entity

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

/**
 * Created by armando on 7/20/17.
 */

class CollectionEntity {
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("name")
    var name: String = ""
    @SerializedName("products")
    var jsonObject: JsonObject? = null
}
