package com.rober.protobufdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.rober.protobufdemo.databinding.ActivityMainBinding
import mmbizapp.Base.Person

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()
        val person = Person.parseFrom(generateByteArray())
        Log.i(TAG, "person:$person")
    }

    /**
     * A native method that is implemented by the 'protobufdemo' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    external fun generateByteArray(): ByteArray

    companion object {
        private const val TAG = "MainActivity"
        // Used to load the 'protobufdemo' library on application startup.
        init {
            System.loadLibrary("protobufdemo")
        }
    }
}