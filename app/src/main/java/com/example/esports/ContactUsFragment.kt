package com.example.esports

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ContactUsFragment : Fragment() {

  private lateinit var contactUsSpinner : Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Define the array of values for the spinner
        val spinnerOptions = arrayOf("Option 1", "Option 2", "Option 3", "Option 4")
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contact_us, container, false)
        contactUsSpinner = view.findViewById(R.id.contact_us_spinner)
        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,spinnerOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        contactUsSpinner.adapter = adapter
        return view
    }


}