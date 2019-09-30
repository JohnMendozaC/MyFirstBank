package com.johnm.myfirstbank.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.johnm.myfirstbank.R

class TransferUserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        inflater.inflate(
            R.layout.tranfer_user_layout,
            container,
            false
        )


}