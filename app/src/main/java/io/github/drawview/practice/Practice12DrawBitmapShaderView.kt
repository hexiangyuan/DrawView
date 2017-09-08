package io.github.drawview.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import io.github.drawview.R

/**
 * Created by hexiangyuan on 2017/9/8.
 * feature:
 */
class Practice12DrawBitmapShaderView : View {
    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(context, attributeSet, defStyle)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_android)
        var shaper = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        var paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.shader = shaper
        canvas.drawCircle(200f,200f,200f,paint)
    }
}