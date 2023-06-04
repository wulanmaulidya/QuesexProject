package org.d3ifproject.quesex.model

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import org.d3ifproject.quesex.livedata.FirebaseUserLiveData

class ProfileViewModel : ViewModel() {
    val authState = FirebaseUserLiveData()

    init {
        checkToken()
    }

    private fun checkToken() {
        val tokenTask =
            FirebaseMessaging.getInstance().token
        tokenTask.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("FCM", "FCM token failed.", task.exception)
                return@OnCompleteListener
            }
            Log.d("FCM", "Token: ${task.result}")
        })
    }
}