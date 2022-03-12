package com.chikalfachdiana.recyclerview.util


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chikalfachdiana.recyclerview.databinding.ListItemBinding
import com.chikalfachdiana.recyclerview.model.Gadget

class Adapter(private val list: ArrayList<Gadget>) :
    RecyclerView.Adapter<Adapter.ListViewHolder>() {
    inner class ListViewHolder(private val binding : ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gadget: Gadget) {
            with(binding) {
                Glide.with(this.root)
                    .load(gadget.gadgetimages)
                    .into(binding.ivGadget)

                binding.tvGadget.text = gadget.gadgetName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}


