package com.martynov.savefile

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.martynov.savefile.databinding.ActivityMainBinding
import java.io.File
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.io.PrintWriter


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        APP_ACTIVITY = this
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveB.setOnClickListener {
            saveFile("log.txt")
        }
        binding.loadB.setOnClickListener {
            loadFile("log.txt")
        }
        binding.clearB.setOnClickListener {
            clearFile("log.txt")
        }


    }

    private fun saveFile(fileName: String) {
        try {
            val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "/hands")
            file.mkdir()
            val fileFinal= File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "/hands/log.txt")
            fileFinal.appendText("${binding.inputET.text}\n")

        } catch (t: Throwable) {
            Log.d("MyLogS", "${t}")
            showToast("Exception: $t")
        }

    }
    private fun loadFile(fileName: String){
        try {
            val file =File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), fileName)
            val text = file.readText()
            binding.textView.text = text
            Log.d("MyLogS", "${text}")


        } catch (t: Throwable) {
            Log.d("MyLogS", "${t}")
            showToast("Exception: $t")
        }
    }
    fun clearFile(fileName: String){
        try {
            val file =File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), fileName)
            file.delete()


        } catch (t: Throwable) {
            Log.d("MyLogS", "${t}")
            showToast("Exception: $t")
        }
    }


}