package io.raveerocks.vault

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (true) { // TODO : Login Check
            setContentView(R.layout.activity_main)
        }
    }
}