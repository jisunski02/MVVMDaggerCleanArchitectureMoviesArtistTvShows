package com.jisunski.moviesmvvm.presentation.movie

import android.annotation.SuppressLint
import android.opengl.Visibility
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
import com.jisunski.moviesmvvm.databinding.ActivityMovieBinding
import com.jisunski.moviesmvvm.presentation.dependencyinjection.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel= ViewModelProvider(this,factory)[MovieViewModel::class.java]

        initRecyclerview()

    }

    private fun initRecyclerview(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter

        displayPopularMovies()

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayPopularMovies(){
        binding.movieProgressbar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if(it != null){
                Log.i("Mytag", it.toString())
                binding.movieProgressbar.visibility = View.GONE
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }

            else{
                binding.movieProgressbar.visibility = View.GONE
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
        binding.movieProgressbar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer {
            if(it != null){
                Log.i("Mytag", it.toString())
                binding.movieProgressbar.visibility = View.GONE
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }

            else{
                binding.movieProgressbar.visibility = View.GONE
            }
        })
    }
}