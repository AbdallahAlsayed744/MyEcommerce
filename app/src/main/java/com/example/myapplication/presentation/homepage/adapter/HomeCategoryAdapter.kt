package com.example.myapplication.presentation.homepage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CategoryDesignBinding

class HomeCategoryAdapter: RecyclerView.Adapter<HomeCategoryAdapter.categoryviewholder> (){

    private var categories: List<String> = listOf()

    // Method to update the list
    fun updateCategories(newCategories: List<String>) {
        categories = newCategories
        notifyDataSetChanged() // Notify the adapter to refresh the views
    }

//    private val diffUtil=object : DiffUtil.ItemCallback<String>(){
//        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
//            return oldItem==newItem
//        }
//
//        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
//            return oldItem==newItem
//        }
//
//    }
//    val differ= AsyncListDiffer(this,diffUtil)

    inner class categoryviewholder(val binding: CategoryDesignBinding) : RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoryviewholder {

        val binding = CategoryDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return categoryviewholder(binding)


    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: categoryviewholder, position: Int) {
        val category = categories[position]
        holder.binding.text.text = category
    }

}