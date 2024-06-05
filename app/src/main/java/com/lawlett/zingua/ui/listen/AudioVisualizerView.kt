package com.lawlett.zingua.ui.listen

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.media.audiofx.Visualizer
import android.util.AttributeSet
import android.view.View

class AudioVisualizerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        strokeWidth = 5f
        isAntiAlias = true
        color = context.getColor(android.R.color.holo_blue_bright)
    }

    private var visualizer: Visualizer? = null
    private var waveform = ByteArray(0)

    fun link(audioSessionId: Int) {
        visualizer = Visualizer(audioSessionId).apply {
            captureSize = Visualizer.getCaptureSizeRange()[1]
            setDataCaptureListener(object : Visualizer.OnDataCaptureListener {
                override fun onWaveFormDataCapture(
                    visualizer: Visualizer?,
                    bytes: ByteArray?,
                    samplingRate: Int
                ) {
                    bytes?.let {
                        waveform = it
                        invalidate()
                    }
                }

                override fun onFftDataCapture(
                    visualizer: Visualizer?,
                    bytes: ByteArray?,
                    samplingRate: Int
                ) {}
            }, Visualizer.getMaxCaptureRate() / 2, true, false)
            enabled = true
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas?.let {
            val height = height
            val width = width
            for (i in waveform.indices) {
                val x = width * i / waveform.size.toFloat()
                val y = height / 2 + (waveform[i] + 128).toFloat() * height / 512
                it.drawLine(x, height / 2f, x, y, paint)
            }
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        visualizer?.release()
    }
}
