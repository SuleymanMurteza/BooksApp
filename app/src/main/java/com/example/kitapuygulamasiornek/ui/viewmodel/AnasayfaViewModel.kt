package com.example.kitapuygulamasiornek.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kitapuygulamasiornek.data.Kitaplar
import com.example.kitapuygulamasiornek.data.repository.KitaplarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor( val krs:KitaplarRepository) :ViewModel() {

    val kitaplar=MutableLiveData<List<Kitaplar>>()

    init {
        kitaplariYukle()
    }



    fun kitaplariYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            kitaplar.value= krs.kitaplariiYukle()
        }

    }
     fun ara(arananKelime:String){
         CoroutineScope(Dispatchers.Main).launch {
             kitaplar.value=krs.ara(arananKelime)

         }
     }
}