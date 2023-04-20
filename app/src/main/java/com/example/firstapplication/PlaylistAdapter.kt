package com.example.firstapplication

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapplication.databinding.PlaylistViewBinding

class PlaylistAdapter (private val context: Context): RecyclerView.Adapter<PlaylistAdapter.MyHolder>(){

    val selectedList = mutableListOf<Int>()
    var nowSelecting:Boolean = false
    class MyHolder(binding: PlaylistViewBinding) : RecyclerView.ViewHolder(binding.root){
        val isChecked = binding.isChecked
//        val isNotChecked = binding.isNotChecked
        val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(PlaylistViewBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int){
        if(!nowSelecting) holder.isChecked.visibility = View.GONE
        else holder.isChecked.visibility = View.VISIBLE
//        holder.isNotChecked.visibility = View.GONE

        holder.root.setOnLongClickListener {
            holder.root.isSelected = true
            holder.isChecked.setImageResource(R.drawable.baseline_check_circle_24)
            notifyDataSetChanged()
            nowSelecting = true
            selectedList.add(position)
            return@setOnLongClickListener(true)
        }

        holder.root.setOnClickListener{
            if(nowSelecting){
                if(!holder.root.isSelected){
                    holder.root.isSelected = true
                    holder.isChecked.setImageResource(R.drawable.baseline_check_circle_24)
                    selectedList.add(position)
                }
                else{
                    holder.root.isSelected = false
                    holder.isChecked.setImageResource(R.drawable.baseline_radio_button_unchecked_24)

                }
            } //else Toast.makeText(holder.root.context,"not Selected",Toast.LENGTH_SHORT).show()
        }
    }

    fun getSelectedItemCount(selectedList: Array<Int>):Int{
        return selectedList.size
    }
}