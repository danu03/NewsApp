package com.danusuhendra.newsapplication.view

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.danusuhendra.newsapplication.R
import com.danusuhendra.newsapplication.adapter.CategoryAdapter
import com.danusuhendra.newsapplication.model.data.Category
import com.danusuhendra.newsapplication.model.data.CategoryData
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment(){
    private var list: ArrayList<Category> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.addAll(CategoryData.listData)

        recyclerCategory.layoutManager = GridLayoutManager(context, 2)
        recyclerCategory.setHasFixedSize(true)
        val adapterCategory = CategoryAdapter(list)
        recyclerCategory.adapter = adapterCategory

        adapterCategory.setOnItemClickCallback(object : CategoryAdapter.OnClickCallback{
            override fun onItemClicked(data: Category) {
                Toast.makeText(context, "Category ${data.categorylist}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
