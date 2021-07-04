package com.peculiaruc.wineshop.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.api.Api.retrofitService
import com.peculiaruc.wineshop.dataSource.Repository
import com.peculiaruc.wineshop.dataSource.local.db.UserEntity

class SignUpActivity : AppCompatActivity() {

    private lateinit var textlogIn: TextView
    private lateinit var emailsp: TextInputEditText
    private lateinit var passwordsp: TextInputEditText
    private lateinit var btnSignUp: MaterialButton
    private lateinit var logIn: MaterialButton
    private var wineRepository: Repository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        init()

    }

    private fun init() {

        title = "SignUp"
        wineRepository = Repository(retrofitService, this)
        btnSignUp = findViewById(R.id.btn_signup)
        emailsp = findViewById(R.id.editText_signUp_email)
        passwordsp = findViewById(R.id.editText_signUp_password)
        textlogIn = findViewById(R.id.textView_logib_text)

        textlogIn.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        btnSignUp.setOnClickListener {

            val userAccount = UserEntity(
                0,
                email = emailsp.text.toString(),
                password = passwordsp.text.toString()
            )
            if (emailsp.text.isNullOrBlank() || passwordsp.text.isNullOrBlank()) {
                Toast.makeText(this, "All field are required", Toast.LENGTH_LONG).show()
            } else if (!validEmail(emailsp)) {
                Toast.makeText(this, "Here must be filled with email", Toast.LENGTH_LONG).show()
            } else if (wineRepository?.isExisting(userAccount.email) == true) {
                Toast.makeText(this, "Email exsist, sign in", Toast.LENGTH_LONG).show()
            } else {


                wineRepository?.insertUser(userAccount)
                Toast.makeText(this, "You have successfuly created an account", Toast.LENGTH_LONG)
                    .show()
                val intent = Intent(this, LogInActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validEmail(email: EditText): Boolean {
        val emailTextInput: String = email.text.toString().trim()
        return emailTextInput.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailTextInput)
            .matches()

    }

}