package com.example.myapplication.aboutuser

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.network.request.User
import loadFromUrl

class UserActivity : AppCompatActivity(), UserPresenter.View {

    private lateinit var presenter: UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        init()
    }

    fun init() {
        presenter = UserPresenter(this)
        val intent: Intent = getIntent();
        val ID = intent.getIntExtra("id", 0)
        presenter.aboutUser(ID)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()

    }

    override fun showUserInfo(
        user: User?
    ) {
        Log.d("Name: ", user?.first_name.toString())
        val img: ImageView = findViewById(R.id.info_img)
        val name: TextView = findViewById(R.id.info_name)
        val surname: TextView = findViewById(R.id.info_surname)
        val id: TextView = findViewById(R.id.info_id)
        val email: TextView = findViewById(R.id.info_email)

        img.loadFromUrl(user?.avatar)
        id.text = user?.id.toString()
        name.text = user?.first_name.toString()
        surname.text = user?.last_name.toString()
        email.text = user?.email.toString()
        email.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                data = Uri.parse("mailto:")
                type = "text/plain"
                Log.d("Email: ", user?.email.toString())
                putExtra(Intent.EXTRA_EMAIL, arrayOf(user?.email.toString()))
                putExtra(Intent.EXTRA_SUBJECT, "Send email from MyApp")
                putExtra(Intent.EXTRA_TEXT, "Hello")
            }
            startActivity(Intent.createChooser(shareIntent, "Posalji"));

        }
    }
}