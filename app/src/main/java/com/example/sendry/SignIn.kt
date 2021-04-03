package com.example.sendry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.button
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference?=null
    var database:FirebaseDatabase?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        auth= FirebaseAuth.getInstance()
        database= FirebaseDatabase.getInstance()
databaseReference= database?.reference!!.child("profile")

        register()
    }


    private fun register(){
        button.setOnClickListener{
if(TextUtils.isEmpty(idfirstname.text.toString())){
    idfirstname.setError("Mandatory Feild") }
            else if(TextUtils.isEmpty(idLastname.text.toString())){
    idLastname.setError("Mandatory Feild")}
else if(TextUtils.isEmpty(idemail.text.toString())){
    idemail.setError("Mandatory Feild")}
else if(TextUtils.isEmpty(idpassword.text.toString())){
    idpassword.setError("Mandatory Feild")}
            auth.createUserWithEmailAndPassword(idemail.text.toString(),idpassword.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful){
val currentUser= auth.currentUser
                        val currentUserDb=databaseReference?.child((currentUser.uid!!))
                        currentUserDb?.child("firstname")?.setValue(idfirstname.text.toString())
                        currentUserDb?.child("lastname")?.setValue(idLastname.text.toString())
                        currentUserDb?.child("email")?.setValue(idemail.text.toString())
                        currentUserDb?.child("password")?.setValue(idpassword.text.toString())
                        Toast.makeText(this,"Registration successfull",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,Home::class.java))
                       finish()
                    }
                    else{
                       Toast.makeText(this,"Registration Failed",Toast.LENGTH_SHORT).show()
                    }
                }
                }



        }
    }
