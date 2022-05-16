package com.purnendu.navigationcomponent.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.purnendu.navigationcomponent.SampleData
import com.purnendu.navigationcomponent.databinding.FragmentSendCashBinding


class SendCashFragment : Fragment() {

    private lateinit var binding: FragmentSendCashBinding
    private val args: SendCashFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSendCashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       // SampleData.defaultAmount.value.toString()
        SampleData.defaultAmount.observe(viewLifecycleOwner){
            binding.amount.setText(it.toString())
        }

        binding.receiverName.text = "Send cash to ${args.receiverName}"

        binding.next.setOnClickListener {


            if(binding.amount.text.isEmpty())
                return@setOnClickListener

            findNavController().navigate(
                SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogueFragment2(
                    args.receiverName,binding.amount.text.toString().toInt())
            )
        }

        binding.cancel.setOnClickListener { findNavController().popBackStack() }

        binding.done.setOnClickListener {
            findNavController().navigate(SendCashFragmentDirections.actionSendCashFragmentToHomeFragment())
        }
    }

}