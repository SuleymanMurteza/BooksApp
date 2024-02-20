package com.example.kitapuygulamasiornek.data.repository

import com.example.kitapuygulamasiornek.data.Kitaplar
import com.example.kitapuygulamasiornek.data.datasource.KitaplarDataSource

class KitaplarRepository(val kds: KitaplarDataSource) {

    suspend fun kitaplariiYukle():List<Kitaplar> = kds.kitaplariiYukle()
    suspend fun ara(arananKelime:String):List<Kitaplar> =kds.ara(arananKelime)
}