package com.johnm.myfirstbank

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.johnm.codeqrmanagementmod.managementCodeQr.BarcodeReaderFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.tableFragmnet, BarcodeReaderFragment())
        fragmentTransaction.commit()
    }
}
