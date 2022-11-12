package com.example.team_16

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.team_16.databinding.FragmentEntryBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class EntryFragment : Fragment() {

    var binding : FragmentEntryBinding? = null
    lateinit var auth : FirebaseAuth
    lateinit var database : DatabaseReference


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEntryBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth= FirebaseAuth.getInstance()


        binding?.btnLogin?.setOnClickListener{
            val email = binding?.etEmail?.text.toString()
            val password = binding?.etPw?.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        Toast.makeText(activity, "로그인 성공", Toast.LENGTH_SHORT).show()

                    } else{
                        Toast.makeText(activity, "패스워드가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(activity, "모든 항목을 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }

        binding?.btnRegister?.setOnClickListener{

            findNavController().navigate(R.id.action_entryFragment3_to_signupFragment)
        }
    }
}