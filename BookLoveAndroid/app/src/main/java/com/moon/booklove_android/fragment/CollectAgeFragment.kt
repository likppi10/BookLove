package com.moon.booklove_android.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.moon.booklove_android.R
import com.moon.booklove_android.activity.CollectActivity
import com.moon.booklove_android.config.ApplicationClass
import com.moon.booklove_android.databinding.FragmentCollectAgeBinding
import com.moon.booklove_android.enum.enumAgeRange
import com.moon.booklove_android.enum.enumGender

class CollectAgeFragment  : Fragment(){
    private lateinit var binding: FragmentCollectAgeBinding
    private lateinit var nextButton: AppCompatButton
    var isClicked = false
    lateinit var selectedGender: String
    lateinit var selectedAgeRange: enumAgeRange

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            selectedGender = requireArguments().getString("gender").toString()
            Log.d("CollectInterestFragment", "selectedGender: ${selectedGender}")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCollectAgeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nextButton = (activity as CollectActivity).findViewById(R.id.nextStepButton)
        nextButton.setBackgroundResource(R.drawable.dark_box_rectangle)
        binding.teenagerButton.setOnClickListener {
            clickButton(binding.teenagerButton, enumAgeRange.AgeRange_10)
        }
        binding.twentiesButton.setOnClickListener {
            clickButton(binding.twentiesButton, enumAgeRange.AgeRange_20)
        }
        binding.thirtiesButton.setOnClickListener {
            clickButton(binding.thirtiesButton, enumAgeRange.AgeRange_30)
        }
        binding.fourtiesButton.setOnClickListener {
            clickButton(binding.fourtiesButton, enumAgeRange.AgeRange_40)
        }
        binding.fiftiesButton.setOnClickListener {
            clickButton(binding.fiftiesButton, enumAgeRange.AgeRange_50)
        }

        nextButton.setOnClickListener {
            //companion object에 age 저장

            if(isClicked){
                when(selectedAgeRange) {
                    enumAgeRange.AgeRange_10 -> (activity as CollectActivity).openFragment(2,selectedGender, 10)
                    enumAgeRange.AgeRange_20 -> (activity as CollectActivity).openFragment(2,selectedGender, 20)
                    enumAgeRange.AgeRange_30 -> (activity as CollectActivity).openFragment(2,selectedGender, 30)
                    enumAgeRange.AgeRange_40 -> (activity as CollectActivity).openFragment(2,selectedGender, 40)
                    enumAgeRange.AgeRange_50 -> (activity as CollectActivity).openFragment(2,selectedGender, 50)
                }
            }else{
                Toast.makeText(context, "연령대를 선택해주세요", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun clickButton(clickedButton: AppCompatButton, enumAgeRange: enumAgeRange){
        isClicked = true
        binding.teenagerButton.setBackgroundResource(R.drawable.light_box_rectangle)
        binding.twentiesButton.setBackgroundResource(R.drawable.light_box_rectangle)
        binding.thirtiesButton.setBackgroundResource(R.drawable.light_box_rectangle)
        binding.fourtiesButton.setBackgroundResource(R.drawable.light_box_rectangle)
        binding.fiftiesButton.setBackgroundResource(R.drawable.light_box_rectangle)
        clickedButton.setBackgroundResource(R.drawable.dark_box_rectangle)
        nextButton.setBackgroundResource(R.drawable.complete_rectangle)
        selectedAgeRange = enumAgeRange
    }

    companion object {

        private const val gender = "gender"
        private const val ageRange = "ageRange"

        @JvmStatic
        fun newInstance(param1: String, param2: Int) =
            CollectAgeFragment().apply {
                arguments = Bundle().apply {
                    putString(gender, param1)
                    putInt(ageRange, param2)
                }
            }
    }


}