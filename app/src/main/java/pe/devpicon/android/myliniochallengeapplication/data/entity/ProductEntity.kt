package pe.devpicon.android.myliniochallengeapplication.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by armando on 7/20/17.
 */
data class ProductEntity(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        var name:String,
        @SerializedName("image")
        val imageUrl:String,
        @SerializedName("linioPlusLevel")
        val linioPlusLevel:Int,
        @SerializedName("conditionType")
        val conditionType: String,
        @SerializedName("freeShipping")
        val freeShipping:Boolean = false,
        @SerializedName("imported")
        val imported:Boolean = false,
        @SerializedName("active")
        val active: Boolean = false)

/*

"id": 2286984,
"name": "Báscula Digital Omron HN 289 - Aqua",
"wishListPrice": 399,
"slug": "ba-scula-digital-omron-hn-289-aqua-x2pl84",
"url": "/mapi/v1/p/ba-scula-digital-omron-hn-289-aqua-x2pl84",
"image": "https://i.linio.com/p/c97a50b1c6c7e3bb2c48c1b4104d5975-product.jpg",
"linioPlusLevel": 1,
"conditionType": "refurbished",
"freeShipping": false,
"imported": false,
"active": true

 */