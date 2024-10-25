package com.example.jeniavriliaputriuts

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var inputLength: EditText
    private lateinit var inputWidth: EditText
    private lateinit var inputHeight: EditText
    private lateinit var resultVolume: TextView
    private lateinit var resultArea: TextView
    private lateinit var btnCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen UI
        inputLength = findViewById(R.id.inputLength)
        inputWidth = findViewById(R.id.inputWidth)
        inputHeight = findViewById(R.id.inputHeight)
        resultVolume = findViewById(R.id.resultVolume)
        resultArea = findViewById(R.id.resultArea)
        btnCalculate = findViewById(R.id.btnCalculate)

        // Aksi tombol ketika ditekan
        btnCalculate.setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        // Validasi input agar tidak kosong
        val lengthText = inputLength.text.toString()
        val widthText = inputWidth.text.toString()
        val heightText = inputHeight.text.toString()

        if (lengthText.isNotEmpty() && widthText.isNotEmpty() && heightText.isNotEmpty()) {
            val length = lengthText.toDouble()
            val width = widthText.toDouble()
            val height = heightText.toDouble()

            // Menghitung volume dan luas permukaan balok
            val volume = length * width * height
            val area = 2 * (length * width + width * height + length * height)

            // Menampilkan hasil
            resultVolume.text = "Volume: $volume"
            resultArea.text = "Luas: $area"
        } else {
            // Jika ada input yang kosong, tampilkan pesan error
            resultVolume.text = "Harap masukkan semua nilai!"
            resultArea.text = ""
        }
    }
}
