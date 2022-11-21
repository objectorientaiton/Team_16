package com.example.team_16

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.example.team_16.databinding.FragmentMypageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MypageFragment : Fragment() {

    var binding : FragmentMypageBinding? = null
    lateinit var auth : FirebaseAuth
    lateinit var database : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageBinding.inflate(inflater)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

// val department_data = arrayOf("경영학부","항공교통물류학부","항공운항학과","항공우주 및 기계공학부", "항공전자정보공학부", "소프트웨어학과", "스마트드론공학과", "AI자율주행시스템공학과", "자유전공학부")


        binding?.btnRegisterMypage?.setOnClickListener{
            val email = binding?.etEmailMypage?.text.toString()
            val nickname = binding?.etNickname?.text.toString()
            val name = binding?.etName?.text.toString()
            val department = binding?.spDep?.selectedItem.toString()
            val kauid = binding?.etKauID?.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User_Model(email, nickname, name, department, kauid)


            database.child(nickname).setValue(User).addOnSuccessListener {
                binding?.etEmailMypage?.text?.clear()
                binding?.etNickname?.text?.clear()
                binding?.etName?.text?.clear()
                binding?.etKauID?.text?.clear()

                findNavController().navigate(R.id.action_mypageFragment_to_entryFragment3)

                Toast.makeText(activity, "정보가 입력 되었습니다.",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(activity, "정보를 다시 입력하세요.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}