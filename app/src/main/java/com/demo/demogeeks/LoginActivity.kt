package com.demo.demogeeks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var edtEmail: EditText;
    lateinit var edtPass: EditText;
    lateinit var SignIn: Button;

    lateinit var strEmail: String
    lateinit var strPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initUi()
        inputData()
    }

    private fun initUi() {
        edtEmail = findViewById(R.id.edtEmail)
        edtPass = findViewById(R.id.edtPass)
        SignIn = findViewById(R.id.SignIn)
    }

    private fun inputData() {
//        println(strEmail)
        SignIn.setOnClickListener() {
            strEmail = edtEmail.text.toString()
            strPassword = edtPass.text.toString()
            if (!checkCondition()) {
                Toast.makeText(this, strEmail + " " + strPassword, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkCondition():Boolean{
        if(strEmail.length<5){
            edtEmail.error = getString(R.string.invalid_email)
            return false
        }
        else{
            return true
        }
    }
}