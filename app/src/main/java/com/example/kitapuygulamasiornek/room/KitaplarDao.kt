package com.example.kitapuygulamasiornek.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.RawQuery
import com.example.kitapuygulamasiornek.data.Kitaplar

@Dao
interface KitaplarDao {
    @Query("SELECT * FROM kitaplar")
    suspend fun kitaplariYukle(): List<Kitaplar>
}

