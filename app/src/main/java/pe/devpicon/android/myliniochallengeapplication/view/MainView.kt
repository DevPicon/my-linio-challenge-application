package pe.devpicon.android.myliniochallengeapplication.view

import android.content.Context
import pe.devpicon.android.myliniochallengeapplication.model.CollectionModel
import pe.devpicon.android.myliniochallengeapplication.model.ProductModel

/**
 * Created by armando on 7/20/17.
 */
interface MainView {
    fun showProducts(productModelList: List<ProductModel>?)
    fun getActivityContext(): Context
    fun showCollections(collections: List<CollectionModel>?)
}