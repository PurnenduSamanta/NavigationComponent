package com.purnendu.navigationcomponent.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.purnendu.navigationcomponent.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val action=HomeFragmentDirections

        binding.sendMoney.setOnClickListener {
            findNavController().navigate(action.actionHomeFragmentToChooseReceiverFragment())
        }

        binding.viewBalance.setOnClickListener {
            findNavController().navigate(action.actionHomeFragmentToViewBalanceFragment())  }

        binding.viewTransaction.setOnClickListener {
            findNavController().navigate(action.actionHomeFragmentToViewTransactionFragment()) }

    }




}