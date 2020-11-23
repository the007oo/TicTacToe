package com.phattarapong.tictactoe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text


class ChooseCellsAdapter(var context : Context, var dataList: ArrayList<Pair<String, Int>>) : BaseAdapter(){

    override fun getCount(): Int = dataList.size

    override fun getItem(p0: Int): Pair<String,Int>? = dataList[p0]

    override fun getItemId(p0: Int): Long = 0

    override fun getView(p0: Int, view: View?, p2: ViewGroup?): View {
        var holder = view
        if(view == null){
            holder = LayoutInflater.from(context).inflate(R.layout.item_choose_cells,p2,false)
            val textView = holder.findViewById<TextView>(R.id.textView)
            textView.text = dataList[p0].first
        }

        return holder!!
    }

}