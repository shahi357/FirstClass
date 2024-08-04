package com.example.firstclass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstclass.api.Cats
import com.example.firstclass.databinding.ViewholderListItemBinding
import com.squareup.picasso.Picasso

//class ItemAdapter(val list:List<Cats>, val mClick: ItemClick): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
class ItemAdapter(val list:List<Cats>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding:ViewholderListItemBinding):RecyclerView.ViewHolder(binding.root)
    //var click: ItemClick = itemClick
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // layout file lai viewholder ma convert garera retun garxau,
        val view = ViewholderListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        view.root.setOnClickListener {  }
        // Item view holder ma view pass garnu parne hunale mathi view create gareko
        return ItemViewHolder(view)
    }



    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //  https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg

        // yo function ma data lai view ma set garne kaam hunxa
        holder.binding.tv1.text = list.get(position).name
        holder.binding.description.text = list.get(position).description
        //holder.binding.image.setImageResource(list.get(position).drawable)
        val url =  "https://cataas.com/cat"
        Picasso.get().load(url).into(holder.binding.image)
//        holder.binding.root.setOnClickListener {
////            Toast.makeText(holder.binding.root.context,list.get(position).title,Toast.LENGTH_SHORT).show()
//            mClick?.Click(list.get(position).title)
//        }
    }



    fun myfunc() {}

    fun myfunc1(id:Int):String {
        return "name"
    }


}

interface ItemClick{
    fun Click(text:String)
}