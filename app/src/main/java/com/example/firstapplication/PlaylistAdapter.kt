package com.example.firstapplication

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapplication.databinding.PlaylistViewBinding

class PlaylistAdapter (private val context: Context): RecyclerView.Adapter<PlaylistAdapter.MyHolder>(){

    val selectedList = mutableListOf<Int>()
    var nowSelecting:Boolean = false
    class MyHolder(binding: PlaylistViewBinding) : RecyclerView.ViewHolder(binding.root){

        val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(PlaylistViewBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int){
        holder.root.setOnLongClickListener {
            holder.root.isSelected = true
            holder.root.setBackgroundColor(Color.GRAY)
            nowSelecting = true
            selectedList.add(position)
            Toast.makeText(holder.root.context, "Long Clicked", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener(true)
        }

        holder.root.setOnClickListener{
            if(nowSelecting){
                if(!holder.root.isSelected){
                    holder.root.setBackgroundColor(Color.GRAY)
                    holder.root.isSelected = true
                    selectedList.add(position)
                    Toast.makeText(holder.root.context,"Short Clicked",Toast.LENGTH_SHORT).show()
                }
                else{
                    holder.root.isSelected = false
                    holder.root.setBackgroundColor(Color.WHITE)
                    Toast.makeText(holder.root.context, "Canceled", Toast.LENGTH_SHORT).show()
                }
            } else Toast.makeText(holder.root.context,"not Selected",Toast.LENGTH_SHORT).show()
        }
    }

    fun getSelectedItemCount(selectedList: Array<Int>):Int{
        return selectedList.size
    }
    private var onItemClickListener((Int)->Unit)? = null
    fun setOnItemclickListener(listener: (Int) -> Unit){
        setOnItemclickListener = listener
    }
}