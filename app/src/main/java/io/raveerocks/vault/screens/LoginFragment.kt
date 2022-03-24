package io.raveerocks.vault.screens

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import io.raveerocks.vault.R
import io.raveerocks.vault.databinding.FragmentLoginBinding

class LoginFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding:FragmentLoginBinding  = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        binding.signInButton.setOnClickListener {
            if(validate(it,binding.emailField.text,binding.passwordField.text)){
                navigateToWelcomeScreen(it)
            }
        }
        binding.signUpButton.setOnClickListener {
            if(validate(it,binding.emailField.text,binding.passwordField.text)){
                navigateToWelcomeScreen(it)
            }
        }
        return binding.root
    }

    private fun validate(view:View, email: Editable, password: Editable): Boolean {
        if(email.isEmpty()){
            Snackbar.make(view,"Email cannot be empty",Snackbar.LENGTH_LONG).show()
            return false
        }
        else if(password.isEmpty()){
            Snackbar.make(view,"Password cannot be empty",Snackbar.LENGTH_LONG).show()
            return false
        }
        return true
    }
    private fun navigateToWelcomeScreen(view: View) {
        view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }
}