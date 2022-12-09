package com.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.data.UsefulActivitiesRepository
import com.domain.GetUsefulActivityUseCase
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.zip.Inflater
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    var repository = UsefulActivitiesRepository()
    var useCase = GetUsefulActivityUseCase(repository)

    val viewModel: MainViewModel by viewModels {MyViewModelFactory(useCase)}
    lateinit var binding:FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        binding.message.text = viewModel.useCase.execute().activity.toString()

        binding.button.setOnClickListener {
        lifecycleScope.launchWhenStarted {
            viewModel.reloadUsefulActivity()
        }

        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                when(it){
                    is State.Error -> {

                    }
                    State.Loading -> {
                        binding.progress.visibility = View.VISIBLE
                    }
                    is State.Success -> {
                        binding.progress.visibility = View.INVISIBLE
                        binding.message.text =it.useCaseActivity.activity.toString()
                    }
                }

            }
        }

        return binding.root
    }

}