package com.aligkts.photos.ui.photo

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aligkts.photos.R
import com.aligkts.photos.common.ui.FullScreenImageActivity
import com.aligkts.photos.common.ui.inflate
import com.aligkts.photos.databinding.ItemMainBinding
import com.aligkts.photos.ui.photo.model.PhotoItem
import javax.inject.Inject


/**
 * Created by Ali Göktaş on 6,July,2020
 */
class PhotosAdapter @Inject constructor() :
    RecyclerView.Adapter<PhotosAdapter.PhotoItemViewHolder>() {

    private var photoItems: MutableList<PhotoItem> = mutableListOf()
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoItemViewHolder {
        val itemBinding = parent.inflate<ItemMainBinding>(R.layout.item_main, false)
        return PhotoItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = photoItems.size

    override fun onBindViewHolder(holder: PhotoItemViewHolder, position: Int) {
        context = holder.itemView.context
        holder.bind(getPhotos(position))
    }

    private fun getPhotos(position: Int) = photoItems[position]

    fun setScrolledPhoto(photo: List<PhotoItem>) {
        val beforeSize = photoItems.size
        photoItems.addAll(photo)
        notifyItemRangeInserted(beforeSize, photo.size)
    }

    fun setPhotos(photos: List<PhotoItem>) {
        photoItems.addAll(photos)
        notifyDataSetChanged()
    }

    fun clearItemList() {
        photoItems.clear()
    }

    inner class PhotoItemViewHolder(private val binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photoItem: PhotoItem) {
            with(binding) {
                viewState = PhotoItemViewState(photoItem)
                executePendingBindings()
                this.imgItem.setOnClickListener {
                    val intent = Intent(context, FullScreenImageActivity::class.java)
                    intent.data = Uri.parse(photoItem.imageUrl)
                    context.startActivity(intent)
                }
            }
        }

    }
}