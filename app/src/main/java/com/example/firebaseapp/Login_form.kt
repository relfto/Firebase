package com.example.firebaseapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class Login_form : AppCompatActivity() {
    var txtEmail: EditText? = null
    var txtPassword: EditText? = null
    var btn_login: Button? = null
    private var firebaseAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_form)
        supportActionBar!!.title = "Login Form"
        txtEmail = findViewById<View>(R.id.txt_Email) as EditText
        txtPassword = findViewById<View>(R.id.txt_password) as EditText
        btn_login = findViewById<View>(R.id.buttonLogin) as Button
        firebaseAuth = FirebaseAuth.getInstance()
        btn_login!!.setOnClickListener(View.OnClickListener {
            val email = txtEmail!!.text.toString().trim { it <= ' ' }
            val password = txtPassword!!.text.toString().trim { it <= ' ' }
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this@Login_form, "Please Enter Email", Toast.LENGTH_SHORT)
                return@OnClickListener
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this@Login_form, "Please Enter Password", Toast.LENGTH_SHORT)
                return@OnClickListener
            }
            if (password.length < 6) {
                Toast.makeText(this@Login_form, "Password too short", Toast.LENGTH_SHORT)
            }
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this@Login_form, object : OnCompleteListener<AuthResult?>() {
                        fun onComplete(task: Task<AuthResult?>) {
                            if (task.isSuccessful()) {
                                startActivity(Intent(applicationContext, MainActivity::class.java))
                            } else {
                                Toast.makeText(this@Login_form, "Login Failed", Toast.LENGTH_SHORT)
                            }

                            // ...
                        }
                    })
        })
    }

    fun btu_Sign(view: View?) {
        startActivity(Intent(applicationContext, Signup_Form::class.java))
    }
}
