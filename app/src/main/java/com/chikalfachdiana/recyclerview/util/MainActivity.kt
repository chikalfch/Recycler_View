package com.chikalfachdiana.recyclerview.util

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.chikalfachdiana.recyclerview.R
import com.chikalfachdiana.recyclerview.databinding.ActivityMainBinding
import com.chikalfachdiana.recyclerview.model.Gadget
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayListGadget()
    }
    @SuppressLint
    private fun displayListGadget() {
        val listGadget = ArrayList<Gadget>()
        val images = resources.obtainTypedArray(R.array.gadget_images)
        val name = resources.getStringArray(R.array.gadget_name)

        for(place in name.indices) {
            listGadget.add(
                Gadget(
                    gadgetName = name[place],
                    gadgetimages = images.getResourceId(place,-1)
                )
            )
        }
        binding.rvListData.apply {
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter = Adapter(listGadget)
            setHasFixedSize(true)
        }
    }
}