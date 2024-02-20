package com.example.kitapuygulamasiornek.data.datasource

import com.example.kitapuygulamasiornek.data.Kitaplar
import com.example.kitapuygulamasiornek.room.KitaplarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KitaplarDataSource(var kdao:KitaplarDao) {

    suspend fun kitaplariiYukle():List<Kitaplar> =
        withContext(Dispatchers.IO){

            return@withContext kdao.kitaplariYukle()
    }
    suspend fun ara(arananKelime:String):List<Kitaplar> =
        withContext(Dispatchers.IO){
            val kitaplar=ArrayList<Kitaplar>()
            val k1= Kitaplar("Don Kisot","Miguel de Cervantes Saavedra","Ispanya",1605,
                "La Mancha ilinde yaşayan 50'li yaslarında bir aristokrat olan Alonso Quijano, sovalye kitaplarına takıntılıdır. O kadar çok okur ki, sonunda çıldırır. Fakat sadece şövalyelerle ilgili konularda çıldırmıştır, diğer konularda ise son derece akıllı bir asilzadedir.","don_kisot")
            kitaplar.add(k1)
            return@withContext kitaplar
        }



}