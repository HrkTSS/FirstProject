package com.example.newdemoapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.newdemoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        launchUI()
    }

    private fun launchUI() {
        binding.btn.setOnClickListener {setUserData()}
    }

    private fun getName() = binding.etName.text.toString().trim()
    private fun toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    private fun getUserData(): UserData {
        val options = mutableListOf<String>()
        if (binding.cbOne.isChecked) options.add(binding.cbOne.text.toString())
        if (binding.cbOne.isChecked) options.add(binding.cbTwo.text.toString())
        return UserData(getName(), options)
    }

    private fun setUserData(){
        val user = getUserData()
        binding.tvName.text = user.name
        if (user.option.isNotEmpty()) toast(user.option.toString())
    }
}