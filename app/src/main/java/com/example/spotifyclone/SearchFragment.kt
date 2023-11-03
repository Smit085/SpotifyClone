package com.example.spotifyclone

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.spotifyclone.databinding.FragmentSearchBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.button.MaterialButton
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)

        if (!viewModel.genres_dataFetched) {
            fetchDataFromFirestore()
        } else {
            setupRecyclerViews()
        }

        binding.btnSearch.setOnClickListener {
            val fragmentManager = (context as MainActivity).supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frag_container, SearchbarFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        return binding.root
    }

    private fun fetchDataFromFirestore() {
        val db = FirebaseFirestore.getInstance()
        val collectionPath = "genres"

        db.collection(collectionPath)
            .get()
            .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val data = document.data
                        val bgColor = data["bg_color"] as String
                        val imgurl = data["image"] as String
                        val name = data["name"] as String
                        viewModel.arrCatg.add(CategoryCardModel(imgurl, name, bgColor))
                    }
                    viewModel.genres_dataFetched = true
                    setupRecyclerViews()
                } else {
                    Log.e("TAG", "Error fetching documents: ${task.exception}")
                }
            })
    }

    private fun setupRecyclerViews() {
        val arrayList1 = ArrayList(viewModel.arrCatg.take(3))
        val arrayList2 = ArrayList(viewModel.arrCatg.drop(3))

        val adapter1 = RecyclerCategoryAdapter(requireContext(), arrayList1)
        val adapter2 = RecyclerCategoryAdapter(requireContext(), arrayList2)

        binding.recyclerView1.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView1.adapter = adapter1

        binding.recyclerView2.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView2.adapter = adapter2
    }
}
