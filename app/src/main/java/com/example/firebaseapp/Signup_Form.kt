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

class Signup_Form : AppCompatActivity() {
    var txtEmail: EditText? = null
    var txtPassword: EditText? = null
    var txtConfirmPassword: EditText? = null
    var btn_register: Button? = null
    private var firebaseAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_form)
        supportActionBar!!.title = "SignUp Form"
        txtEmail = findViewById<View>(R.id.txt_Email) as EditText
        txtPassword = findViewById<View>(R.id.txt_password) as EditText
        txtConfirmPassword = findViewById<View>(R.id.txt_confirm_password) as EditText
        btn_register = findViewById<View>(R.id.buttonRegister) as Button
        firebaseAuth = FirebaseAuth.getInstance()
        btn_register!!.setOnClickListener(View.OnClickListener {
            val email = txtEmail!!.text.toString().trim { it <= ' ' }
            val password = txtPassword!!.text.toString().trim { it <= ' ' }
            val confirmPassword = txtConfirmPassword!!.text.toString().trim { it <= ' ' }
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this@Signup_Form, "Please Enter Email", Toast.LENGTH_SHORT)
                return@OnClickListener
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this@Signup_Form, "Please Enter Password", Toast.LENGTH_SHORT)
                return@OnClickListener
            }
            if (TextUtils.isEmpty(confirmPassword)) {
                Toast.makeText(this@Signup_Form, "Please Enter Confirm Password", Toast.LENGTH_SHORT)
                return@OnClickListener
            }
            if (password.length < 6) {
                Toast.makeText(this@Signup_Form, "Password too short", Toast.LENGTH_SHORT)
            }
            if (password == confirmPassword) {
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this@Signup_Form, object : OnCompleteListener<AuthResult?>() {
                            fun onComplete(task: Task<AuthResult?>) {
                                if (task.isSuccessful()) {
                                    startActivity(Intent(applicationContext, MainActivity::class.java))
                                    Toast.makeText(this@Signup_Form, "Registration Complete", Toast.LENGTH_SHORT)
                                } else {
                                    Toast.makeText(this@Signup_Form, "Authentication Failed", Toast.LENGTH_SHORT)
                                }

                                // ...
                            }
                        })
            }
        })
    }
}
