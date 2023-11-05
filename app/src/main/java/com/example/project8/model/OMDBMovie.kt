package com.example.project8.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class OMDBMovie(
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
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
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
        override fun createFromParcel(parcel: Parcel): OMDBMovie {
            return OMDBMovie(parcel)
        }

        override fun newArray(size: Int): Array<OMDBMovie?> {
            return arrayOfNulls(size)
        }
    }
}