package com.example.team_16

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.team_16.databinding.FragmentMainpageFragmentBinding
import com.example.team_16.databinding.FragmentMypageBinding

class mainpage_fragment : Fragment() {
    var binding : FragmentMainpageFragmentBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this
        binding = FragmentMainpageFragmentBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.gotoCalendar?.setOnClickListener{
            findNavController().navigate(R.id.action_mainpage_fragment_to_calendar_fragment)
        }
        binding?.gotoStopwatch?.setOnClickListener{

            findNavController().navigate(R.id.action_mainpage_fragment_to_stopwatch)
        }
    }
}