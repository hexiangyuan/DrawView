package io.github.drawview.practice

import android.content.Context
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import android.view.ViewDebug

/**
 * Created by hexiangyuan on 2017/9/8.
 * feature:
 */
class Practice14BezierCircleView : View {

    private var radius: Float //点点的半径
    private val c = 0.552284749831
    //Bezier 画圆的时候的系数
    // https://stackoverflow.com/questions/1734745/how-to-create-circle-with-b%C3%A9zier-curves

    private var w: Float = 0f
    private var h: Float = 0f
    private var centerPoint: PointF


    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(context, attributeSet, defStyle)

    init {
        radius = 80f
        centerPoint = PointF()

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        this.w = w.toFloat()
        this.h = h.toFloat()
        this.centerPoint.x = w / 2f
        this.centerPoint.y = h / 2f
    }


    class XControl(x: Float, y: Float) {
        val pL: PointF
        val p: PointF
        val pR: PointF
        var c = 0f

        init {
            p = PointF(x, y)
            pL = PointF(x - c, y)
            pR = PointF(x + c, y)
        }


    }

    class YControl(x: Float, y: Float) {
        val pT: PointF
        val p: PointF
        val pB: PointF
        var c: Float = 0f

        init {
            p = PointF(x, y)
            pT = PointF(x, y - c)
            pB = PointF(x, y + c)
        }
    }
}
