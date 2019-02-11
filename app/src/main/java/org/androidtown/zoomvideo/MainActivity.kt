package org.androidtown.zoomvideo

import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Surface
import android.view.TextureView
import android.widget.FrameLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val path:String = "https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_1mb.mp4"

    private var m_CustomView : ZoomableTextureView? = null
    private var m_Frame : FrameLayout? =null
    private var m_FrameText : TextView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        m_CustomView = findViewById(R.id.customview)
        m_Frame = findViewById(R.id.zoomlayout)
        m_FrameText = findViewById(R.id.zoom_rate)


        m_CustomView?.surfaceTextureListener = object : TextureView.SurfaceTextureListener{

            override fun onSurfaceTextureAvailable(surface: SurfaceTexture?, width: Int, height: Int) {
                var mediaPlayer : MediaPlayer =  MediaPlayer()
                mediaPlayer.setSurface(Surface(surface))

                mediaPlayer.setDataSource(path)
                mediaPlayer.prepare()
                mediaPlayer.start()
            }

            override fun onSurfaceTextureUpdated(surface: SurfaceTexture?) {
            }

            override fun onSurfaceTextureDestroyed(surface: SurfaceTexture?): Boolean {
                return false
            }
            override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture?, width: Int, height: Int) {
            }
        }

        m_CustomView?.setzoomlayout(m_Frame,m_FrameText)

    }
}
