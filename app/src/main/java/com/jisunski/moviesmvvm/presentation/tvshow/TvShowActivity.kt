package com.jisunski.moviesmvvm.presentation.tvshow

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jisunski.moviesmvvm.R
import com.jisunski.moviesmvvm.databinding.ActivityTvShowBinding
import com.jisunski.moviesmvvm.presentation.dependencyinjection.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var adapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel= ViewModelProvider(this,factory)[TvShowViewModel::class.java]

        initRecyclerview()
    }

    private fun initRecyclerview(){
        binding.tvshowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvshowRecyclerView.adapter = adapter

        displayPopularMovies()

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayPopularMovies(){
        binding.tvshowProgressbar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if(it != null){
                Log.i("Mytag", it.toString())
                binding.tvshowProgressbar.visibility = View.GONE
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }

            else{
                binding.tvshowProgressbar.visibility = View.GONE
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
        binding.tvshowProgressbar.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvShows()
        response.observe(this, Observer {
            if(it != null){
                Log.i("Mytag", it.toString())
                binding.tvshowProgressbar.visibility = View.GONE
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }

            else{
                binding.tvshowProgressbar.visibility = View.GONE
            }
        })
    }
}