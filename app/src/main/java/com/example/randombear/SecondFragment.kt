package com.example.randombear

import android.R
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.randombear.FirstFragment.Companion.key_cat
import com.example.randombear.databinding.FragmentSecondBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var picture_title = arguments?.getString(key_cat) ?: "meeeow"
        if (picture_title == "") {
            picture_title = "U don`t want talk with me"
        }
        val url = "https://cataas.com/cat/says/$picture_title"
        Log.i("kpop", url)




        Picasso.get()
            .load(url)
            .memoryPolicy(MemoryPolicy.NO_CACHE)
            .fit()
            .into(binding.ivCat, object : Callback {
                override fun onSuccess() {
                    binding.progress.isVisible=false
                    Log.i("ktop","onSuccess - no internet")
                }

                override fun onError(e: Exception?) {
                    Log.i("ktop","onError - no internet")

                }
            })

//        Picasso.get().load(url).memoryPolicy(MemoryPolicy.NO_CACHE).fit().placeholder( R.drawable.pr ).into(binding.ivCat)
    }

    override fun onDestroyView() {
        Log.i("kpop", "onDestroyView")
        super.onDestroyView()
        _binding = null
    }
}