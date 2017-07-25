package pe.devpicon.android.myliniochallengeapplication.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import pe.devpicon.android.myliniochallengeapplication.R
import pe.devpicon.android.myliniochallengeapplication.controller.MainController
import pe.devpicon.android.myliniochallengeapplication.model.CollectionModel
import pe.devpicon.android.myliniochallengeapplication.model.ProductModel

class MainActivity : AppCompatActivity(), MainView {

    override fun getActivityContext(): Context = this@MainActivity

    val mainController: MainController by lazy { initMainController() }
    val favouriteAdapter: FavouriteAdapter by lazy { initFavouriteAdapter() }
    val collectionAdapter: CollectionAdapter by lazy { initCollectionAdapter() }

    private fun  initCollectionAdapter(): CollectionAdapter = CollectionAdapter()

    private fun  initFavouriteAdapter(): FavouriteAdapter = FavouriteAdapter()

    private fun initMainController(): MainController = MainController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvCollections = findViewById(R.id.rv_collections) as RecyclerView?
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCollections?.layoutManager = linearLayoutManager
        rvCollections?.adapter = collectionAdapter

        val rvFavouriteProducts = findViewById(R.id.rv_favourite_products) as RecyclerView?
        val gridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        rvFavouriteProducts?.layoutManager = gridLayoutManager
        rvFavouriteProducts?.adapter = favouriteAdapter

        mainController.loadProducts()

    }

    override fun showProducts(productModelList: List<ProductModel>?) {
        productModelList?.let{
            val txtAllFavouritesTitles = findViewById(R.id.all_favourites_title) as TextView
            txtAllFavouritesTitles.text = String.format(getString(R.id.all_products_title),
                    productModelList.size)
            favouriteAdapter.productModelList = productModelList
            favouriteAdapter.notifyDataSetChanged()
        }

    }

    override fun showCollections(collections: List<CollectionModel>?) {
        collections?.let{
            collectionAdapter.collectionList = collections
            collectionAdapter.notifyDataSetChanged()
        }

    }
}


