package com.luluksofiyah.uas.di

import android.content.Context
import androidx.room.Room
import com.luluksofiyah.uas.data.source.local.room.FilmDB
import com.luluksofiyah.uas.data.source.local.room.FilmGet
import com.luluksofiyah.uas.utilities.Constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModul {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): FilmDB {
        return Room.databaseBuilder(
            context = context,
            klass = FilmDB::class.java,
            name = DB_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMovieDao(database: FilmDB): FilmGet = database.FilmGet()
}