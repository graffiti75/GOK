package br.cericatto.gok.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.cericatto.gok.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    //--------------------------------------------------
    // Fragment Life Cycle
    //--------------------------------------------------

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        val binding = FragmentHomeBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment.
        binding.lifecycleOwner = this

        // Giving the binding access to the HomeViewModel.
        binding.viewModel = viewModel

        // Live Data.
        viewModel.getGokData()
        observeDisplayDataOnUI()

        return binding.root
    }

    //--------------------------------------------------
    // Live Data Methods
    //--------------------------------------------------

    private fun observeDisplayDataOnUI() {
        viewModel.displayDataOnUI.observe(viewLifecycleOwner, {
            if (null != it) {
                val a = it
                val b = 2
            }
        })
    }
}