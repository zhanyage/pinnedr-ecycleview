package com.example.zhanyage.pinnerrecyclerview.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zhanyage.pinnerrecyclerview.R
import com.example.zhanyage.pinnerrecyclerview.bean.ContactBean


/**
 * Created by zhanyage on 2020/4/21
 * Describe:
 */
class PinnedRecyclerViewAdapter : RecyclerView.Adapter<PinnedRecyclerViewAdapter.ViewHolder> {

    private lateinit var context: Context

    private lateinit var datas: List<ContactBean>

    constructor(context: Context, datas: List<ContactBean>) {
        this.context = context
        this.datas = datas
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.viewholder_pinned_adapter_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        initializeViews(holder, datas[position])
    }

    fun initializeViews(holder: ViewHolder, bean: ContactBean) {
        holder.tvPinnedAdapterText?.text = bean.contactName
    }

    class ViewHolder : RecyclerView.ViewHolder {

        var ivPinnedAdapterImg: ImageView? = null
        var tvPinnedAdapterText: TextView? = null

        constructor (view: View) : super(view) {
            ivPinnedAdapterImg =
                view.findViewById<View>(R.id.iv_pinned_adapter_img) as ImageView
            tvPinnedAdapterText =
                view.findViewById<View>(R.id.tv_pinned_adapter_text) as TextView
        }

    }

}