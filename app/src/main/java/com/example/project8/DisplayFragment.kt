package com.example.project8

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.project8.databinding.FragmentDisplayBinding


class DisplayFragment: Fragment() {
    val movie = DisplayFragmentArgs.fromBundle(requireArguments()).Movie

    private var _binding: FragmentDisplayBinding? = null

    private val binding get() = _binding!!
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = binding.root
        binding.Genre.text = movie.Genre
        binding.imdbRating.text = movie.imdbRating
        binding.Title.text = movie.Title
        binding.Year.text = movie.Year
        binding.Rated.text = movie.Rated
        binding.Runtime.text = movie.Runtime
        binding.Link.text = "https://www.imdb.com/title/${movie.imdbID}/"

        Glide.with(requireContext()).load(movie.Poster)
            .apply(
                RequestOptions().transform(
                    CenterCrop(), RoundedCorners(20)
                )
            )
            .into(binding.Poster)

        return view

    }



}

