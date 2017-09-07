package io.github.drawview.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

/**
 * Created by hexiangyuan on 2017/9/7.
 * feature:
 */
class Practice8HistogramVIew : View {
    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(context, attributeSet, defStyle)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //先画背景图
        canvas.drawColor(Color.GRAY)
        //再画坐标轴
        val paintLine = Paint(Paint.ANTI_ALIAS_FLAG)
        paintLine.color = Color.WHITE
        paintLine.style = Paint.Style.STROKE
        paintLine.strokeWidth = 10f
        canvas.drawLine(20f, 20f, 20f, 530f, paintLine)
        canvas.drawLine(20f, 525f, 920f, 525f, paintLine)

        //最后画方形
        val paintRect = Paint(Paint.ANTI_ALIAS_FLAG)
        paintRect.style = Paint.Style.FILL
        paintRect.color = Color.BLUE

        val data = intArrayOf(1, 5, 20, 30, 40, 50)
        //间距
        val insert = 40
        val width = 100
        (0 until data.size)
                .map {
                    Rect(
                            insert * (it + 1) + width * it,
                            520 - data[it] * 10,
                            insert * (it + 1) + width * (it + 1),
                            520)
                }
                .forEach { canvas.drawRect(it, paintRect) }
    }
}