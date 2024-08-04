package com.example.firstclass

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.firstclass.api.Cats
import com.example.firstclass.api.CatsApiClient
import com.example.firstclass.databinding.ActivityMainBinding
import com.example.firstclass.databinding.AlertdialogViewBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.click.setOnClickListener {
            startActivity(Intent(this,ItemViewActivity::class.java).apply {
                putExtra("item_name","fruits")
            })
        }
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar.toolbar)
        binding.progressbar.visibility = View.VISIBLE

//        binding.rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
//
//        val adapter = ItemAdapter(lists)
//        adapter.setItemClick(object : ItemClick{
//            override fun Click(text: String) {
//                // Toast.makeText(this@MainActivity,"check "+ text,Toast.LENGTH_SHORT).show()
//                binding.selectedItem.text = text
//            }
//        })
        //binding.recyclerView.adapter = adapter
//        Log.d("persons",Gson().toJson(lists))
//        var list = Gson().fromJson(Gson().toJson(lists), Array<PersonItem>::class.java).asList()
//        binding.recyclerView.adapter = ItemAdapter(lists,object :ItemClick{
//            override fun Click(text: String) {
//                binding.selectedItem.text = text
//                startActivity(Intent(this@MainActivity,ItemViewActivity::class.java).apply {
//                    putExtra(ItemViewActivity.ITEM_NAME,text)
//                })
//
//            }
//        })
//        binding.recyclerView.adapter = ItemAdapter(lists).apply {
//            //this.setItemClick(object :)
//        }

//        binding.selectedItem.text = "banana"

//        binding.let { b ->
//            b.selectedItem
//        }

//        binding.apply {
//            recyclerView.adapter
//            click
//            selectedItem
//        }

//        CatsApiClient().getCatsApiService().getCats().enqueue(object :Callback<ResponseBody>{
//            override fun onResponse(p0: Call<ResponseBody>, p1: Response<ResponseBody>) {
//                Log.d("Success",p1.toString())
//            }
//
//            override fun onFailure(p0: Call<ResponseBody>, p1: Throwable) {
//                Log.d("Failure",p1.stackTrace.toString())
//            }
//
//        })

        CatsApiClient().getCatsApiService().getCats().enqueue(object:Callback<List<Cats>>{
            override fun onResponse(p0: Call<List<Cats>>, p1: Response<List<Cats>>) {
                binding.progressbar.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
                binding.recyclerView.adapter = ItemAdapter(p1.body()!!)
//               Log.d("cat name" ,p1.body()?.get(0)?.name.toString())
                // list populate/

            }

            override fun onFailure(p0: Call<List<Cats>>, p1: Throwable) {
                //TODO("Not yet implemented")
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.options_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.account -> {
                Toast.makeText(this,"account menu", Toast.LENGTH_SHORT).show()
            }

            R.id.setttings -> {
                Toast.makeText(this,"settings menu", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    fun showAlertDialog(){
        val dialogBuilder = AlertDialog.Builder(this)
        val alertbinding = AlertdialogViewBinding.inflate(LayoutInflater.from(this))
        dialogBuilder.setTitle("Alert with custom view")
        dialogBuilder.setView(alertbinding.root)
        dialogBuilder.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(this@MainActivity,"yes",Toast.LENGTH_SHORT).show()
            }
        })
        dialogBuilder.setNegativeButton("No"){ dialogInterface: DialogInterface, i: Int ->
            dialogInterface.dismiss()
        }
        val  alertdialog = dialogBuilder.create()
//        alertdialog.setTitle("Dialog")
//        alertdialog.setIcon(R.drawable.image_apple)
        alertdialog.show()
    }
}


class MyClick:ItemClick{
    override fun Click(text: String) {
        TODO("Not yet implemented")
    }

}


/// Toolbar
/// AlertDialog
/// Sliding Navigation Panel
//