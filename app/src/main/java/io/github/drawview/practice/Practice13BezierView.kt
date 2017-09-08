package io.github.drawview.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Created by hexiangyuan on 2017/9/8.
 * feature:
 */
class Practice13BezierView : View {
    private val paint: Paint
    private val start: Point
    private val end: Point
    private val control: Point

    init {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.style = Paint.Style.STROKE
        start = Point()
        end = Point()
        control = Point()
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(context, attributeSet, defStyle)


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        start.x = w / 4
        start.y = h / 4 * 3
        end.x = w / 4 * 3
        end.y = w / 4 * 3

        control.x = w / 2
        control.y = h / 4
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        control.x = event.x.toInt()
        control.y = event.y.toInt()
        invalidate()
        return super.onTouchEvent(event)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //画出辅助线
        paint.color = Color.GRAY
        paint.strokeWidth = 5f
        canvas.drawLine(start.x.toFloat(),
                start.y.toFloat(),
                control.x.toFloat(),
                control.y.toFloat(),
                paint)
        canvas.drawLine(control.x.toFloat(),
                control.y.toFloat(),
                end.x.toFloat(),
                end.y.toFloat(),
                paint)

        //先画出三个点点
        paint.color = Color.BLACK
        paint.strokeWidth = 20f
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawPoint(start.x.toFloat(), start.y.toFloat(), paint)
        canvas.drawPoint(end.x.toFloat(), end.y.toFloat(), paint)
        canvas.drawPoint(control.x.toFloat(), control.y.toFloat(), paint)

        //画出贝塞尔取现
        paint.color = Color.RED
        paint.strokeWidth = 8f

        val path = Path()

        path.moveTo(start.x.toFloat(), start.y.toFloat())
        path.quadTo(control.x.toFloat(),
                control.y.toFloat(),
                end.x.toFloat(),
                end.y.toFloat())
        canvas.drawPath(path, paint)
    }


}