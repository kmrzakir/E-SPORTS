package com.example.esports

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.esports.AndroidUtls.AndroidUtlFunctions
import com.example.esports.DataModels.ContactUsModel
import com.example.esports.FirebaseUtls.FirebaseRepository

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ContactUsFragment : Fragment() {

  private lateinit var contactUsSpinner : Spinner
  private lateinit var firstName : String
  private lateinit var lastName : String
  private lateinit var email : String
  private lateinit var aboutUs : String
  private lateinit var message : String
  private lateinit var submitBtn : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contact_us, container, false)
        submitBtn = view.findViewById(R.id.submitBtn)

        //this method will setup spinner like add options on spinner view
        setUpSpinnerViewOptions(view)
        submitBtn.setOnClickListener {
           val isDataValidated = getDataFromContactUsViewsAndAlsoValidateIt(view)
            if(isDataValidated)
            {
                uploadDataToFireBase()
            }
        }
        return view
    }

    private fun uploadDataToFireBase() {
        val contactDataModel = ContactUsModel(firstName,lastName,email,message,aboutUs)
        FirebaseRepository.getContactUsDataCollectionReference().add(contactDataModel)
            .addOnSuccessListener {
              AndroidUtlFunctions.showToast(requireContext(),"Data added successfully")
            }
            .addOnFailureListener {
                  AndroidUtlFunctions.showToast(requireContext(),"Error while data uploading on firebase ${it.message.toString()}")
            }
    }

    private fun getDataFromContactUsViewsAndAlsoValidateIt(view: View): Boolean{
            firstName = view?.findViewById<EditText>(R.id.firstNameEditText)?.text.toString()
            lastName = view.findViewById<EditText>(R.id.lastNameEditText).text.toString()
            email = view.findViewById<EditText>(R.id.emailEditText).text.toString()
            message = view.findViewById<EditText>(R.id.messageEditText).text.toString()
            aboutUs = view.findViewById<Spinner>(R.id.contact_us_spinner).selectedItem.toString();
            if(firstName.trim().length < 3)
            {
                AndroidUtlFunctions.showToast(requireContext(),"first name should contain at least 3 characters")
                return false
            }else if(lastName.trim().length < 3)
            {
                AndroidUtlFunctions.showToast(requireContext(),"lastname should contain at least 3 characters")
                return false
            }else if(email.trim().length < 5 && !isValidEmail(email.trim()))
            {
               AndroidUtlFunctions.showToast(requireContext(),"In valid email");
                return false
            }else if(message.trim().length < 15)
            {
                AndroidUtlFunctions.showToast(requireContext(),"message should contain at least 15 characters")
                return false
            }else if(aboutUs == "select")
            {
                AndroidUtlFunctions.showToast(requireContext(),"please select an option about How did you hear about us?");
                return false
            }
        return true
    }

    private fun setUpSpinnerViewOptions(view : View) {
        // Define the array of values for the spinner
        val spinnerOptions = arrayOf("select","Option 1", "Option 2", "Option 3", "Option 4")
        contactUsSpinner = view.findViewById(R.id.contact_us_spinner)
        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,spinnerOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        contactUsSpinner.adapter = adapter
    }

    fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }



}