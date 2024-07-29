package com.example.newsapp.presentation.main_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentMainBinding
import com.example.newsapp.presentation.main_fragment.adapter.NewsAdapter
import com.example.newsapp.presentation.main_fragment.adapter.decoration.NewsItemDecoration
import com.example.newsapp.presentation.ui_model.NewsUiModel
import com.example.newsapp.presentation.util.gone
import com.example.newsapp.presentation.util.showToast
import com.example.newsapp.presentation.util.toPx
import com.example.newsapp.presentation.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = requireNotNull(_binding)

    private val vm: MainViewModel by viewModels()

    private val adapter: NewsAdapter by lazy {
        NewsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        initListeners()
    }

    private fun setupRecyclerView() {
        binding.rvNews.addItemDecoration(
            DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        )
        binding.rvNews.addItemDecoration(
            NewsItemDecoration(bottomOffset = 16f.toPx(), topOffset = 16f.toPx())
        )
        binding.rvNews.adapter = adapter
    }

    private fun initListeners() {
        vm.state.observe(viewLifecycleOwner) { result ->
            if (result.isLoading) startLoading()
            else {
                if (result.error.isNotBlank())
                    showError(result.error)
                else showData(result.news)
            }
        }
    }

    private fun startLoading() {
        binding.progressBar.visible()
        binding.rvNews.gone()
    }

    private fun showData(data: List<NewsUiModel>) {
        if (data.isNotEmpty()) {
            adapter.submitList(data)
            binding.rvNews.visible()
            binding.progressBar.gone()
        } else showToast(getString(R.string.nothing_to_show))
    }

    private fun showError(error: String) {
        binding.progressBar.gone()
        showToast(getString(R.string.error) + error)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}