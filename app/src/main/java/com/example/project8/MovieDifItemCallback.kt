package com.example.project8

import androidx.recyclerview.widget.DiffUtil
import com.example.project8.model.OMDBMovie

class MovieDiffItemCallback : DiffUtil.ItemCallback<OMDBMovie>() {
    override fun areItemsTheSame(oldItem: OMDBMovie, newItem: OMDBMovie)
            = (oldItem.imdbID == newItem.imdbID)

    override fun areContentsTheSame(oldItem: OMDBMovie, newItem: OMDBMovie) =
        (oldItem == newItem)
    }