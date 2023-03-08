package com.jisunski.moviesmvvm.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jisunski.moviesmvvm.R
import com.jisunski.moviesmvvm.databinding.ActivityHomeBinding
import com.jisunski.moviesmvvm.presentation.artist.ArtistActivity
import com.jisunski.moviesmvvm.presentation.movie.MovieActivity
import com.jisunski.moviesmvvm.presentation.movie.MovieViewModel
import com.jisunski.moviesmvvm.presentation.movie.MovieViewModelFactory
import com.jisunski.moviesmvvm.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.btnArtists.setOnClickListener {
            openActivity(ArtistActivity::class.java)
        }

        binding.btnMovies.setOnClickListener {
            openActivity(MovieActivity::class.java)
        }

        binding.btnTvShows.setOnClickListener {
            openActivity(TvShowActivity::class.java)
        }

    }

    fun <T> Context.openActivity(it: Class<T>){
        val intent = Intent(this, it)
        startActivity(intent)
    }
}