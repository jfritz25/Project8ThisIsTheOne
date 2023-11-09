package com.example.project8

import androidx.recyclerview.widget.DiffUtil
import com.example.project8.model.OMDBMovie

class MovieDiffItemCallback : DiffUtil.ItemCallback<OMDBMovie>() {
    /**
     * Checks if the items represented by the OMDBMovie objects have the same identifier.
     *
     * @param oldItem The old OMDBMovie object.
     * @param newItem The new OMDBMovie object.
     * @return True if the items have the same identifier, false otherwise.
     */
    override fun areItemsTheSame(oldItem: OMDBMovie, newItem: OMDBMovie)
            = (oldItem.imdbID == newItem.imdbID)



    /**
     * Checks if the content of the items represented by the OMDBMovie objects are the same.
     *
     * @param oldItem The old OMDBMovie object.
     * @param newItem The new OMDBMovie object.
     * @return True if the content of the items is the same, false otherwise.
     */
    override fun areContentsTheSame(oldItem: OMDBMovie, newItem: OMDBMovie) =
        (oldItem == newItem)
    }