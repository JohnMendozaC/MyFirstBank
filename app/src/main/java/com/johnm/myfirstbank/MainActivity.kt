package com.johnm.myfirstbank

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.johnm.myfirstbank.fragments.AccountUserFragment
import com.johnm.viewutil.LoginFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLogin()
    }

    private fun initLogin() {
        val loginFragment = LoginFragment()
        loginFragment.launchAccountUser = { launchFragment(AccountUserFragment()) }
        launchFragment(loginFragment)
    }

    private fun launchFragment(fragment: Fragment) {
        tableFragmnet.removeAllViews()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.tableFragmnet, fragment)
        fragmentTransaction.commit()
    }

}
