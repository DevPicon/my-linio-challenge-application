package pe.devpicon.android.myliniochallengeapplication.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import pe.devpicon.android.myliniochallengeapplication.R
import pe.devpicon.android.myliniochallengeapplication.model.CollectionModel

/**
 * Created by armando on 7/25/17.
 */
class CollectionAdapter(var collectionList: List<CollectionModel> =
                        mutableListOf<CollectionModel>()) :
        RecyclerView.Adapter<CollectionViewHolder>() {

    override fun onBindViewHolder(holder: CollectionViewHolder?, position: Int) {
        holder?.bind(collectionList[position])
    }

    override fun getItemCount(): Int = collectionList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CollectionViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_collection, parent,
                false)
        return CollectionViewHolder(view)
    }
}

class CollectionViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun bind(collectionModel: CollectionModel) {
        val context = itemView.context
        val limit = if(collectionModel.productList.size > 3) 3 else collectionModel.productList.size
        for(i in 0 until limit){
            when(i){
                0 -> {
                    val imageView = itemView.findViewById(R.id.iv_collection_1) as ImageView
                    val imageUrl = collectionModel.productList[i].imageUrl
                    populateImage(context, imageUrl, imageView)
                }
                1 -> {
                    val imageView = itemView.findViewById(R.id.iv_collection_2) as ImageView
                    val imageUrl = collectionModel.productList[i].imageUrl
                    populateImage(context, imageUrl, imageView)
                }
                2 -> {
                    val imageView = itemView.findViewById(R.id.iv_collection_3) as ImageView
                    val imageUrl = collectionModel.productList[i].imageUrl
                    populateImage(context, imageUrl, imageView)
                }
            }

            val collectionName = itemView.findViewById(R.id.collection_name) as TextView
            collectionName.text = collectionModel.name

            val collectionSize = itemView.findViewById(R.id.collection_size) as TextView
            collectionSize.text = collectionModel.productList.size.toString()
        }

    }

    private fun populateImage(context: Context?, imageUrl: String, imageView: ImageView) {
        Glide.with(context)
                .load(imageUrl)
                .apply(RequestOptions().placeholder(R.drawable.ic_empty_product_found))
                .into(imageView)
    }

}