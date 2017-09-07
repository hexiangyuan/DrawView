package io.github.drawview.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by hexiangyuan on 2017/9/7.
 * feature:
 */
class Practice9PieCharView : View {
    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(context, attributeSet, defStyle)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val data = floatArrayOf(0.3f, 0.25f, 0.15f, 0.1f, 0.08f, 0.06f, 0.06f)
        canvas.drawColor(Color.LTGRAY)

        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        val colors = arrayListOf<Int>(
                Color.BLUE,
                Color.CYAN,
                Color.MAGENTA,
                Color.RED,
                Color.GREEN,
                Color.YELLOW,
                Color.WHITE

        )
        var startAngle = 0f
       for(i in 0 until data.size) {
            paint.color = colors[i]
            canvas.drawArc(100f, 100f, 900f, 900f,
                    startAngle, 360f * data[i],
                    true, paint)
            startAngle += 360f * data[i]
        }


    }
}