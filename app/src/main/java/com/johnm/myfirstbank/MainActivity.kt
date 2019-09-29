package com.johnm.myfirstbank

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.johnm.myfirstbank.fragments.AccountUserFragment
import com.johnm.viewutil.LoginFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentTransaction = supportFragmentManager
        initLogin()
    }

    private fun initLogin() {
        val loginFragment = LoginFragment()
        loginFragment.launchAccountUser = { launchFragment(AccountUserFragment()) }
        launchFragment(loginFragment)
    }


    private fun launchFragment(fragment: Fragment) {
        tableFragmnet.removeAllViews()
        val fragmentTransaction = fragmentTransaction?.beginTransaction()
        fragmentTransaction?.add(R.id.tableFragmnet, fragment)
        fragmentTransaction?.commit()
    }


    companion object {
        var fragmentTransaction: FragmentManager? = null
    }

}
