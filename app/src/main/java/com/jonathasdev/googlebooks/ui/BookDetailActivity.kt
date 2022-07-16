package com.jonathasdev.googlebooks.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jonathasdev.googlebooks.Model.Volume
import com.jonathasdev.googlebooks.R
import com.jonathasdev.googlebooks.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_book_detail)

        val volume = intent.getParcelableExtra<Volume>(EXTRA_BOOK)
        if (volume != null) {
            if(volume.volumeInfo.imageLinks?.smallThumbnail != null) {
                Picasso.get().load(volume.volumeInfo.imageLinks.smallThumbnail).into(
                    img_cover
                )
            } else {
                img_cover.setImageResource(R.drawable.ic_broken_image)
            }
            text_title.text = volume.volumeInfo.title
            text_author.text = volume.volumeInfo.authors?.joinToString()?: ""
            text_pages.text = volume.volumeInfo.pageCount?.toString()?: "-"
            text_description.text = volume.volumeInfo.description?.toString() ?: "-"
        }else {
            finish()
        }
    }

    companion object {
        private const val EXTRA_BOOK = "book"
        fun open(context: Context, volume: Volume) {
            val detailIntent = Intent(context,BookDetailActivity::class.java)
            detailIntent.putExtra(EXTRA_BOOK,volume)
            context.startActivity(detailIntent)
        }
    }

}