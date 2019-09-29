package com.johnm.codeqrmanagementmod.managementCodeQr.customizedviews

import android.content.Context
import android.util.AttributeSet
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
import com.johnm.codeqrmanagementmod.R
import kotlinx.android.synthetic.main.barcode_create_layout.view.*
import net.glxn.qrgen.android.QRCode

class BarcodeCreateQrView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {


    init {
        onCreateView()
    }


    fun onCreateView() {
        inflate(context, R.layout.barcode_create_layout, this)
        onViewCreated()
    }

    fun onViewCreated() {
        val wm = this.context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val bitmap = QRCode
            .from("codigo prueba")
            .withSize(display.width, display.height).bitmap()
        image_code_qr.setImageBitmap(bitmap)
    }

}