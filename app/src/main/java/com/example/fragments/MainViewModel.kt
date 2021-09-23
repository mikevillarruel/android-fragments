package com.example.fragments

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.parcel.Parcelize

class MainViewModel : ViewModel() {

    private val user = MutableLiveData<User>(/*User("Juan",25)*/)

    fun setUser(user: User) {
        this.user.value = user
    }

    fun getUser(): LiveData<User> {
        return user
    }

}

@Parcelize
data class User(val name: String, val edad: Int) : Parcelable