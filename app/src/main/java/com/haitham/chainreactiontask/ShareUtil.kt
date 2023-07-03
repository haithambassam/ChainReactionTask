package com.haitham.chainreactiontask

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.facebook.share.model.ShareLinkContent
import com.facebook.share.widget.ShareDialog


fun Fragment.shareOnInstagram(content: String) {


    val intent = Intent(Intent.ACTION_SEND)
    intent.type = "text/plain"
    intent.putExtra(Intent.EXTRA_TEXT, content)
    intent.setPackage("com.instagram.android")

    try {
        // Start the specific social application
        startActivity(intent)
    } catch (ex: ActivityNotFoundException) {
        // The application does not exist
        Toast.makeText(activity, "app have not been installed.", Toast.LENGTH_SHORT).show()
    }
}


fun Fragment.shareFacebook(content:String) {
    val shareDialog = ShareDialog(this)
    if (ShareDialog.canShow(ShareLinkContent::class.java)) {
        val linkContent = ShareLinkContent.Builder()
            .setQuote(content)
            .setContentUrl(Uri.parse("https://api.alquran.cloud/v1/sajda/ar.asad"))
            .build()

        shareDialog.show(linkContent)
    } else {
        Toast.makeText(activity, "Cannot share content to Facebook", Toast.LENGTH_SHORT).show()
    }

}
