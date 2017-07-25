package pe.devpicon.android.myliniochallengeapplication.controller

import pe.devpicon.android.myliniochallengeapplication.data.DataSource
import pe.devpicon.android.myliniochallengeapplication.view.MainView

/**
 * Created by armando on 7/20/17.
 */
class MainController(val view: MainView) {
    var dataSource : DataSource = DataSource()

    fun loadProducts() {

        val (allProducts, collections) = dataSource.getDataFromJson()

        view.showProducts(allProducts)
        view.showCollections(collections)
    }



}

