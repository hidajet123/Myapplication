package com.example.myapplication.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.listusers.CheckPasswordPresenter
import com.example.myapplication.listusers.ListUsers

class HomeActivity : AppCompatActivity(), HomePresenter.View, CheckPasswordPresenter.View {

    private lateinit var presenter: HomePresenter;
    private lateinit var presenterCheckPasssword: CheckPasswordPresenter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init();
    }

    fun init() {
        presenter = HomePresenter(this)
        val button: Button = findViewById(R.id.login)
        button.setOnClickListener {
            val email: TextView = findViewById(R.id.email)
            val password: TextView = findViewById(R.id.password)
            presenter.checkEmailPassword(email.text.toString(), password.text.toString(), this);
        }
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun nextPage() {
        val intent =Intent(this, ListUsers::class.java)
        startActivity(intent)
    }

    override fun showPasswordError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun callHomePresenter(pass1: String, email1: String, context1: Context) {
    }

}