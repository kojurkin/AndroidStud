package com.example.lab29fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class StartFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //Если искать аналогию с активностью, то метод фрагмента onCreateView() очень похож на метод активности
    // onCreate(). И там и там, мы формируем экран за счёт XML-файла из ресурсов layout. Только в фрагментах
    // это происходит через inflate() вместо setContentView(), но суть такая же. Метод onCreateView() вызывается
    // в тот момент, когда система обращается к макету фрагмента. В большинстве случаев вы будете использовать данный
    // метод (если фрагмент используется для экранов).
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)
        val startButton = view.findViewById<Button>(R.id.start_fragment_button_start)

        startButton.setOnClickListener {
            val navController = view.findNavController()
            navController.navigate(R.id.action_startFragment_to_messageFragment)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = StartFragment()
    }
}