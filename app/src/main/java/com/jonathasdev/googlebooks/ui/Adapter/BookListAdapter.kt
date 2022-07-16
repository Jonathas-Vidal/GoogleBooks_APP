package com.jonathasdev.googlebooks.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jonathasdev.googlebooks.Model.Volume
import com.jonathasdev.googlebooks.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_book.view.*

class BookListAdapter(
    private val items: List<Volume>,
    private val onItemClick: (Volume) -> Unit
): RecyclerView.Adapter<BookListAdapter.BookHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int) : BookHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book,parent,false)
        return BookHolder(layout)
    }

    override fun getItemCount() : Int = items.size

    override fun onBindViewHolder(holder: BookHolder,position: Int) {
        val volume = items[position]
        if(volume.volumeInfo.imageLinks?.smallThumbnail != null) {
            Picasso.get().load(volume.volumeInfo.imageLinks.smallThumbnail).into(
                holder.imgCover
            )
        } else {
            holder.imgCover.setImageResource(R.drawable.ic_broken_image)
        }
        holder.txtTitle.text = volume.volumeInfo.title
        holder.txtAuthor.text = volume.volumeInfo.authors?.joinToString()?: ""
        holder.txtPages.text = volume.volumeInfo.pageCount?.toString()?: "-"
        holder.itemView.setOnClickListener{
            onItemClick(volume)
        }
    }

    class BookHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        val imgCover : ImageView = rootView.img_cover
        val txtTitle: TextView = rootView.text_title
        val txtAuthor: TextView = rootView.text_author
        val txtPages: TextView = rootView.text_pages
    }

}