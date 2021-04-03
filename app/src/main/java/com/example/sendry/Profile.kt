package com.example.sendry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_sign_in.*

class Profile : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference?=null
    var database: FirebaseDatabase?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        auth= FirebaseAuth.getInstance()
        database= FirebaseDatabase.getInstance()
        databaseReference= database?.reference!!.child("profile")

        loadProfile()

    }

    private fun loadProfile(){
        val user=auth.currentUser
      val userReference=  databaseReference?.child(user?.uid!!)
userReference?.addValueEventListener(object:ValueEventListener {


    override fun onCancelled(error: DatabaseError) {

    }

    override fun onDataChange(snapshot: DataSnapshot) {

    }


})

    }}
