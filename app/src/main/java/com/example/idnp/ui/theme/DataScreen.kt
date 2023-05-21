package com.example.idnp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.idnp.ui.theme.viewmodels.DataViewModel

@Composable
fun DataScreen (
    dataViewModel: DataViewModel = viewModel()
){
    val getData = dataViewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = getData.name.toString())
        Text(text = getData.date.toString())
        Text(text = getData.bloodType.toString())
        Text(text = getData.phone.toString())
        Text(text = getData.email.toString())
        Text(text = getData.paymentAmount.toString())
    }
}