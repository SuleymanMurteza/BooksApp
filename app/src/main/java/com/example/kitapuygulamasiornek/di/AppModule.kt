package com.example.kitapuygulamasiornek.di

import android.content.Context
import androidx.room.Room
import com.example.kitapuygulamasiornek.data.datasource.KitaplarDataSource
import com.example.kitapuygulamasiornek.data.repository.KitaplarRepository
import com.example.kitapuygulamasiornek.room.KitaplarDao
import com.example.kitapuygulamasiornek.room.VeriTabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKitaplarDataSource(kdao:KitaplarDao): KitaplarDataSource{
        return KitaplarDataSource(kdao)
    }

    @Provides
    @Singleton
    fun provideKitaplarRepository(kds:KitaplarDataSource): KitaplarRepository{
        return KitaplarRepository(kds)
    }
    @Provides
    @Singleton
    fun provideKitaplarDao(@ApplicationContext context:Context): KitaplarDao{
        val vt=Room.databaseBuilder(context,VeriTabani::class.java,"kitaplar.sqlite")
            .createFromAsset("kitaplar.sqlite").build()
        return vt.getKitaplarDao()
    }


}