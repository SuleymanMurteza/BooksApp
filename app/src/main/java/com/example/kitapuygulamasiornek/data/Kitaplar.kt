package com.example.kitapuygulamasiornek.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "kitaplar")
data class Kitaplar(@PrimaryKey
                    @ColumnInfo(name = "kitap_adi") @NotNull var kitap_adi:String,
                    @ColumnInfo(name = "kitap_yazar") @NotNull var kitap_yazar:String,
                    @ColumnInfo(name = "kitap_yeri") @NotNull var kitap_yeri:String,var kitap_yil:Int,
                    @ColumnInfo(name = "kitap_konu") @NotNull var kitap_konu:String,
                    @ColumnInfo(name = "resim") @NotNull var resim:String)
    :Serializable{
}