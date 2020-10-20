package com.mabnets.kotlinreceyclerview.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mabnets.kotlinreceyclerview.Network.MyApi
import com.mabnets.kotlinreceyclerview.viewmodel.MyinfoviewModel
import com.mabnets.kotlinreceyclerview.R
import com.mabnets.kotlinreceyclerview.adapter.infoadapter
import com.mabnets.kotlinreceyclerview.databinding.MyfragmentFragmentBinding
import com.mabnets.kotlinreceyclerview.models.Myinfo
import com.mabnets.kotlinreceyclerview.repo.Myinforepo
import com.mabnets.kotlinreceyclerview.viewmodelfactory.myviewmodelfactory

class Myfragment : Fragment() {

    companion object {
        fun newInstance() =
            Myfragment()
    }

    private lateinit var viewModel: MyinfoviewModel
    private lateinit var factory : myviewmodelfactory
    private  var _binding:MyfragmentFragmentBinding?=null
    private val  binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=MyfragmentFragmentBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api= MyApi()
        val repository=Myinforepo(api)
        factory=myviewmodelfactory(repository)

        viewModel = ViewModelProvider(this,factory).get(MyinfoviewModel::class.java)
        viewModel.getmydata()
        viewModel.myinfo.observe(viewLifecycleOwner, Observer {Myinfo->
            binding.rv.also {
                it.layoutManager=LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter=infoadapter(Myinfo)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null

    }
}