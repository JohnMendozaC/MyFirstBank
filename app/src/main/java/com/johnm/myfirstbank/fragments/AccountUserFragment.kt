package com.johnm.myfirstbank.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.johnm.codeqrmanagementmod.managementCodeQr.fragments.ManagTransferCodeQrFragment
import com.johnm.myfirstbank.MainActivity
import com.johnm.myfirstbank.R
import kotlinx.android.synthetic.main.account_user.*

class AccountUserFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.account_user, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
    }

    fun initButtons() {
        btn_check_weather.setOnClickListener {
            //changeMenuAccount()
            btn_check_weather.isEnabled = false
            btn_check_qr.isEnabled = true
            btn_check_account.isEnabled = true
        }

        btn_check_account.setOnClickListener {
            //changeMenuAccount()
            btn_check_account.isEnabled = false
            btn_check_qr.isEnabled = true
            btn_check_weather.isEnabled = true
        }

        btn_check_qr.setOnClickListener {
            changeMenuAccount(ManagTransferCodeQrFragment())
            btn_check_qr.isEnabled = false
            btn_check_account.isEnabled = true
            btn_check_weather.isEnabled = true
        }

    }


    fun changeMenuAccount(fragment: Fragment) {
        container_account.removeAllViews()
        val fragmentTransaction = MainActivity.fragmentTransaction?.beginTransaction()
        fragmentTransaction?.add(R.id.container_account, fragment)
        fragmentTransaction?.commit()
    }


}