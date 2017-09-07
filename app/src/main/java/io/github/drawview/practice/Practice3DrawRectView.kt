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
class Practice3DrawRectView:View {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        canvas.drawRect(100f,100f,400f,300f, paint)

        val paint1 = Paint()
        paint1.style = Paint.Style.STROKE
        paint1.color = Color.RED
        paint1.strokeWidth = 20f
        canvas.drawRect(500f,100f,800f,300f, paint1)

        val pain2 = Paint(Paint.ANTI_ALIAS_FLAG)
        pain2.style = Paint.Style.FILL
        pain2.color = Color.BLUE
        val rect = Rect(100, 400, 400, 600)
        canvas.drawRect(rect,pain2)

        val paint3 = Paint()
        paint3.style = Paint.Style.STROKE
        paint3.color = Color.RED
        paint3.strokeWidth = 20f
        canvas.drawRect(500f,400f,800f,600f, paint3)

        val pain4 = Paint(Paint.ANTI_ALIAS_FLAG)
        pain4.style = Paint.Style.FILL
        pain4.color = Color.BLUE
        val rect1 = Rect(500, 400, 800, 600)
        canvas.drawRect(rect1,pain2)
    }

}