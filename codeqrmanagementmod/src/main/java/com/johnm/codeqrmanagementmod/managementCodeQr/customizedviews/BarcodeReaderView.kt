package com.johnm.codeqrmanagementmod.managementCodeQr.customizedviews


import android.content.Context
import android.content.pm.PackageManager
import android.util.AttributeSet
import android.util.Log
import android.view.SurfaceHolder
import android.view.WindowManager
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import com.johnm.codeqrmanagementmod.R
import kotlinx.android.synthetic.main.barcode_reader_layout.view.*
import java.io.IOException


class BarcodeReaderView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {


    init {
        onCreateView()
    }

    private var barcodeDetector: BarcodeDetector? = null
    private var cameraSource: CameraSource? = null
    private var token: String = ""
    private var tokenBefore: String = ""
    lateinit var showImageQr: (token: String) -> Unit


    fun onCreateView() {
        inflate(context, R.layout.barcode_reader_layout, this)
        initConfigBarcode()
        initConfigCamera()
    }

    fun initConfigBarcode() {
        // creo el detector qr
        barcodeDetector = BarcodeDetector.Builder(context)
            .setBarcodeFormats(Barcode.QR_CODE)
            .build()

        // preparo el detector de QR
        barcodeDetector?.setProcessor(object : Detector.Processor<Barcode> {
            override fun release() {}


            override fun receiveDetections(detections: Detector.Detections<Barcode>) {
                val barcodes = detections.detectedItems

                if (barcodes.size() > 0) {
                    token = barcodes.valueAt(0).displayValue.toString()
                    showImageQr(token)
                    /* // obtenemos el token
                     token = barcodes.valueAt(0).displayValue.toString()

                     // verificamos que el token anterior no se igual al actual
                     // esto es util para evitar multiples llamadas empleando el mismo token
                     if (!token.equals(tokenBefore)) {

                         // guardamos el ultimo token proceado
                         tokenBefore = token
                         Log.i("token", token)

                         if (URLUtil.isValidUrl(token)) {
                             // si es una URL valida abre el navegador
                             val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(token))
                             startActivity(browserIntent)
                         } else {
                             // comparte en otras apps
                             val shareIntent = Intent()
                             shareIntent.action = Intent.ACTION_SEND
                             shareIntent.putExtra(Intent.EXTRA_TEXT, token)
                             shareIntent.type = "text/plain"
                             startActivity(shareIntent)
                         }

                         Handler().postDelayed(
                             // limpiamos el token
                             { tokenBefore = "" }, 5000
                         )

                     }*/
                }
            }
        })


    }

    fun initConfigCamera() {
        val wm = this.context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay

        // creo la camara fuente
        cameraSource = CameraSource.Builder(context!!, barcodeDetector)
            .setRequestedPreviewSize(display.width, display.height)
            .build()

        camera_view.holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {

                // verifico si el usuario dio los permisos para la camara
                if (ContextCompat.checkSelfPermission(
                        context!!,
                        android.Manifest.permission.CAMERA
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    try {
                        cameraSource?.start(camera_view.getHolder())
                    } catch (ie: IOException) {
                        Log.e("CAMERA SOURCE", ie.message)
                    }

                } else {
                    Toast.makeText(context, "ERROR FATAL", Toast.LENGTH_SHORT).show()
                }
            }

            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) {
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                cameraSource?.stop()
            }
        })
    }

}