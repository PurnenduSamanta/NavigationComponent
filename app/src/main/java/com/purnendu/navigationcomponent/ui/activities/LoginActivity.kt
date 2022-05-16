package com.purnendu.navigationcomponent.ui.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.purnendu.navigationcomponent.R

class LoginActivity : AppCompatActivity() {

    private lateinit var signIn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signIn=findViewById(R.id.signIn)
        signIn.setOnClickListener {
            val preference = this.getSharedPreferences("loggedInStatus", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = preference.edit()
            editor.putBoolean("status",true)
            if(editor.commit())
            {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
    }
}