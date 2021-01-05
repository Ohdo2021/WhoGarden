package com.ohdo.whogarden.chattingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import com.ohdo.whogarden.R
import com.ohdo.whogarden.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        DoToolBar()

        var data: MutableList<ChattingListData> = setData()  //데이터 받아올 때 수정해야 함
        var adapter = ChattingListAdapter()
        adapter.listData = data
        binding.mainRecyclerView.adapter = adapter
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun DoToolBar() {
        setSupportActionBar(binding.toolbar)
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_launcher_foreground)
        }

        binding.mainNaviView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener {
            it.isChecked = true
            binding.mainDrawerLayout.closeDrawers()

            true
        })

    }

    // 아직 데이터 없어서 임의로 만든 함수
    private fun setData() : MutableList<ChattingListData> {
        var data: MutableList<ChattingListData> = mutableListOf()
        for (num in 1..3) {
            var img = ResourcesCompat.getDrawable(resources, R.drawable.testimg, null)
            var name = "${num}번째 식물"
            var msg = "사진을 보냈습니다."
            var time = "16:07"

            var listdata = img?.let { ChattingListData(it, name, msg, time) }
            if (listdata != null) {
                data.add(listdata)
            }
        }
        return data
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.main_menu_btn -> {
                binding.mainDrawerLayout.openDrawer(GravityCompat.START)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }
}