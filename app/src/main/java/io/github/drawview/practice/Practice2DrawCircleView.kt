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
class Practice2DrawCircleView : View {
    constructor(context: Context?) : super(context) {}

    constructor(context: Context?, attributeSet: AttributeSet) : super(context, attributeSet) {
    }

    constructor(context: Context?, attributeSet: AttributeSet, int: Int) : super(context, attributeSet, int) {

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        canvas.drawCircle(300f, 300f, 200f, paint)

        val paint2 = Paint()
        paint2.style = Paint.Style.STROKE
        paint2.strokeWidth = 20f
        canvas.drawCircle(800f,300f,200f,paint2)

        val paint3 = Paint(Paint.ANTI_ALIAS_FLAG)
        paint3.style = Paint.Style.FILL
        paint3.color = Color.BLUE
        canvas.drawCircle(300f,800f,200f,paint3)


        val paint4 = Paint()
        paint4.style = Paint.Style.FILL
        paint4.color = Color.BLUE
        canvas.drawCircle(800f,800f,200f,paint4)

        val paint5 = Paint()
        paint5.style = Paint.Style.STROKE
        paint5.color = Color.RED
        paint5.strokeWidth = 20f
        canvas.drawCircle(800f,800f,200f,paint5)

    }

}