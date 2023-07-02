package com.haitham.chainreactiontask

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.annotation.DrawableRes


fun Context.shareOnFacebook( title: String, content: String) {
    val intent = Intent()
    intent.action = Intent.ACTION_SEND
    intent.setPackage("com.facebook.katana")

    intent.putExtra(Intent.EXTRA_TITLE, title)
    intent.putExtra(Intent.EXTRA_TEXT, content)
    intent.type = "text/plain"

    try {
        // Start the specific social application
        startActivity(intent)
    } catch (ex: ActivityNotFoundException) {
        // The application does not exist
        Toast.makeText(this, "app have not been installed.", Toast.LENGTH_SHORT).show()
    }
}


fun Context.shareOnInstagram(@DrawableRes image: Int, content: String) {
    val imageUri = Uri.parse("android.resource://$packageManager/$image")


    val intent = Intent(Intent.ACTION_SEND)
    intent.type = "image/*"
    intent.putExtra(Intent.EXTRA_STREAM, imageUri)
    intent.putExtra(Intent.EXTRA_TEXT, content)
    intent.setPackage("com.instagram.android")

    try {
        // Start the specific social application
        startActivity(intent)
    } catch (ex: ActivityNotFoundException) {
        // The application does not exist
        Toast.makeText(this, "app have not been installed.", Toast.LENGTH_SHORT).show()
    }
}