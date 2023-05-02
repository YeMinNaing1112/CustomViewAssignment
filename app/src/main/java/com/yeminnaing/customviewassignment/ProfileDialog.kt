package com.yeminnaing.customviewassignment

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.WindowManager

class ProfileDialog(context: Context) :
    Dialog(context, android.R.style.Theme_DeviceDefault_Dialog_NoActionBar) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.ownerActivity?.window?.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val windowParams = window?.attributes
        windowParams?.width = WindowManager.LayoutParams.MATCH_PARENT
        windowParams?.height = WindowManager.LayoutParams.MATCH_PARENT
        window?.attributes = windowParams
    }
}