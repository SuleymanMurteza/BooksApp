package com.example.kitapuygulamasiornek.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kitapuygulamasiornek.data.Kitaplar
import com.example.kitapuygulamasiornek.data.converters.Converters

@Database(entities = [Kitaplar::class], version = 1)
@TypeConverters(Converters::class)
abstract class VeriTabani : RoomDatabase(){
    abstract fun getKitaplarDao() : KitaplarDao
}