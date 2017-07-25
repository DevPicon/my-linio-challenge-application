package pe.devpicon.android.myliniochallengeapplication.data

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import pe.devpicon.android.myliniochallengeapplication.application.MyApp
import pe.devpicon.android.myliniochallengeapplication.data.entity.CollectionEntity
import pe.devpicon.android.myliniochallengeapplication.data.entity.ProductEntity
import pe.devpicon.android.myliniochallengeapplication.data.entity.Result
import pe.devpicon.android.myliniochallengeapplication.model.CollectionModel
import pe.devpicon.android.myliniochallengeapplication.model.ProductModel
import java.io.IOException

/**
 * Created by armando on 7/25/17.
 */
class DataSource {
        val TAG = DataSource::class.java.simpleName

    val myCollectionType = object : TypeToken<List<CollectionEntity>>() {}.type
    val mapType = object : TypeToken<Map<String, JsonObject>>() {}.type
    val productType = object : TypeToken<ProductEntity>() {}.type
    val gson = Gson()


     fun getDataFromJson(): Result {
        val collectionEntity: List<CollectionEntity> = gson.fromJson(loadJSONFromAsset(),
                myCollectionType)

        val allProducts = mutableListOf<ProductModel>()
        val collections = mutableListOf<CollectionModel>()

        collectionEntity.forEach {
            val productsJsonObject = it.jsonObject
            val productList = mutableListOf<ProductModel>()
            val mapElements: Map<String, JsonObject> = gson.fromJson(productsJsonObject, mapType)
            mapElements.values.forEach {
                val productEntity = gson.fromJson<ProductEntity>(it, productType)
                val productModel = ProductModel(
                        id = productEntity.id,
                        name = productEntity.name,
                        imageUrl = productEntity.imageUrl,
                        linioPlusLevel = productEntity.linioPlusLevel,
                        conditionType = productEntity.conditionType,
                        freeShipping = productEntity.freeShipping,
                        imported = productEntity.imported,
                        active = productEntity.active)


                productList.add(productModel)
                allProducts.add(productModel)
            }

            val collectionModel = CollectionModel(it.id, it.name, productList)
            collections.add(collectionModel)
        }

        return Result(allProducts, collections)
    }


    private fun loadJSONFromAsset(): String? {
        var json: String? = null
        try {
            val `is` = MyApp.jsonInputStream
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        Log.d(TAG, json)
        return json
    }
}