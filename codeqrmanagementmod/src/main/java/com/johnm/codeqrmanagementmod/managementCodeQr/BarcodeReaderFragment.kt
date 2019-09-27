package com.johnm.codeqrmanagementmod.managementCodeQr


import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.*
import android.webkit.URLUtil
import android.widget.Toast

import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import com.johnm.codeqrmanagementmod.R
import kotlinx.android.synthetic.main.barcode_reader_layout.*
import java.io.IOException


class BarcodeReaderFragment : Fragment() {

    private var barcodeDetector: BarcodeDetector? = null
    private var cameraSource: CameraSource? = null
    private var token: String = ""
    private var tokenBefore: String = ""
    private var cameraView: SurfaceView? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.barcode_reader_layout, container)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initConfigBarcodeAndCamera()
        cameraView = view.findViewById(R.id.camera_view)
    }


    fun initConfigBarcodeAndCamera() {
        // creo el detector qr
        barcodeDetector = BarcodeDetector.Builder(context)
            .setBarcodeFormats(Barcode.QR_CODE)
            .build()

        // creo la camara fuente
        cameraSource = CameraSource.Builder(context!!, barcodeDetector)
            .setRequestedPreviewSize(cameraView!!.width, cameraView!!.height)
            .build()

        cameraView!!.holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {

                // verifico si el usuario dio los permisos para la camara
                if (ContextCompat.checkSelfPermission(
                        context!!,
                        android.Manifest.permission.CAMERA
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    try {
                        cameraSource?.start(cameraView!!.getHolder())
                    } catch (ie: IOException) {
                        Log.e("CAMERA SOURCE", ie.message)
                    }

                } else {
                    Toast.makeText(context, "ERROR FATAL", Toast.LENGTH_SHORT).show()
                }
            }

            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                cameraSource?.stop()
            }
        })

        // preparo el detector de QR
        barcodeDetector?.setProcessor(object : Detector.Processor<Barcode> {
            override fun release() {}


            override fun receiveDetections(detections: Detector.Detections<Barcode>) {
                val barcodes = detections.detectedItems

                if (barcodes.size() > 0) {

                    // obtenemos el token
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

                        Thread(object : Runnable {
                            override fun run() {
                                try {
                                    synchronized(this) {
                                        Handler().postDelayed(
                                            // limpiamos el token
                                            { tokenBefore = "" }, 5000
                                        )
                                    }
                                } catch (e: InterruptedException) {
                                    Log.e("Error", "Waiting didnt work!!")
                                    e.printStackTrace()
                                }

                            }
                        }).start()

                    }
                }
            }
        })


    }

}