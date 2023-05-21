package com.example.idnp.ui.theme.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.idnp.ui.theme.models.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class DataViewModel: ViewModel(){
    val state = mutableStateOf(User())

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            state.value = getDataFromFireStore()
        }
    }
}

suspend fun getDataFromFireStore():User{
    val db = FirebaseFirestore.getInstance()
    var user = User()

    try {
        db.collection("dataRegister").get().await().map {
            val result = it.toObject(User::class.java)
            user = result
        }
    }catch (e : FirebaseFirestoreException){
        Log.d("error", "getDataFromFireStore:  $e")
    }

    return user
}