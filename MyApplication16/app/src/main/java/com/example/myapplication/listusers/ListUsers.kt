package com.example.myapplication.listusers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication.R
import com.example.myapplication.UserCallback
import com.example.myapplication.UsersListItem
import com.example.myapplication.aboutuser.UserActivity
import com.example.myapplication.database.UserAppDatabase
import com.example.myapplication.database.UserDao
import com.example.myapplication.database.UserDataBase
import com.example.myapplication.network.Users
import com.example.myapplication.network.request.User

class ListUsers : AppCompatActivity(), ListUsersPresenter.View, UserCallback {
    private lateinit var db: UserDao
    private lateinit var recyclerView: RecyclerView;
    private lateinit var presenter: ListUsersPresenter
    private val adapter = ListUsersActivityAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users)
        Set()
        init()
    }

    fun Set() {
        recyclerView = findViewById(R.id.recyclerViewUsers);
        recyclerView.adapter = adapter
    }

    fun init() {
        presenter = ListUsersPresenter(this)
        presenter.users()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()

    }

    override fun showUsers(list: List<Users>) {
        /*db = UserAppDatabase.getInstance(application).userDao
        for (i in 0..list.size) {

            val user = UserDataBase(
                list[i].id,
                list[i].first_name,
                list[i].last_name,
                list[i].email,
                list[i].avatar
            )
            db.insert(user)
        }*/
        if (list != null) {
            val listItem = UsersListItem(list, this)
            adapter.addItem(listItem)
        }
    }

    override fun onUserClick(users: Users) {
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra("id", users.id)
        startActivity(intent)
    }

}