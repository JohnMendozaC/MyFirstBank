package com.johnm.codeqrmanagementmod.managementCodeQr.customizedviews

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.johnm.codeqrmanagementmod.R
import kotlinx.android.synthetic.main.barcode_create_layout.*
import kotlinx.android.synthetic.main.barcode_create_layout.view.*
import net.glxn.qrgen.android.QRCode

class BarcodeCreateQrView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    ConstraintLayout(context, attrs, defStyleAttr) {


    init {
        onCreateView()
    }


    fun onCreateView() {
        inflate(context, R.layout.barcode_create_layout, this)
    }

    fun onViewCreated() {
        val wm = this.context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        /*val bitmap = QRCode.from(tokenQr).withSize(display.width, display.height).bitmap()
        image_code_qr.setImageBitmap(bitmap)*/
    }

}