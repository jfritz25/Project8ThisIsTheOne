package com.example.project8

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
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
import com.example.project8.model.OMDBMovie


class DisplayFragment: Fragment() {
    val movie = DisplayFragmentArgs.fromBundle(requireArguments()).movie

    private var _binding: FragmentDisplayBinding? = null

    private val binding get() = _binding!!
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = binding.root
        binding.Genre.text = movie?.genre
        binding.imdbRating.text = movie?.imdbRating
        binding.Title.text = movie?.title
        binding.Year.text = movie?.year
        binding.Rated.text = movie?.rating
        binding.Runtime.text = movie?.runtime
        binding.Link.text = "https://www.imdb.com/title/${movie?.imdbID}/"

        Glide.with(requireContext()).load(movie?.posterString)
            .apply(
                RequestOptions().transform(
                    CenterCrop(), RoundedCorners(20)
                )
            )
            .into(binding.Poster)

        binding.Link.setOnClickListener {
            val url = binding.Link.text
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url.toString())
            startActivity(intent)

        }
        binding.button.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${binding.Title.text}: ${binding.Link.text}")
                type = "text/plain"
            }

            startActivity(Intent.createChooser(shareIntent, "Share Movie"))
        }
        return view

    }



}

