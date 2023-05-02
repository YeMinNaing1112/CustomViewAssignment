package com.yeminnaing.customviewassignment.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.yeminnaing.customviewassignment.R

class StraightProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var contextCircular = context

    companion object {
        private const val DEFAULT_PROGRESS = 0
        private const val DEFAULT_PROGRESS_MAX = 0
    }

    private var trackColor = contextCircular?.let { ContextCompat.getColor(it,R.color.colorAccent) } ?: 0
    private var indicatorColor = contextCircular?.let { ContextCompat.getColor(it,R.color.colorPrimaryLight) } ?: 0
    private var progress = DEFAULT_PROGRESS
    private var progressMax = DEFAULT_PROGRESS_MAX

    private val paintForIndicatorColor = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = indicatorColor
        style = Paint.Style.FILL
        strokeWidth = 10f
    }

    private val paintForTrackColor = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = trackColor
        style = Paint.Style.FILL
        strokeWidth = 10f
    }



    init {
        setUpAttributes(attrs)
    }

    private fun setUpAttributes(attrs: AttributeSet?) {
        context.withStyledAttributes(attrs, R.styleable.CustomProgressBar){
            trackColor = getColor(R.styleable.CustomProgressBar_customTrackColor, trackColor)
            indicatorColor = getColor(R.styleable.CustomProgressBar_customIndicatorColor, indicatorColor)
            progress = getInteger(R.styleable.CustomProgressBar_customProgress, DEFAULT_PROGRESS)
            progressMax = getInteger(R.styleable.CustomProgressBar_customProgressMax, DEFAULT_PROGRESS_MAX)
        }
    }

    override fun onDraw(canvas: Canvas?) {

        canvas?.drawLine(0f,0f,width.toFloat()*progressMax,0f,paintForIndicatorColor)
        canvas?.drawLine(0f,0f, progress.toFloat(),0f,paintForTrackColor)

        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val size = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(size,size)
    }
}