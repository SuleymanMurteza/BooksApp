package com.example.kitapuygulamasiornek.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.kitapuygulamasiornek.R
import com.example.kitapuygulamasiornek.data.GirisBilgi
import com.example.kitapuygulamasiornek.databinding.FragmentGirisBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GirisFragment : Fragment() {
    private lateinit var binding: FragmentGirisBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_giris,container,false)
        binding.kisiiNesnesi=this


        val girisBilgi=ArrayList<GirisBilgi>()
        val k1=GirisBilgi("Suleyman","Suleyman")
        girisBilgi.add(k1)

        binding.button.setOnClickListener {
            if(binding.editTextName.text.toString()==k1.userName && binding.editTextPassword.text.toString()==k1.password){
                Navigation.findNavController(it).navigate(R.id.gecisAnasayfa)
            }else{
                Snackbar.make(binding.button,"Yanlış Bilgiler",Snackbar.LENGTH_SHORT).show()
            }
        }


        return binding.root
    }



}