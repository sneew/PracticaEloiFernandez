package com.example.practicapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.practicapp.model.Pelicula;

import java.util.List;

@Dao
public interface PeliculaDao {
    @Query("SELECT * FROM pelicula")
    List<Pelicula> getPelicules();
    @Query("SELECT * FROM pelicula WHERE id LIKE :uuid")
    Pelicula getPelicula(String uuid);
    @Insert
    void addPelicula(Pelicula book);
    @Delete
    void deletePelicula(Pelicula book);
    @Update
    void updatePelicula(Pelicula book);

}
