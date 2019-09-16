package com.example.practicapp;

import android.content.Context;

import androidx.room.Room;

import com.example.practicapp.database.PeliculaDao;
import com.example.practicapp.database.PeliculaDatabase;
import com.example.practicapp.model.Pelicula;

import java.util.List;

public class PeliculaController {

    private static PeliculaController sPeliculaLab;
    private PeliculaDao peliculaDao;

    private PeliculaController(Context context){
        Context appContext = context.getApplicationContext();
        PeliculaDatabase database = Room.databaseBuilder(appContext, PeliculaDatabase.class, "pelicula").allowMainThreadQueries().build();
        peliculaDao = database.getPeliculaDao();
    }

    public static PeliculaController get(Context context){
        if (sPeliculaLab == null){
            sPeliculaLab = new PeliculaController(context);
        }
        return sPeliculaLab;
    }

    public List<Pelicula> getPelicules(){
        return peliculaDao.getPelicules();
    }

    public Pelicula getPelicula(String id){
        return peliculaDao.getPelicula(id);
    }

    public void addPelicula(Pelicula pelicula){
        peliculaDao.addPelicula(pelicula);
    }

    public void updatePelicula(Pelicula pelicula){ peliculaDao.updatePelicula(pelicula);
    }

    public void deletePelicula(Pelicula pelicula){
        peliculaDao.deletePelicula(pelicula);
    }
}
