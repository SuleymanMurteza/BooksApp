package com.example.kitapuygulamasiornek.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.kitapuygulamasiornek.R
import com.example.kitapuygulamasiornek.databinding.FragmentDetayBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding:FragmentDetayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding=DataBindingUtil.inflate(inflater,R.layout.fragment_detay,container,false)

        val bundle:DetayFragmentArgs by navArgs()
        val kitaplar=bundle.gelenKitaplar

        
        binding.textViewKonusu.text=kitaplar.kitap_konu
        binding.textViewYazarAdi.text=kitaplar.kitap_yazar
        binding.textViewKitapYer.text=kitaplar.kitap_yeri
        binding.textViewKitapYil.text=kitaplar.kitap_yil.toString()
        binding.textViewKitapAdi.text=kitaplar.kitap_adi
        binding.imageView2.setImageResource(resources.getIdentifier(kitaplar.resim,"drawable",requireContext().packageName))


        return binding.root
    }



}