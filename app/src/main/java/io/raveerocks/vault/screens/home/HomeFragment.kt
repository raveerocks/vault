package io.raveerocks.vault.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import io.raveerocks.vault.R
import io.raveerocks.vault.databinding.FragmentHomeBinding
import io.raveerocks.vault.databinding.TextItemBinding
import io.raveerocks.vault.views.HomeView

class HomeFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        var gridLayout:GridLayout = binding.list

        val homeView : HomeView = ViewModelProvider(this).get(HomeView::class.java)
        homeView.items.observe(viewLifecycleOwner) {
            it.forEach{ item ->
                if (item is HomeView.Note){
                    val itemTag = DataBindingUtil.inflate<TextItemBinding>(inflater,R.layout.text_item,container,false)
                    setLayout(R.drawable.note,itemTag, item, gridLayout)
                }
                else if (item is HomeView.Number){
                    val itemTag = DataBindingUtil.inflate<TextItemBinding>(inflater,R.layout.text_item,container,false)
                    setLayout(R.drawable.number,itemTag, item, gridLayout)
                }
                else if (item is HomeView.BoardingPass){
                    val itemTag = DataBindingUtil.inflate<TextItemBinding>(inflater,R.layout.text_item,container,false)
                    setLayout(R.drawable.flight,itemTag, item, gridLayout)
                }
                else if (item is HomeView.Gift){
                    val itemTag = DataBindingUtil.inflate<TextItemBinding>(inflater,R.layout.text_item,container,false)
                    setLayout(R.drawable.gift,itemTag, item, gridLayout)
                }
                else if (item is HomeView.Location){
                    val itemTag = DataBindingUtil.inflate<TextItemBinding>(inflater,R.layout.text_item,container,false)
                    setLayout(R.drawable.location,itemTag, item, gridLayout)
                }
            }
        }

        binding.addItemButton?.setOnClickListener(){

        }
        return binding.root

    }

    private fun setLayout(
        logo: Int,
        itemTag: TextItemBinding,
        item: HomeView.Item,
        gridLayout: GridLayout
    ) {
        itemTag.imageItem.setImageResource(logo)
        itemTag.textItem.text = item.name
        itemTag.container.setOnClickListener {
            this.findNavController()
                .navigate(HomeFragmentDirections.actionListFragmentToDetailFragment())
        }
        gridLayout.addView(itemTag.root)
    }
}