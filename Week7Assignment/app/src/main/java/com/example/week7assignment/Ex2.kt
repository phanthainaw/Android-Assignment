package com.example.week7assignment

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.week7assignment.ui.theme.Week7AssignmentTheme
import kotlin.math.sqrt

//

class Ex2 : ComponentActivity(), View.OnClickListener {

    private lateinit var radioGroup: RadioGroup
    private lateinit var  editText: EditText
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ex2)

        editText = findViewById<EditText>(R.id.input)
        radioGroup = findViewById<RadioGroup>(R.id.RadioGroup)
        listView = findViewById<ListView>(R.id.listView)
        val ShowButton = findViewById<Button>(R.id.ShowButton)
        ShowButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        var n = editText.text.toString().toInt()
        var data = mutableListOf<Int>()
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        if (selectedRadioButtonId == R.id.SoLe){
            for (i in 0..n){
                if (i%2==1){
                    data.add(i)
                }
            }
        }
        if (selectedRadioButtonId == R.id.SoChan){
            for (i in 0..n){
                if (i%2==0){
                    data.add(i)
                }
            }
        }
        if (selectedRadioButtonId == R.id.SoChinhPhuong){
            for (i in 0 .. sqrt(n.toDouble()).toInt()){
                data.add(i*i)
            }
        }

        val adapter = ArrayAdapter(
            this, // Context
            android.R.layout.simple_list_item_1, // Layout for each item
            data // Data source
        )
        listView.adapter = adapter
    }
}
