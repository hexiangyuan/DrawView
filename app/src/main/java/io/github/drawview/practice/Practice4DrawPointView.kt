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
class Practice4DrawPointView: View {

    constructor(context: Context):super(context)

    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet)

    constructor(context: Context,attributeSet: AttributeSet,defStyle:Int):super(context,attributeSet,defStyle)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.BLACK
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = 40f
        canvas.drawPoint(100f,100f, paint)

        val paint2  = Paint(Paint.ANTI_ALIAS_FLAG)
        paint2.strokeWidth = 40f
        paint2.color = Color.BLUE
        paint2.strokeCap = Paint.Cap.SQUARE
        canvas.drawPoint(300f,100f,paint2)
    }

}