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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : MovieItemViewHolder = MovieItemViewHolder.inflateFrom(parent)
    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(context, item, clickListener)
    }


    class MovieItemViewHolder(val binding: RvLayoutBinding)
        : RecyclerView.ViewHolder(binding.root) {

        companion object {
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
            binding.movie = item
            loadPoster(context, item, binding)
            binding.Link.text = "https://www.imdb.com/title/${item.imdbID}/"
            binding.root.setOnClickListener { clickListener(item) }
            binding.executePendingBindings()
        }
        private fun loadPoster(context:Context, movie: OMDBMovie, binding: RvLayoutBinding) {
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