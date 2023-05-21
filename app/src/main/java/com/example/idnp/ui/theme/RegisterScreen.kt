package com.example.idnp.ui.theme

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun RegisterScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {
        Register(Modifier.align(Alignment.Center))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(modifier: Modifier) {

    val context = LocalContext.current
    var db = Firebase.firestore

    var name by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    /*var pickedDate by remember { mutableStateOf(LocalDate.now()) }
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MMM dd yyyy")
                .format(pickedDate)
        }
    }*/
    val opOfBlood = setOf("A","B","0","AB")
    var bloodTypeSelected by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var paymentAmount by remember { mutableStateOf("") }




    Column(modifier = modifier) {

        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color(0xFF636262),
                containerColor = Color(0xFFDEDDDD),
                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            )
        )

        Spacer(modifier = Modifier.padding(20.dp))
        OutlinedTextField(
            value = date,
            onValueChange = {date = it},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color(0xFF636262),
                containerColor = Color(0xFFDEDDDD),
                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            )
        )

        Spacer(modifier = Modifier.padding(20.dp))
        Row {
           opOfBlood.forEach {
               Column(
                   modifier = Modifier.padding(horizontal = 8.dp),
                   horizontalAlignment = Alignment.CenterHorizontally,
               ) {
                   RadioButton(
                       selected = bloodTypeSelected == it,
                       onClick = { bloodTypeSelected = it },
                       colors = RadioButtonDefaults.colors(
                           selectedColor = MaterialTheme.colorScheme.onPrimary
                       )
                   )
                   Text(text = it, style = MaterialTheme.typography.bodyMedium)
               }
           }
        }

        //telefono
        Spacer(modifier = Modifier.padding(20.dp))
        OutlinedTextField(
            value = phone,
            onValueChange = {phone = it},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color(0xFF636262),
                containerColor = Color(0xFFDEDDDD),
                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            )
        )

        Spacer(modifier = Modifier.padding(20.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color(0xFF636262),
                containerColor = Color(0xFFDEDDDD),
                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            )
        )

        Spacer(modifier = Modifier.padding(20.dp))
        OutlinedTextField(
            value = paymentAmount,
            onValueChange = {paymentAmount = it},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color(0xFF636262),
                containerColor = Color(0xFFDEDDDD),
                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            )
        )

        Spacer(modifier = Modifier.padding(20.dp))

        Button(onClick = {
            val dataRegisterMap = hashMapOf(
                "name" to name,
                "date" to  date,
                "bloodType" to bloodTypeSelected,
                "phone" to phone,
                "email" to email,
                "paymentAmount" to paymentAmount
            )

            //val userId = FirebaseAuth.getInstance().currentUser!!.uid

            db.collection("dataRegister").document().set(dataRegisterMap)
                .addOnSuccessListener {
                    Toast.makeText(context, "Successfully Added!", Toast.LENGTH_SHORT).show()
                }
        }) {
            Text(text = "Registrar")
        }
    }
}


