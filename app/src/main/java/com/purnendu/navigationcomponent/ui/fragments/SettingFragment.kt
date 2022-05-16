package com.purnendu.navigationcomponent.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.purnendu.navigationcomponent.SampleData
import com.purnendu.navigationcomponent.databinding.FragmentSettingBinding


class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentSettingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.defaultAmount.setText(SampleData.defaultAmount.value.toString())

        binding.save.setOnClickListener {
            SampleData.defaultAmount.value=binding.defaultAmount.text.toString().toLong()
        }


        binding.about.setOnClickListener {
            findNavController().navigate(SettingFragmentDirections.actionGlobalAboutAppFragment())
        }
    }
}