package com.example.placesinqena.AdapterPackage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.placesinqena.dataPackage.DataPlaces
import com.example.placesinqena.databinding.RecycleViewPlacesBinding

class RecycleAdapter: RecyclerView.Adapter<RecycleAdapter.RecycleView>() {

    private var items : ArrayList<DataPlaces> = ArrayList()

    inner class RecycleView(private val binding : RecycleViewPlacesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataPlaces) {
            binding.tvPlaceName.text = item.placeName
            binding.tvPlaceTitle.text = item.placeInfo
            binding.tvLocation.text = item.location
            binding.ivPlace.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleView {
        return RecycleView(RecycleViewPlacesBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecycleView, position: Int) {
        holder.bind(items[position])
    }

    fun getItems(it : ArrayList<DataPlaces>) {
        val diffUtil = Diffutil(items, it)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        items = it
        diffResults.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}