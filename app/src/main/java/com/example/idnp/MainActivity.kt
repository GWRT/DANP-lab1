package com.example.idnp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.idnp.ui.theme.DataScreen
import com.example.idnp.ui.theme.themes.IDNPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IDNPTheme {
                // A surface container using the 'background' color from the theme
                DataScreen()
            }
        }
    }
}
