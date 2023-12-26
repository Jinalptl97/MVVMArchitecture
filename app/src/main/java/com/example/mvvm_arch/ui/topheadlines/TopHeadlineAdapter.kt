package com.example.mvvm_arch.ui.topheadlines

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_arch.data.model.Article
import com.example.mvvm_arch.databinding.TopHeadlineItemLayoutBinding

class TopHeadlineAdapter(
    private val articlelist: ArrayList<Article>
) : RecyclerView.Adapter<TopHeadlineAdapter.DataViewHolder>() {
    class DataViewHolder(private val binding: TopHeadlineItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.textViewTitle.text = article.title
            binding.textViewDescription.text = article.description
            binding.textViewSource.text = article.source.name
            Glide.with(binding.imageViewBanner.context)
                .load(
                    article.imageurl
                )
                .into(binding.imageViewBanner)
            itemView.setOnClickListener {
                val builder = CustomTabsIntent.Builder()
                val customTabsIntent = builder.build()
                customTabsIntent.launchUrl(it.context, Uri.parse(article.url))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        TopHeadlineItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = articlelist.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(articlelist[position])

    fun addData(list: List<Article>) {
        articlelist.addAll(list)
    }


}

