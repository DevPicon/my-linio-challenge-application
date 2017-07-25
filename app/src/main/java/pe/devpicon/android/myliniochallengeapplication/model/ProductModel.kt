package pe.devpicon.android.myliniochallengeapplication.model

/**
 * Created by armando on 7/25/17.
 */
data class ProductModel (
        val id: Int,
        var name:String,
        val imageUrl:String,
        val linioPlusLevel:Int,
        val conditionType: String,
        val freeShipping:Boolean = false,
        val imported:Boolean = false,
        val active: Boolean = false)