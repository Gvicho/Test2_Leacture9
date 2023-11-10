package com.example.test2_leacture9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.marginLeft
import com.example.test2_leacture9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    var anagramMp = mutableMapOf<MutableList<Char>,MutableList<String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.svBtn.setOnClickListener{
            savestring()
        }

        binding.outBtn.setOnClickListener{
            outputAnagrams()
        }
    }

    private fun savestring(){
        val txt: String = binding.edtAnagrams.text.toString()

        if(txt.isEmpty()){
            Toast.makeText(this, "Empty string can't be added", Toast.LENGTH_SHORT).show()
        }

        var lstForTxt= mutableListOf<Char>()

        txt.forEach {
            lstForTxt.add(it)
        }

        lstForTxt.sort()

        if(anagramMp[lstForTxt] == null) anagramMp[lstForTxt] = mutableListOf<String>()

        anagramMp[lstForTxt]?.add(txt)

        binding.edtAnagrams.text.clear()
    }

    private fun outputAnagrams(){

        val num = anagramMp.size
        var txt = "number Of Anagram groups : $num , here are they => "

        anagramMp.forEach{
            txt+=it.value.toString()
            txt+= " "
        }
        txt+=" ."
        binding.angrmsCountTxt.text = txt
    }
}