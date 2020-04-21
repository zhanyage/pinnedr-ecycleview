package com.example.zhanyage.pinnerrecyclerview.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zhanyage.pinnedlib.PinnedItemDecoration
import com.example.zhanyage.pinnerrecyclerview.R
import com.example.zhanyage.pinnerrecyclerview.adapter.PinnedRecyclerViewAdapter
import com.example.zhanyage.pinnerrecyclerview.bean.ContactBean
import kotlinx.android.synthetic.main.activity_pinned_test.*

/**
 * Created by zhanyage on 2020/4/21
 * Describe:
 */
class PinnedTestActivity: Activity() {

    private var datas = ArrayList<ContactBean>()
    private lateinit var adapter: PinnedRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pinned_test)
        initView()
        getDatas()
    }

    private fun initView() {
        adapter = PinnedRecyclerViewAdapter(this, datas)
        rv_pinned_activity_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_pinned_activity_list.adapter = adapter
        rv_pinned_activity_list.addItemDecoration(PinnedItemDecoration(this, object: PinnedItemDecoration.GroupListener {
            override fun getGroupName(position: Int): String {
                return datas[position].contactName[0].toString()
            }
        }))
    }

    private fun getDatas() {
        datas.add(ContactBean("aaaaa"))
        datas.add(ContactBean("aaaab"))
        datas.add(ContactBean("aaaac"))
        datas.add(ContactBean("aaaad"))
        datas.add(ContactBean("aaaae"))
        datas.add(ContactBean("baaaf"))
        datas.add(ContactBean("baaag"))
        datas.add(ContactBean("baaah"))
        datas.add(ContactBean("baaai"))
        datas.add(ContactBean("baaaj"))
        datas.add(ContactBean("caaak"))
        datas.add(ContactBean("caaal"))
        datas.add(ContactBean("caaam"))
        datas.add(ContactBean("caaan"))
        datas.add(ContactBean("caaao"))
        datas.add(ContactBean("daaap"))
        datas.add(ContactBean("daaaq"))
        datas.add(ContactBean("daaar"))
        datas.add(ContactBean("dbbbb"))
        datas.add(ContactBean("dbbbb"))
        datas.add(ContactBean("ebbbb"))
        datas.add(ContactBean("ebbbb"))
        datas.add(ContactBean("ebbbb"))
        datas.add(ContactBean("ebbbb"))
        datas.add(ContactBean("ebbbb"))
        datas.add(ContactBean("fbbbb"))
        datas.add(ContactBean("fbbbb"))
        datas.add(ContactBean("fbbbb"))
        datas.add(ContactBean("fbbbb"))
        datas.add(ContactBean("fbbbb"))
        datas.add(ContactBean("fbbbb"))
        datas.add(ContactBean("gbbbb"))
        datas.add(ContactBean("gbbbb"))
        adapter.notifyDataSetChanged()
    }
}