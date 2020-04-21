package com.example.zhanyage.pinnedlib.util

import android.content.Context
import android.util.TypedValue




/**
 * Created by zhanyage on 2020/4/21
 * Describe:
 */
class ScreenUtils {

    companion object {
        fun dp2px(context: Context, dpValue: Int): Int {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dpValue.toFloat(),
                context.resources.displayMetrics
            ).toInt()
        }

        fun sp2Px(context: Context, spValue: Int): Int {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP,
                spValue.toFloat(),
                context.resources.displayMetrics
            ).toInt()
        }

    }

}