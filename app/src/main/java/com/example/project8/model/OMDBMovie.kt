package com.example.project8.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class OMDBMovie(
    /**
    * Represents a movie object retrieved from the OMDB (Open Movie Database) API.
    * This class implements the Parcelable interface for easy serialization and deserialization.
    *
    * @param genre       The genre of the movie.
    * @param imdbRating  The IMDb rating of the movie.
    * @param rating      The rating of the movie.
    * @param year        The release year of the movie.
    * @param title       The title of the movie.
    * @param runtime     The duration of the movie.
    * @param posterString The URL string of the movie poster.
    * @param imdbID      The IMDb ID of the movie.
    */
    @SerializedName("Genre") val genre: String?,
    @SerializedName("imdbRating") val imdbRating: String?,
    @SerializedName("Rated") val rating: String?,
    @SerializedName("Year") val year: String?,
    @SerializedName("Title") val title: String?,
    @SerializedName("Runtime") val runtime: String?,
    @SerializedName("Poster") val posterString: String?,
    @SerializedName("imdbID") val imdbID: String?,

    ): Parcelable {

    constructor(parcel: Parcel) : this(
        /**
         * Constructor used for parceling. Reads values from the parcel and assigns them to the movie object.
         */
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        /**
         * Writes the object values to a parcel for serialization.
         */
        parcel.writeString(genre)
        parcel.writeString(imdbRating)
        parcel.writeString(rating)
        parcel.writeString(year)
        parcel.writeString(title)
        parcel.writeString(runtime)
        parcel.writeString(posterString)
        parcel.writeString(imdbID)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OMDBMovie> {
        /**
         * Creator for Parcelable implementation.
         */
        override fun createFromParcel(parcel: Parcel): OMDBMovie {
            return OMDBMovie(parcel)
        }

        override fun newArray(size: Int): Array<OMDBMovie?> {
            return arrayOfNulls(size)
        }
    }
}