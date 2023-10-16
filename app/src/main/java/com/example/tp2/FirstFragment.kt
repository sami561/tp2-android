package com.example.tp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tp2.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var count=1
        super.onViewCreated(view, savedInstanceState)
        binding.buttonTOAST.setOnClickListener{
            val myToast=Toast.makeText(context,"hello world",Toast.LENGTH_SHORT)
            myToast.show()
        }
        binding.buttonCOUNT.setOnClickListener{
            count++
            binding.textView.text=count.toString()

        }

        binding.button3.setOnClickListener {
            val txt=binding.textView.text
            val nb=txt.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(nb)
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}