package com.example.homework8

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework8.databinding.ItemDiffLayoutBinding
import com.example.homework8.databinding.ItemLayoutBinding

class RecyclerViewAdapter(private val items:MutableList<Model>,private val itemListener: ItemListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private const val itemViewType = 1
        private const val diffItemViewType = 2
    }

    inner class ItemsViewHolder(private val binding : ItemLayoutBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener,View.OnLongClickListener{
        private lateinit var item : Model
        fun bind(){
          item = items[adapterPosition]
            binding.imImage.setImageResource(item.img?:R.drawable.ic_beetle)
            binding.tVtitle.text = item.title
            binding.tVdescription1.text = item.description1
            binding.tVdescription2.text = item.description2
            binding.root.setOnClickListener(this)
            binding.root.setOnLongClickListener(this)

        }

        override fun onClick(v: View?) {

            itemListener.itemOnClick(adapterPosition)

        }


        override fun onLongClick(v: View?): Boolean {
            itemListener.itemOnLongClick(adapterPosition)
            return false
        }
    }
    inner class DiffItemsViewHolder(private val binding: ItemDiffLayoutBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener,View.OnLongClickListener{
        private lateinit var item : Model
        fun bind(){
            item = items[adapterPosition]

            binding.tVtitle.text = item.title
            binding.tVdescription1.text = item.description1
            binding.tVdescription2.text = item.description2
            binding.root.setOnClickListener(this)
            binding.root.setOnLongClickListener(this)

        }

        override fun onClick(v: View?) {
            itemListener.itemOnClick(adapterPosition)
        }

        override fun onLongClick(v: View?): Boolean {
            itemListener.itemOnLongClick(adapterPosition)
            return false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  if (viewType == itemViewType){
         ItemsViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
     }else{
         DiffItemsViewHolder(ItemDiffLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
     }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemsViewHolder){
            holder.bind()
        }else if (holder is DiffItemsViewHolder){
            holder.bind()
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        val model = items[position]
        return if (model.img == null){
         diffItemViewType
        }else{
         itemViewType
        }
    }


}