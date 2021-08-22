package com.peculiaruc.wineshop.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.api.Api.retrofitService
import com.peculiaruc.wineshop.dataSource.Repository

class LogInActivity : AppCompatActivity() {

    private lateinit var wineRepository: Repository
    private lateinit var emailsI: TextInputEditText
    private lateinit var passwordsI: TextInputEditText
    private lateinit var btnlogIN: MaterialButton
    private lateinit var textSignuP: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)


        login()
    }

    private fun login() {

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        wineRepository = Repository(retrofitService, this)

        btnlogIN = findViewById(R.id.btn_logIn)
        emailsI = findViewById(R.id.editText_loginemail)
        passwordsI = findViewById(R.id.editText_loginpassWord)
        textSignuP = findViewById(R.id.textView_signUp_text)

        title = "Login"

        textSignuP.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        btnlogIN.setOnClickListener {
            if (emailsI.text.isNullOrBlank() || passwordsI.text.isNullOrBlank()){
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            }
            else{
                val isValid: Boolean = wineRepository.isValidUser(emailsI.text.toString().trim(), passwordsI.text.toString().trim()) == true
                if (isValid) {
                    Toast.makeText(baseContext, "Welcome to Wine Shop, what can we offer you?", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(baseContext, "Check if you have an account", Toast.LENGTH_LONG).show()

                    val intent = Intent(this, SignUpActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

}