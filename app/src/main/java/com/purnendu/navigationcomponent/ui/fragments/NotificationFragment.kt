package com.purnendu.navigationcomponent.ui.fragments


import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.purnendu.navigationcomponent.R


class NotificationFragment : Fragment(R.layout.fragment_notification) {
    private lateinit var listView:ListView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView=view.findViewById(R.id.listView_notification)

        listView.adapter=ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,getNotification())


    }

    private fun getNotification(): List<String> {

        val notifications= mutableListOf<String>()

        for(i in 1..20)
            notifications.add("Notification $i")

        return notifications
    }

}