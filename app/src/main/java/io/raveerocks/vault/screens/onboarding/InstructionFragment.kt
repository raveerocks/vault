package io.raveerocks.vault.screens.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import io.raveerocks.vault.R
import io.raveerocks.vault.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstructionBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)
        binding.nextButton.setOnClickListener {
            it.findNavController()
                .navigate(InstructionFragmentDirections.actionInstructionFragmentToListFragment())
        }
        return binding.root
    }
}