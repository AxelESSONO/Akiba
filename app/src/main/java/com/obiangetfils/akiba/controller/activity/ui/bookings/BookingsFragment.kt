package com.obiangetfils.akiba.controller.activity.ui.bookings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.obiangetfils.akiba.R

class BookingsFragment : Fragment() {

    private lateinit var bookingsViewModel: BookingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bookingsViewModel =
            ViewModelProvider(this).get(BookingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bookings, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        bookingsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}