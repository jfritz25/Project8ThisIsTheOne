import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.project8.model.OMDBMovie
import com.example.project8.databinding.RvLayoutBinding
import com.example.project8.MovieDiffItemCallback

class MovieListAdapter (val context: Context, val clickListener: (movie: OMDBMovie) -> Unit)
    : ListAdapter<OMDBMovie, MovieListAdapter.MovieItemViewHolder>(MovieDiffItemCallback()) {

    /**
     * Adapter class for displaying a list of OMDBMovie objects in a RecyclerView.
     *
     * @param context       The context in which the adapter is created.
     * @param clickListener A lambda function that defines the click behavior for each item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            /**
             * Inflates the layout for each item view and creates a new instance of MovieItemViewHolder.
             *
             * @param parent   The ViewGroup into which the new ViewHolder will be added.
             * @param viewType The type of the new View.
             * @return A new instance of MovieItemViewHolder.
             */
            : MovieItemViewHolder = MovieItemViewHolder.inflateFrom(parent)
    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        /**
         * Binds the data at the specified position to the ViewHolder.
         *
         * @param holder   The ViewHolder which should be updated to represent the contents of the item at the given position.
         * @param position The position of the item within the adapter's data set.
         */
        val item = getItem(position)
        holder.bind(context, item, clickListener)
    }


    class MovieItemViewHolder(val binding: RvLayoutBinding)
        : RecyclerView.ViewHolder(binding.root) {


        companion object {
            /**
             * Inflates the layout for the ViewHolder from the provided parent ViewGroup.
             *
             * @param parent The ViewGroup into which the new ViewHolder will be added.
             * @return A new instance of MovieItemViewHolder.
             */
            // inflates the values from the NoteItem's viewholder
            fun inflateFrom(parent: ViewGroup): MovieItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RvLayoutBinding.inflate(layoutInflater, parent, false)
                return MovieItemViewHolder(binding)
            }
        }


        // binds the values together
        @SuppressLint("SetTextI18n")
        fun bind(context: Context, item: OMDBMovie, clickListener: (movie: OMDBMovie) -> Unit) {
            /**
             * Binds the data and click listener to the ViewHolder.
             *
             * @param context       The context in which the ViewHolder is bound.
             * @param item          The OMDBMovie object to bind.
             * @param clickListener The lambda function defining the click behavior.
             */
            binding.movie = item
            loadPoster(context, item, binding)
            binding.Link.text = "https://www.imdb.com/title/${item.imdbID}/"
            binding.root.setOnClickListener { clickListener(item) }
            binding.executePendingBindings()
        }
        private fun loadPoster(context:Context, movie: OMDBMovie, binding: RvLayoutBinding) {
            /**
             * Loads the movie poster image using Glide library with rounded corners.
             *
             * @param context The context in which the image is loaded.
             * @param movie   The OMDBMovie object containing the poster URL.
             * @param binding The ViewDataBinding associated with the item view.
             */
            Glide.with(context)
                .load(movie.posterString)
                .apply(
                    RequestOptions().transform(
                        CenterCrop(), RoundedCorners(20)
                    )
                )
                .into(binding.Poster)
        }
    }
}