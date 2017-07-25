package pe.devpicon.android.myliniochallengeapplication.data.entity

import pe.devpicon.android.myliniochallengeapplication.model.CollectionModel
import pe.devpicon.android.myliniochallengeapplication.model.ProductModel

/**
 * Created by armando on 7/25/17.
 */
class Result(val products : MutableList<ProductModel>, val collections : MutableList<CollectionModel>) {
    operator fun component1(): List<ProductModel>? {
        return products
    }
    operator fun component2(): List<CollectionModel>? {
        return collections
    }
}