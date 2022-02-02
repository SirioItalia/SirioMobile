package com.zenlaeth.sirioitalia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zenlaeth.sirioitalia.ExplorerActivity
import com.zenlaeth.sirioitalia.R

class ExplorerFragment() : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        return inflater?.inflate(R.layout.explorer, container, false)
    }
}