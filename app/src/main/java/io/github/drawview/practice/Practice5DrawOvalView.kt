package io.github.drawview.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by hexiangyuan on 2017/9/7.
 * feature:
 */
class Practice5DrawOvalView :View{
    constructor(context: Context):super(context)

    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet)

    constructor(context: Context,attributeSet: AttributeSet,defStyle:Int):super(context,attributeSet,defStyle)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawOval(100f,100f,600f,400f, Paint())
    }
}