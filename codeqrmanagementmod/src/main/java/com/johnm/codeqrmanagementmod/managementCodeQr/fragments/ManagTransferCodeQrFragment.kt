package com.johnm.codeqrmanagementmod.managementCodeQr.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.johnm.codeqrmanagementmod.R
import kotlinx.android.synthetic.main.management_codeqr_layout.*

class ManagTransferCodeQrFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(
        R.layout.management_codeqr_layout,
        container,
        false
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
    }


    private fun initButtons() {
        btn_createqr.setOnClickListener {
            showViewCodeQr(true)
        }
        btn_readeqr.setOnClickListener {
            showViewCodeQr(false)
        }
    }


    private fun showViewCodeQr(isVisibleCreate: Boolean) {
        if (isVisibleCreate) {
            barcode_create.visibility = View.VISIBLE
            barcode_reade.visibility = View.GONE
        } else {
            barcode_reade.visibility = View.VISIBLE
            barcode_create.visibility = View.GONE
        }
    }

}