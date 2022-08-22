package com.multic.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.multic.R
import com.multic.databinding.ActivityGameBinding

class Game : AppCompatActivity() {
    lateinit var binding:ActivityGameBinding
    val roll= mutableListOf<String>("1","2","3")
    var attemp=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var i1=roll.random()
        check(i1,binding.im1)
        var i2=roll.random()
        check(i2,binding.im2)
        var i3=roll.random()
        check(i3,binding.im3)
        var i4=roll.random()
        check(i4,binding.im4)
        val i5=roll.random()
        check(i5,binding.im5)
        binding.im1.setOnClickListener {
            i4=roll.random()
            check(i4,binding.im4)
            checkWin(i1,i2,i3,i4,i5)
            attemp++
        }
        binding.im2.setOnClickListener {
            i3=roll.random()
            check(i3,binding.im3)
            checkWin(i1,i2,i3,i4,i5)
            attemp++
        }
        binding.im3.setOnClickListener {
            i1=roll.random()
            check(i1,binding.im1)
            checkWin(i1,i2,i3,i4,i5)
            attemp++
        }
        binding.im4.setOnClickListener {
            i2=roll.random()
            check(i2,binding.im2)
            checkWin(i1,i2,i3,i4,i5)
            attemp++
        }

    }

    fun check(i:String,im:ImageView){
        if(i=="1"){
            im.setImageResource(R.drawable.book)

        }
        else if(i=="2"){
            im.setImageResource(R.drawable.eae)
        }
        else{
            im.setImageResource(R.drawable.scar)
        }
    }
    fun checkWin(i:String,i1:String,i2:String,i3:String,i4:String){
        if(i=="1"&& i1=="1"&& i2=="1"&&i3=="1"&&i4=="1"){
            intentr()
        }
        else if(i=="2"&& i1=="2"&& i2=="2"&&i3=="2"&&i4=="2"){
            intentr()

        }
        else if(i=="3"&& i1=="3"&& i2=="3"&&i3=="3"&&i4=="3"){
           intentr()
        }

    }
    fun intentr(){
        val att="Attemps : ${attemp.toString()}"
        val intent= Intent(this@Game,Res::class.java)
        intent.putExtra("att",att)
        startActivity(intent)
    }
}