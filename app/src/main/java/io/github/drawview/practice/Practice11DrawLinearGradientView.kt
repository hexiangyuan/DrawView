package io.github.drawview.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * Created by hexiangyuan on 2017/9/8.
 * feature:用来线性渐变的
 */
class Practice11DrawLinearGradientView : View {
    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(context, attributeSet, defStyle)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        Log.e("abcd","width= $widthMode + $widthSize  +\n height = $heightMode + $heightSize")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.e("abcd","width = $w  oldWidth = $oldw height = $h oldHeight = $oldh")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //线性渐变
        val shader = LinearGradient(0f, 0f, 500f, 500f,
                Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"),
                Shader.TileMode.CLAMP)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.shader = shader
        canvas.drawCircle(200f, 200f, 200f, paint)
        //中心渐变
        val radialGradient = RadialGradient(200f, 700f, 200f,
                Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"),
                Shader.TileMode.CLAMP)
        paint.shader = radialGradient
        canvas.drawCircle(200f, 700f, 200f, paint)

        //扫描渐变
        val sweepGradient = SweepGradient(200f, 1200f,
                Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"))
        paint.shader = sweepGradient
        canvas.drawCircle(200f, 1200f, 200f, paint)

    }
}