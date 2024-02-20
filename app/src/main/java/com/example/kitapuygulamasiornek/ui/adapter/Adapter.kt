package com.example.kitapuygulamasiornek.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.R
import androidx.recyclerview.widget.RecyclerView
import com.example.kitapuygulamasiornek.data.Kitaplar
import com.example.kitapuygulamasiornek.databinding.CardTasarimBinding
import com.example.kitapuygulamasiornek.ui.fragments.AnasayfaFragmentDirections
import com.example.kitapuygulamasiornek.ui.viewmodel.AnasayfaViewModel

class Adapter(var mContext:Context,var kitaplarList:List<Kitaplar>,var viewModel: AnasayfaViewModel)
    :RecyclerView.Adapter<Adapter.cardTasarimTutucu>() {

    inner class cardTasarimTutucu(var binding:CardTasarimBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarimTutucu {
        val binding=CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return cardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return kitaplarList.size
    }

    override fun onBindViewHolder(holder: cardTasarimTutucu, position: Int) {
        val kitap=kitaplarList.get(position)
        val t=holder.binding
        t.textViewKitapYili.text=kitap.kitap_yil.toString()
        t.textViewYazarAdiAnasayfa.text=kitap.kitap_yazar

        t.cardView.setOnClickListener {
            val gecis=AnasayfaFragmentDirections.gecisDetay(kitap)
            Navigation.findNavController(it).navigate(gecis)
        }
        t.imageView.setImageResource(mContext.resources.getIdentifier(kitap.resim,"drawable",mContext.packageName))

    }



}