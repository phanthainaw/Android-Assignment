package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
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
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity(), View.OnClickListener{

        private lateinit var screen: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)
        val button0= findViewById<Button>(R.id.button_0)
        val button1= findViewById<Button>(R.id.button_1)
        val button2= findViewById<Button>(R.id.button_2)
        val button3= findViewById<Button>(R.id.button_3)
        val button4= findViewById<Button>(R.id.button_4)
        val button5= findViewById<Button>(R.id.button_5)
        val button6= findViewById<Button>(R.id.button_6)
        val button7= findViewById<Button>(R.id.button_7)
        val button8= findViewById<Button>(R.id.button_8)
        val button9= findViewById<Button>(R.id.button_9)
        val buttonCE= findViewById<Button>(R.id.button_CE)
        val buttonC= findViewById<Button>(R.id.button_C)
        val buttonBS= findViewById<Button>(R.id.button_BS)
        val buttonDivide= findViewById<Button>(R.id.button_divide)
        val buttonX= findViewById<Button>(R.id.button_x)
        val buttonMinus= findViewById<Button>(R.id.button_minus)
        val buttonPlus= findViewById<Button>(R.id.button_plus)
        val buttonSign= findViewById<Button>(R.id.button_sign)
        val buttonDot= findViewById<Button>(R.id.button_dot)
        val buttonEqual = findViewById<Button>(R.id.button_equal)

        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonCE.setOnClickListener(this)
        buttonC.setOnClickListener(this)
        buttonBS.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)
        buttonX.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonPlus.setOnClickListener(this)
        buttonSign.setOnClickListener(this)
        buttonDot.setOnClickListener(this)
        buttonEqual.setOnClickListener(this)
        screen = findViewById<TextView>(R.id.screen)

    }


    var state = 1
    var op1 = 0
    var op2 = 0
    var op = ""

    fun calculate (op1: Int, op2: Int, op: String): Int{
        var result = 0
        when (op){
            "plus" -> result = op1 + op2
            "minus" -> result = op1 - op2
            "divide" -> result = op1/op2
            "multiply" -> result = op1 * op2
        }
        return result
    }

    override fun onClick(view: View?) {
        if (state == 1){
            if (view?.id == R.id.button_equal){
                screen.text = calculate(op1, op2, op).toString()
                op1 = 0
                op2 = 0
            } else{
                when (view?.id){
                    R.id.button_0 -> op1 = op1*10
                    R.id.button_1 -> op1 = op1*10+1
                    R.id.button_2 -> op1 = op1*10+2
                    R.id.button_3 -> op1 = op1*10+3
                    R.id.button_4 -> op1 = op1*10+4
                    R.id.button_5 -> op1 = op1*10+5
                    R.id.button_6 -> op1 = op1*10+6
                    R.id.button_7 -> op1 = op1*10+7
                    R.id.button_8 -> op1 = op1*10+8
                    R.id.button_9 -> op1 = op1*10+9
                    R.id.button_sign -> op1 = -op1
                    R.id.button_C -> {op1 =0; op2=0; state=1}
                    R.id.button_CE -> op1 = 0
                    R.id.button_BS -> op1 = if(op1.toString().length > 1) op1.toString().substring(0, op1.toString().length - 1).toInt() else 0
                    R.id.button_plus -> {state = 2; op="plus"}
                    R.id.button_minus -> {state = 2; op="minus"}
                    R.id.button_x -> {state = 2; op="multiply"}
                    R.id.button_divide -> {state = 2; op="divide"}

                }
                screen.text = op1.toString()
            }
        }else if (state == 2){
            if (view?.id == R.id.button_equal){
                op1 = calculate(op1, op2, op)
                screen.text = op1.toString()
                op2 = 0
                state=1
            } else{
                when (view?.id){
                    R.id.button_0 -> op2 = op2*10
                    R.id.button_1 -> op2 = op2*10+1
                    R.id.button_2 -> op2 = op2*10+2
                    R.id.button_3 -> op2 = op2*10+3
                    R.id.button_4 -> op2 = op2*10+4
                    R.id.button_5 -> op2 = op2*10+5
                    R.id.button_6 -> op2 = op2*10+6
                    R.id.button_7 -> op2 = op2*10+7
                    R.id.button_8 -> op2 = op2*10+8
                    R.id.button_9 -> op2 = op2*10+9
                    R.id.button_sign -> op2 = -op2
                    R.id.button_CE -> op2 =0
                    R.id.button_C -> {op1 =0; op2=0; state=1}
                    R.id.button_BS -> op2 = if(op2.toString().length > 1) op2.toString().substring(0, op2.toString().length - 1).toInt() else 0
                    R.id.button_BS -> op2 = op2.toString().substring(0, op2.toString().length - 1).toInt()
                    R.id.button_plus -> {state = 1; op="plus"}
                    R.id.button_minus -> {state = 1; op="minus"}
                    R.id.button_x -> {state = 1; op="multiply"}
                    R.id.button_divide -> {state = 1; op="divide"}
                }
                screen.text = op2.toString()
            }
        }
        
        
    }
}


