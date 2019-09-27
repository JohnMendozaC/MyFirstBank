package com.johnm.myfirstbank

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.johnm.codeqrmanagementmod.managementCodeQr.BarcodeCreateQrFragment
import com.johnm.codeqrmanagementmod.managementCodeQr.BarcodeReaderFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val barcodeReaderFragment = BarcodeReaderFragment()
        barcodeReaderFragment.showImageQr = { token -> launchCodeQr(token) }
        fragmentTransaction.add(R.id.tableFragmnet, barcodeReaderFragment)
        fragmentTransaction.commit()
    }


    fun launchCodeQr(tokenQr: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.tableFragmnet, BarcodeCreateQrFragment(tokenQr))
        fragmentTransaction.commit()
    }
}
