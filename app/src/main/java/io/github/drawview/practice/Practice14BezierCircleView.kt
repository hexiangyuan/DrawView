package io.github.drawview.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewDebug
import android.view.animation.Animation
import android.view.animation.Transformation
import android.view.animation.AccelerateDecelerateInterpolator


/**
 * Created by hexiangyuan on 2017/9/8.
 * feature:
 */
class Practice14BezierCircleView : View {

    private var radius: Float //点点的半径
    private val circleBezier = 0.552284749831f
    //Bezier 画圆的时候的系数
    // https://stackoverflow.com/questions/1734745/how-to-create-circle-with-b%C3%A9zier-curves

    private var w: Float = 0f
    private var h: Float = 0f
    private var c: Float = 0f
    private var centerPoint: PointF
    private var startPoint = PointF()
    private var endPoint = PointF()

    private var animateDuration = 1.0f
    private var currentAnimate = 0.0f
    private val mPaint: Paint
    private var duration: Float = 0.0f

    private lateinit var circle: CircleBezier

    private var path: Path

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(context, attributeSet, defStyle)

    init {
        radius = 50f
        centerPoint = PointF()
        c = radius * circleBezier
        mPaint = Paint()
        mPaint.color = 0xFFfe626d.toInt()
        mPaint.style = Paint.Style.FILL
        mPaint.strokeWidth = 1.0f
        mPaint.isAntiAlias = true
        path = Path()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        this.w = w.toFloat()
        this.h = h.toFloat()
        this.centerPoint.x = w / 2f
        this.centerPoint.y = h / 2f
        this.startPoint = PointF(radius, centerPoint.y)
        this.endPoint = PointF(this.w - radius, centerPoint.y)
        duration = endPoint.x - startPoint.x
        circle = CircleBezier(PointF(startPoint.x, startPoint.y), radius, c)
                .createCircle()
    }

    private var timeOld: Float = 0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        path.reset()
        if (currentAnimate > 0 && currentAnimate <= 0.2f * animateDuration) {
            val offset = radius * 0.8f * (currentAnimate - timeOld) / 0.2f * animateDuration
            circle.p2.offset(offset, 0f)
            circle.p2T.x = circle.p2.x
            circle.p2B.x = circle.p2.x
        } else if (currentAnimate > 0.2f * animateDuration && currentAnimate <= 0.4f * animateDuration) {
            val p0Offset = radius * 0.8f * (timeOld - currentAnimate) / 0.2f * animateDuration
            val moveOffset = duration * currentAnimate / animateDuration + startPoint.x
            circle.moveTo(moveOffset, circle.p.y)
            circle.p0.offset(p0Offset, 0f)
            circle.p0T.x = circle.p0.x
            circle.p0B.x = circle.p0.x
            val p3Offset = radius * 0.2f * (timeOld - currentAnimate) / 0.2f * animateDuration
            val p1Offset = radius * 0.2f * (currentAnimate - timeOld) / 0.2f * animateDuration
            circle.p1.offset(0f, p1Offset)
            circle.p1L.offset(0f, p1Offset)
            circle.p1R.offset(0f, p1Offset)
            circle.p3.offset(0f, p3Offset)
            circle.p3L.offset(0f, p3Offset)
            circle.p3R.offset(0f, p3Offset)

        } else if (currentAnimate > 0.4f * animateDuration && currentAnimate <= 0.7f * animateDuration) {
            val moveOffset = duration * currentAnimate / animateDuration + startPoint.x
            circle.moveTo(moveOffset, circle.p.y)
            val offset = 0 - radius * 0.8f * (currentAnimate - timeOld) / 0.3f * animateDuration
            circle.p2.offset(offset, 0f)
            circle.p2T.x = circle.p2.x
            circle.p2B.x = circle.p2.x
            val p1Offset = radius * 0.2f * (timeOld - currentAnimate) / 0.3f * animateDuration
            val p3Offset = radius * 0.2f * (currentAnimate - timeOld) / 0.3f * animateDuration
            circle.p1.offset(0f, p1Offset)
            circle.p1L.offset(0f, p1Offset)
            circle.p1R.offset(0f, p1Offset)
            circle.p3.offset(0f, p3Offset)
            circle.p3L.offset(0f, p3Offset)
            circle.p3R.offset(0f, p3Offset)

        } else if (currentAnimate > 0.7f * animateDuration && currentAnimate <= 0.9f * animateDuration) {
            val moveOffset = duration * currentAnimate / animateDuration + startPoint.x
            circle.moveTo(moveOffset, circle.p.y)
            val p0Offset = radius * 1.0f * (currentAnimate - timeOld) / 0.2f * animateDuration
            circle.p0.offset(p0Offset, 0f)
            circle.p0T.x = circle.p0.x
            circle.p0B.x = circle.p0.x
        } else if (currentAnimate > 0.9f * animateDuration && currentAnimate <= animateDuration) {
            val moveOffset = duration * currentAnimate / animateDuration + startPoint.x
            circle.moveTo(moveOffset, circle.p.y)
            val p0Offset = radius * 0.2f * (timeOld - currentAnimate) / 0.1f * animateDuration
            circle.p0.offset(p0Offset, 0f)
            circle.p0T.x = circle.p0.x
            circle.p0B.x = circle.p0.x
        }
        timeOld = currentAnimate
        path.moveTo(circle.p0.x, circle.p0.y)
        path.cubicTo(circle!!.p0T.x, circle!!.p0T.y,
                circle!!.p1L.x, circle!!.p1L.y,
                circle!!.p1.x, circle!!.p1.y)
        path.cubicTo(circle!!.p1R.x, circle!!.p1R.y,
                circle!!.p2T.x, circle!!.p2T.y,
                circle!!.p2.x, circle!!.p2.y)
        path.cubicTo(circle!!.p2B.x, circle!!.p2B.y,
                circle!!.p3R.x, circle!!.p3R.y,
                circle!!.p3.x, circle!!.p3.y)
        path.cubicTo(circle!!.p3L.x, circle!!.p3L.y,
                circle!!.p0B.x, circle!!.p0B.y,
                circle!!.p0.x, circle!!.p0.y)
        canvas.drawPath(path, mPaint)
    }

    fun startAnimate() {
        path.reset()
        circle = CircleBezier(PointF(startPoint.x, startPoint.y), radius, c)
                .createCircle()
        currentAnimate = 0f
        val move = MoveAnimate()
        move.duration = (animateDuration * 1000).toLong()
        move.interpolator = AccelerateDecelerateInterpolator()
        //move.setRepeatCount(Animation.INFINITE);
        //move.setRepeatMode(Animation.REVERSE);
        startAnimation(move)
    }

    inner class MoveAnimate : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            super.applyTransformation(interpolatedTime, t)
            currentAnimate = interpolatedTime
            invalidate()
        }
    }

    class CircleBezier(var p: PointF, var r: Float, var c: Float) {
        var p0: PointF = PointF()
        var p0T: PointF = PointF()
        var p0B: PointF = PointF()
        var p1: PointF = PointF()
        var p1R: PointF = PointF()
        var p1L: PointF = PointF()
        var p2: PointF = PointF()
        var p2T: PointF = PointF()
        var p2B: PointF = PointF()
        var p3: PointF = PointF()
        var p3L: PointF = PointF()
        var p3R: PointF = PointF()

        fun createCircle(): CircleBezier {
            p0 = PointF(p.x - r, p.y)
            p0T = PointF(p0.x, p0.y - c)
            p0B = PointF(p0.x, p0.y + c)

            p1 = PointF(p.x, p.y - r)
            p1L = PointF(p1.x - c, p1.y)
            p1R = PointF(p1.x + c, p1.y)

            p2 = PointF(p.x + r, p.y)
            p2T = PointF(p2.x, p2.y - c)
            p2B = PointF(p2.x, p2.y + c)

            p3 = PointF(p.x, p.y + r)
            p3L = PointF(p3.x - c, p3.y)
            p3R = PointF(p3.x + c, p3.y)
            return this
        }

        fun offset(x: Float, y: Float) {
            p.offset(x, y)
            p0.offset(x, y)
            p0T.offset(x, y)
            p0B.offset(x, y)
            p1.offset(x, y)
            p1L.offset(x, y)
            p1R.offset(x, y)
            p2.offset(x, y)
            p2T.offset(x, y)
            p2B.offset(x, y)
            p3.offset(x, y)
            p3L.offset(x, y)
            p3R.offset(x, y)
        }

        fun moveTo(x: Float, y: Float) {
            val offsetX = x - p.x
            val offsetY = y - p.y
            offset(offsetX, offsetY)
        }
    }

}
