package com.johnm.codeqrmanagementmod.managementCodeQr

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.johnm.codeqrmanagementmod.R
import kotlinx.android.synthetic.main.barcode_create_layout.*
import net.glxn.qrgen.android.QRCode

class BarcodeCreateQrFragment(var tokenQr: String) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.barcode_create_layout, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val wm = this.context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val bitmap = QRCode.from(tokenQr).withSize(display.width, display.height).bitmap()
        image_code_qr.setImageBitmap(bitmap)
    }

}