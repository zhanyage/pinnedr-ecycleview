package com.example.zhanyage.pinnedlib

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.zhanyage.pinnedlib.util.ScreenUtils


/**
 * Created by zhanyage on 2020/4/21
 * Describe:
 */
class PinnedItemDecoration : RecyclerView.ItemDecoration {

    private var context: Context

    private var listener:GroupListener

    private var dividerHeight: Int

    private lateinit var paint: Paint

    private lateinit var textPaint: Paint

    constructor(context: Context, listener: GroupListener) {
        this.context = context
        this.listener = listener
        dividerHeight = ScreenUtils.dp2px(context, 50)
        initPaint()
    }

    private fun initPaint() {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = context.resources.getColor(R.color.colorAccent)
        paint.style = Paint.Style.FILL

        textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint.color = context.resources.getColor(R.color.black)
        textPaint.textSize = ScreenUtils.sp2Px(context, 12).toFloat()
    }


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position: Int = parent.getChildAdapterPosition(view)
        if (position == 0 || isGroupFirst(position))
        outRect.top = dividerHeight
    }

    private fun isGroupFirst(position: Int): Boolean {
        if (position == 0) {
            return true
        } else {
            val preGroupName = listener.getGroupName(position - 1)
            val thisGroupName = listener.getGroupName(position)
            return !TextUtils.equals(preGroupName, thisGroupName);
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val count = parent.childCount
        for (i in 0..count) {
            val view = parent.getChildAt(i) ?: continue
            Log.i("PinnedItemDecoration", "onDraw" + i)
            val childAdapterPosition = parent.getChildAdapterPosition(view)
            if (isGroupFirst(childAdapterPosition)) {
                val bottom = view.top
                val top = bottom - dividerHeight
                val left = view.left
                val right = view.right
                Log.d("PinnedItemDecoration", "onDraw: top = $top,bottom = $bottom")
                c.drawRect(Rect(left, top, right, bottom), paint)

                val baseLine = (top + bottom) / 2f - (textPaint.descent() + textPaint.ascent()) / 2f
                c.drawText(listener.getGroupName(childAdapterPosition), (left + ScreenUtils.dp2px(context, 10)).toFloat(), baseLine, textPaint)
            }
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val firstVisibleView = parent.getChildAt(0)
        val firstVisiblePosition = parent.getChildAdapterPosition(firstVisibleView)

        val groupName = listener.getGroupName(firstVisiblePosition)
        val left = parent.paddingLeft
        val right = firstVisibleView.width - parent.paddingRight;

        if(firstVisibleView.bottom <= dividerHeight && isGroupFirst(firstVisiblePosition + 1)) {
            val bottom = firstVisibleView.bottom
            c.drawRect(Rect(left, 0, right, bottom), paint)
            val baseLine: Float = bottom / 2f - (textPaint.descent() + textPaint.ascent()) / 2f
            c.drawText(groupName, (left + ScreenUtils.dp2px(context, 10)).toFloat(), baseLine, textPaint)
        } else {
            val bottom = dividerHeight
            c.drawRect(Rect(left, 0, right, bottom), paint)
            val baseLine: Float = bottom / 2f - (textPaint.descent() + textPaint.ascent()) / 2f
            c.drawText(groupName, (left + ScreenUtils.dp2px(context, 10)).toFloat(), baseLine, textPaint)
        }

    }

    interface GroupListener {
        fun getGroupName(position: Int): String
    }

}