package com.hcunsal.storingdata

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

    lateinit var sharedPreferences : SharedPreferences
    var numberData : Int? = null
    var savedNumber : String? = null

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("com.hcunsal.storingdata", MODE_PRIVATE)
        numberData = sharedPreferences.getInt("number", -1)

        if(numberData != -1){
            numberText.text = "NUMBER: $numberData"
        }else{
            numberText.text = "NUMBER: "
        }

        Toast.makeText(applicationContext, "Welcome", Toast.LENGTH_LONG).show()
    }


    fun save(view : View){
        var number = numberEdit.text.toString().toIntOrNull()

        val alert = AlertDialog.Builder(this)
        alert.setTitle("Save?")
        alert.setMessage("Are you sure?")

        alert.setPositiveButton("YES") {dialog, which ->
            if(number != null){
                numberText.text = "NUMBER: $number"
                sharedPreferences.edit().putInt("number", number).apply()
                Toast.makeText(applicationContext, "Saved", Toast.LENGTH_LONG).show()
                savedNumber = numberEdit.text.toString()
                numberEdit.text.clear()
            }
        }

        alert.setNegativeButton("NO") {dialog, which ->
            Toast.makeText(applicationContext, "Not Saved", Toast.LENGTH_LONG).show()
        }

        alert.show()

    }

    fun delete(view: View){
        numberData = sharedPreferences.getInt("number", -1)

        val alert = AlertDialog.Builder(this)
        alert.setTitle("Delete?")
        alert.setMessage("Are you sure?")

        alert.setPositiveButton("YES") {dialog, which ->
            if (numberData != -1){
                numberText.text = "NUMBER: "
                sharedPreferences.edit().remove("number").apply()
                Toast.makeText(applicationContext, "Deleted", Toast.LENGTH_LONG).show()
                numberEdit.text.clear()
            }
        }

        alert.setNegativeButton("NO") {dialog, which ->
            Toast.makeText(applicationContext, "Not Deleted", Toast.LENGTH_LONG).show()
        }
        alert.show()

    }

    fun nextPage(view: View){
        // val number = numberEdit.toString()
        val intent = Intent(applicationContext, TimerActivity :: class.java)
        intent.putExtra("number", savedNumber)
        startActivity(intent)
    }

}