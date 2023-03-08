package com.jisunski.moviesmvvm.presentation.artist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jisunski.moviesmvvm.R
import com.jisunski.moviesmvvm.databinding.ActivityArtistBinding
import com.jisunski.moviesmvvm.presentation.dependencyinjection.Injector
import com.jisunski.moviesmvvm.presentation.tvshow.TvShowAdapter
import com.jisunski.moviesmvvm.presentation.tvshow.TvShowViewModel
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistBinding
    private lateinit var adapter: ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistViewModel= ViewModelProvider(this,factory)[ArtistViewModel::class.java]

        initRecyclerview()
    }

    private fun initRecyclerview(){
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter

        displayPopularMovies()

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayPopularMovies(){
        binding.artistProgressbar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this, Observer {
            if(it != null){
                Log.i("Mytag", it.toString())
                binding.artistProgressbar.visibility = View.GONE
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }

            else{
                binding.artistProgressbar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Movies Found", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateMovies(){
        binding.artistProgressbar.visibility = View.VISIBLE
        val response = artistViewModel.updateArtists()
        response.observe(this, Observer {
            if(it != null){
                Log.i("Mytag", it.toString())
                binding.artistProgressbar.visibility = View.GONE
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }

            else{
                binding.artistProgressbar.visibility = View.GONE
            }
        })
    }
}