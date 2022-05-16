package com.purnendu.navigationcomponent.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.purnendu.navigationcomponent.databinding.FragmentConfirmDialogueBinding


class ConfirmDialogueFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentConfirmDialogueBinding
    private val args: ConfirmDialogueFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =FragmentConfirmDialogueBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.confirmation.text="Do you want to send ${args.amount.toString()}rs to ${args.receiverName}?"


        binding.yes.setOnClickListener {
            Toast.makeText(requireContext(),"Money Sent",Toast.LENGTH_SHORT).show()
            dismiss()  }

        binding.no.setOnClickListener { dismiss() }


    }




}