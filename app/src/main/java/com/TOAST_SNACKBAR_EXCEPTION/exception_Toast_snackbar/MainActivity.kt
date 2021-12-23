package com.TOAST_SNACKBAR_EXCEPTION.exception_Toast_snackbar

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.exceptions.R
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private var x:Int?=null
    private var buttonShowsack: Button? = null
    private var buutonShow: Button? = null
    private var constraintLayout: ConstraintLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       handException()
        connectView()
        showToast()
        snackBar()


    }

    private fun connectView() {
        buutonShow = findViewById(R.id.btnShowToast)
        buttonShowsack = findViewById(R.id.btnShowSnack)
        constraintLayout = findViewById(R.id.root)
    }

    private fun showToast() {//اذا تم الضغط على الزر تجي رساله تنبيه للمستخدم عن طريق toast

        buutonShow?.setOnClickListener() {
            // 1) context (this)
            // 2) message
            //3) Duration

            //داله toast لازم تحتوي 3 قيم السياق this الرساله التي تبي تعرضها للمستخدم والمدة واخر شي لاتنسى داله show()
            Toast.makeText(this, "this is toast", Toast.LENGTH_SHORT).show()
            //Lenght_longمدة اطول
        }
    }
    private fun snackBar() {

        //1) view group (constraint layout
        //2)message
        //3) Duration
        buttonShowsack?.setOnClickListener(){
            Snackbar.make(constraintLayout!!, "this is snackbar"
                , Snackbar.LENGTH_INDEFINITE).setAction("Dismiss"){
            }.show()
        }
        //in the Toast you can not add button
       // Snackbar.make(constraintLayout!!, "this is snackbar"
         //   , Snackbar.LENGTH_INDEFINITE).setAction("Dismiss"){
       // }.show()                         //setAction give you button you can writ in side it
    }
     private fun handException(){

        try {
            val sum = x!! + 10
        }catch (e:NullPointerException){
            Log.e("errorNull","x can not be null")
        }
        try {
            val div = 10/0

        }catch (e:ArithmeticException){
            Log.e("error viv","can not be divide over 0")
        }
        val arr:ArrayList<String> = ArrayList()
        arr.add("afayez")
        arr.add("khaled")
        arr.add("heba")
        arr.add("sarah")
        arr.add("ghla")

        try {
            val name = arr[5]

        }catch (e:IndexOutOfBoundsException){
            Log.e("error arr","non existent index")
        }

    }


}