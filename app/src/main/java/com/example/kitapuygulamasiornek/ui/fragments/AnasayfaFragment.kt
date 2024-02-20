package com.example.kitapuygulamasiornek.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kitapuygulamasiornek.R
import com.example.kitapuygulamasiornek.data.Kitaplar
import com.example.kitapuygulamasiornek.databinding.FragmentAnasayfaBinding
import com.example.kitapuygulamasiornek.ui.adapter.Adapter
import com.example.kitapuygulamasiornek.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding:FragmentAnasayfaBinding
    private lateinit var viewModel:AnasayfaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)

        viewModel.kitaplar.observe(viewLifecycleOwner){
            val kitaplarAdapter=Adapter(requireContext(),it,viewModel)
            binding.adapter=kitaplarAdapter
        }

        binding.searchView.setOnQueryTextListener(object:OnQueryTextListener{
            override fun onQueryTextChange(p0: String): Boolean {
                viewModel.ara(p0)

                return true
            }

            override fun onQueryTextSubmit(p0: String): Boolean {
                viewModel.ara(p0)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaViewModel by viewModels()
        viewModel=tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.kitaplariYukle()
    }

}