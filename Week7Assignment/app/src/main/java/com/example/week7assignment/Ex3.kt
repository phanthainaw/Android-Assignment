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
import androidx.recyclerview.widget.RecyclerView
import com.example.week7assignment.ui.theme.Week7AssignmentTheme
import kotlin.math.sqrt

//

class MainActivity : ComponentActivity(), View.OnClickListener {

    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ex3)

        editText = findViewById<EditText>(R.id.input)
        val studentList = findViewById<RecyclerView>(R.id.DSSV)


    }

    override fun onClick(p0: View?) {
    }
}