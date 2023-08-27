package com.example.plantshandbook

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.plantshandbook.databinding.StatusCodeViewBinding
import com.example.plantshandbook.models.StatusCat
import com.example.plantshandbook.models.StatusCodes

class StatusCodeAdapter : RecyclerView.Adapter<StatusCodeAdapter.Item>() {
    private var statusCodeList = ArrayList<StatusCat>()

    fun addStatusCat(statusCat: StatusCat) {
        statusCodeList.add(statusCat)
        notifyItemRangeChanged(statusCodeList.size - 1, 1)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun searchStatusCat(number: String, context: Context) {
        val newArrayOfCodes = StatusCodes.codes.filter { item -> item.contains(number) }

        val newArrayOfCats = arrayListOf<StatusCat>()
        for (statusCode in newArrayOfCodes) {
            newArrayOfCats.add(
                StatusCat(
                    context.getString(
                        R.string.url, statusCode
                    )
                )
            )
        }

        statusCodeList = newArrayOfCats
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.status_code_view, parent, false)
        return Item(view, parent.context)
    }

    override fun getItemCount(): Int {
        return statusCodeList.size
    }

    override fun onBindViewHolder(holder: Item, position: Int) {
        holder.bind(statusCodeList[position])
    }

    class Item(item: View, context: Context) : RecyclerView.ViewHolder(item) {
        private var binding = StatusCodeViewBinding.bind(item)
        private var context: Context

        init {
            this.context = context
        }

        fun bind(statusCat: StatusCat) = with(binding) {
            Glide.with(context).load(statusCat.url).into(this.image)
        }
    }
}