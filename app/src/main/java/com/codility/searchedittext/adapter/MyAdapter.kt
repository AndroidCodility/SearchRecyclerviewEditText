package com.codility.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.codility.searchedittext.app.OnClickListener
import com.codility.searchedittext.R

/**
 * Created by Govind on 3/19/2018.
 */
class MyAdapter(private var userList: ArrayList<User>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var listener: OnClickListener? = null

    fun setListener(onClickListener: OnClickListener) {
        this.listener = onClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userList[position])
        //Custom OnClickListener Event
        holder.itemView.setOnClickListener(View.OnClickListener {
            if (listener != null) {
                listener!!.onClickEvent(userList[position])
            }
        })
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(user: User) {
            val tvName = itemView.findViewById<TextView>(R.id.tvName)
            val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
            tvName.text = user.name;
            tvAddress.text = user.address
        }
    }

    /*This method will filter the list and here we are passing the filtered data
        and assigning it to the list with notifyDataSetChanged method
    */
    fun filterList(filteredNames: ArrayList<User>) {
        this.userList = filteredNames
        notifyDataSetChanged()
    }
}