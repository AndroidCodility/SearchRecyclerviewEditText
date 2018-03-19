package com.codility.searchedittext

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.codility.recyclerview.MyAdapter
import com.codility.recyclerview.User
import com.codility.searchedittext.app.OnClickListener
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Govind on 3/19/2018.
 */
class MainActivity : AppCompatActivity() {

    private var myAdapter: MyAdapter? = null
    private var users = ArrayList<User>()

    private val listener = object : OnClickListener {
        override fun onClickEvent(user: User) {
            Toast.makeText(applicationContext, user.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Display UserList
        getUserList()

        //adding a TextChangedListener to call a method whenever there is some change on the EditText
        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun afterTextChanged(editable: Editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString())
            }
        })
    }

    private fun getUserList() {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        users = User.getUserList()
        myAdapter = MyAdapter(users)
        myAdapter!!.setListener(listener)
        recyclerView.adapter = myAdapter
    }

    private fun filter(text: String) {
        //new array list that will hold the filtered data
        val filteredNames = ArrayList<User>()
        //looping through existing elements and adding the element to filtered list
        users.filterTo(filteredNames) {
            //if the existing elements contains the search input
            it.name.toLowerCase().contains(text.toLowerCase())
        }
        //calling a method of the adapter class and passing the filtered list
        myAdapter!!.filterList(filteredNames)
    }
}