package com.martynov.savefile

import android.widget.Toast

lateinit var APP_ACTIVITY: MainActivity

fun showToast(msg:String){
    Toast.makeText(APP_ACTIVITY,msg, Toast.LENGTH_SHORT).show()
}