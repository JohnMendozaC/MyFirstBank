package com.johnm.viewutil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_view.*

class LoginFragment : Fragment() {

    lateinit var launchAccountUser: () -> Unit


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.login_view, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
    }


    fun initButtons() {
        btnLogin.setOnClickListener {
            if (et_user_name.text.isNotEmpty()) {
                val userName = it.context.getString(R.string.user_name)
                if (et_user_name.hint.toString().equals(userName)) {
                    et_user_name.setText(null)
                    et_user_name.hint = it.context.getString(R.string.pass_name)
                    btnLogin.setText(R.string.button_login)
                    login_invalid.visibility = View.GONE
                } else {
                    launchAccountUser()
                }

            } else {
                login_invalid.visibility = View.VISIBLE
            }
        }
    }

}