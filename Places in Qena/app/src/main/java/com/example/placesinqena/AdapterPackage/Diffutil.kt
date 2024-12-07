package com.example.placesinqena.AdapterPackage

import androidx.recyclerview.widget.DiffUtil
import com.example.placesinqena.dataPackage.DataPlaces

class Diffutil(val oldList: ArrayList<DataPlaces>, val newList: ArrayList<DataPlaces>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].placeName != newList[newItemPosition].placeName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}