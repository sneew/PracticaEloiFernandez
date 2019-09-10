package com.example.practicapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.practicapp.model.Pelicula;

@Database(entities = {Pelicula.class}, version = 1)
public abstract class PeliculaDatabase extends RoomDatabase {
    public abstract PeliculaDao getPeliculaDao();

}
