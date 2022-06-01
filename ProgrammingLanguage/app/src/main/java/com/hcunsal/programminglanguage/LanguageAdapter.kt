package com.hcunsal.programminglanguage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hcunsal.programminglanguage.databinding.RecyclerLanguageBinding

class LanguageAdapter(val languageList : ArrayList<Language>) : RecyclerView.Adapter<LanguageAdapter.LanguageHolder>() {

    class LanguageHolder(val binding: RecyclerLanguageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageHolder {
      val binding = RecyclerLanguageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LanguageHolder(binding)
    }

    override fun onBindViewHolder(holder: LanguageHolder, position: Int) {
        holder.binding.nameText.text = languageList.get(position).name
        holder.binding.dateText.text = languageList.get(position).date
        holder.binding.imageView.setImageResource(languageList.get(position).image)
    }

    override fun getItemCount(): Int {
       return languageList.size
    }

}

