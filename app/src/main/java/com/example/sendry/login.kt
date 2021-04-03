package com.example.sendry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.button
import kotlinx.android.synthetic.main.activity_sign_in.*

lateinit var auth: FirebaseAuth
class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

auth= FirebaseAuth.getInstance()
        login()
    }

public fun login(){

    button.setOnClickListener{

        if(TextUtils.isEmpty(idemaill.text.toString())){
            idemaill.setError("Mandatory Feild")}
        else if(TextUtils.isEmpty(idpasswordd.text.toString())){
            idpasswordd.setError("Mandatory Feild")}

        auth.signInWithEmailAndPassword(idemaill.text.toString(),idpasswordd.text.toString())
            .addOnCompleteListener{
                if(it.isSuccessful){
                startActivity(Intent(this,Home::class.java))
                    finish()
                }
                else{
                    Toast.makeText(this,"login failed",Toast.LENGTH_SHORT).show()
                }
            }
    }
}

    fun registerText(view: View) {
        startActivity(Intent(this,SignIn::class.java))
        finish()

    }


}