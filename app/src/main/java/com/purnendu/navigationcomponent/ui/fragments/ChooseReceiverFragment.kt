package com.purnendu.navigationcomponent.ui.fragments

import android.app.PendingIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.findNavController
import com.purnendu.navigationcomponent.CHANNEL_ID
import com.purnendu.navigationcomponent.R
import com.purnendu.navigationcomponent.databinding.FragmentChooseReceiverBinding


class ChooseReceiverFragment : Fragment()

{
    private lateinit var binding:FragmentChooseReceiverBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding=FragmentChooseReceiverBinding.inflate(inflater,container,false)
        return  binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.next.setOnClickListener {

           if(binding.receiver.text.isEmpty())
               return@setOnClickListener

            val pendingIntent= NavDeepLinkBuilder(requireContext())
                .setGraph(R.navigation.main_nav_graph)
                .setDestination(R.id.sendCashFragment)
                .setArguments(SendCashFragmentArgs(binding.receiver.text.toString()).toBundle())
                .createPendingIntent()

            showNotification(pendingIntent,binding.receiver.text.toString())
            findNavController().navigate(ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToSendCashFragment(binding.receiver.text.toString()))
        }

        binding.cancel.setOnClickListener { findNavController().popBackStack() }


    }

    private fun showNotification(pendingIntent: PendingIntent, receiverName: String) {
        val notification=NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Complete Transaction")
            .setContentText("Send money to $receiverName")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(requireContext()).notify(1002,notification)
    }
}