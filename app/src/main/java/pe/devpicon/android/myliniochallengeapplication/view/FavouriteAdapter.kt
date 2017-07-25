package pe.devpicon.android.myliniochallengeapplication.view

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import pe.devpicon.android.myliniochallengeapplication.R
import pe.devpicon.android.myliniochallengeapplication.model.ProductModel

/**
 * Created by armando on 7/20/17.
 */
class FavouriteAdapter(var productModelList: List<ProductModel> = mutableListOf<ProductModel>()) :
        RecyclerView
.Adapter<ProductViewHolder>() {


    override fun onBindViewHolder(holder: ProductViewHolder?, position: Int) {
        holder?.bind(productModelList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_product, parent,
                false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int  = productModelList.size

}

class ProductViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
    val LOG : String = javaClass.simpleName
    fun bind(productModel: ProductModel) {
        Log.d(LOG, productModel.toString())

        val ivProduct = itemView.findViewById(R.id.iv_product) as ImageView
        val ivFreeshipping = itemView.findViewById(R.id.iv_freeshipping) as ImageView

        val ivLinioPlusLevel = itemView.findViewById(R.id.iv_linio_plus_level)
        val ivLinioPlusLevel48 = itemView.findViewById(R.id.iv_linio_plus_level_48)

        if(productModel.freeShipping) ivFreeshipping.visibility = View.VISIBLE else ivFreeshipping
                .visibility = View.GONE

        if(productModel.linioPlusLevel.equals(1)){
            ivLinioPlusLevel.visibility = View.VISIBLE
            ivLinioPlusLevel48.visibility = View.GONE
        } else {
            ivLinioPlusLevel.visibility = View.GONE
            ivLinioPlusLevel48.visibility = View.VISIBLE
        }

        if(productModel.conditionType.equals("refurbished")){
            itemView.findViewById(R.id.iv_new).visibility = View.GONE
            itemView.findViewById(R.id.iv_refurbished).visibility = View.VISIBLE
        } else if (productModel.conditionType.equals("new")){
            itemView.findViewById(R.id.iv_new).visibility = View.VISIBLE
            itemView.findViewById(R.id.iv_refurbished).visibility = View.GONE
        } else{
            itemView.findViewById(R.id.iv_new).visibility = View.GONE
            itemView.findViewById(R.id.iv_refurbished).visibility = View.GONE
        }

        if(productModel.imported)
            itemView.findViewById(R.id.iv_international).visibility = View.VISIBLE
        else itemView.findViewById(R.id.iv_international).visibility = View.GONE

        Glide.with(itemView.context)
                .load(productModel.imageUrl)
                .apply(RequestOptions().placeholder(R.drawable.ic_empty_product_found))
                .into(ivProduct)


    }
}