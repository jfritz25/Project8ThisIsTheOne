package com.example.project8

import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs

class DisplayFragment: Fragment() {
    val movie = DisplayFragmentArgs.fromBundle(requireArguments()).Movie

    fun bind(){
        val genre = movie.Genre
        val imdbRating = movie.imdbRating
        val title = movie.Title
        val year = movie.Year
        val rating = movie.Rated
        val runtime = movie.Runtime
        val poster = movie.Poster
    }



}