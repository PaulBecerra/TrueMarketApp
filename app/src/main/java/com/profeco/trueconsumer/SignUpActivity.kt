package com.profeco.trueconsumer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = Firebase.auth

        val btnEmail: Button = findViewById(R.id.btnSignInWithEmail)
        btnEmail.setOnClickListener{
            val emailEditText: EditText = findViewById(R.id.editTextEmailSignUp)
            val passEditText: EditText = findViewById(R.id.editTextPassSignup)
            val passConfirmEditText: EditText = findViewById(R.id.editTextConfirmPass)

            val email = emailEditText.text.toString()
            val pass = passEditText.text.toString()
            val passConfirm = passConfirmEditText.text.toString()

            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(baseContext, "Email is not valid",
                    Toast.LENGTH_SHORT).show()
            } else if (pass.isEmpty()) {
                Toast.makeText(baseContext, "Password is not valid",
                    Toast.LENGTH_SHORT).show()
            } else if (pass != passConfirm){
                Toast.makeText(baseContext, "Passwords are not equals",
                    Toast.LENGTH_SHORT).show()
            } else {
                createAccount(email, pass)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun createAccount(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "createUserWithEmail:success")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}