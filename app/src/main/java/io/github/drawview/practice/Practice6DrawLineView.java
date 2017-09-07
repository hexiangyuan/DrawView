package io.github.drawview.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hexiangyuan on 2017/9/7.
 * feature:
 */

public class Practice6DrawLineView extends View {
    public Practice6DrawLineView(Context context) {
        super(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画线
        Paint paint = new Paint();
        paint.setStrokeWidth(20f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(30f,30f,400f,200f, paint);
        //画圆形方块
        Paint paint1 = new Paint();
        canvas.drawRoundRect(100f,300f,500f,800f,30f,30f,paint1);
    }
}
