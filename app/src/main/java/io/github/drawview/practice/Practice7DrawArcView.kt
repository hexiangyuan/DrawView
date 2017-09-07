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
class Practice7DrawArcView:View {
    constructor(context: Context):super(context)

    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet)

    constructor(context: Context,attributeSet: AttributeSet,defStyle:Int):super(context,attributeSet,defStyle)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color  = Color.BLUE
        canvas.drawArc(200f,100f,800f,500f,-90f,90f,true, paint)
        paint.style = Paint.Style.STROKE
        canvas.drawArc(200f,100f,800f,500f,20f,90f,false, paint)
    }
}