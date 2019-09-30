package com.johnm.myfirstbank.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

object PermissionUtils {

    const val MY_PERMISSIONS_REQUEST = 1

    val permissions = arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    fun requestPermissions(context: Context) {

        val permissionTemp = permissions.filter { permission ->
            (ContextCompat.checkSelfPermission(
                context,
                permission
            ) != PackageManager.PERMISSION_GRANTED)
        }

        if (!permissionTemp.isNullOrEmpty()) {
            (context as Activity).requestPermissions(
                permissionTemp.toTypedArray(),
                MY_PERMISSIONS_REQUEST
            )
        }
    }
}