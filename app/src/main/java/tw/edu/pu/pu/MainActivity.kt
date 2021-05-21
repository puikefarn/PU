    package tw.edu.pu.pu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


    class MainActivity : AppCompatActivity(),
            GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener,
            View.OnTouchListener {

        lateinit var gDetector: GestureDetector
        var PictureNo: Int = 0  //目前顯示第幾張圖
        var TotalPictures: Int = 4 //總共幾張圖片(假設僅顯示pu0-pu3)

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            gDetector = GestureDetector(this, this)
            img.setOnTouchListener(this)

            var res:Int = -1
            var countDrawables:Int = -1
            while (res != 0) {
                countDrawables++;
                res = getResources().getIdentifier("pu" + (countDrawables),
                        "drawable", getPackageName());
            }
            TotalPictures = countDrawables

        }


    fun ShowPicture() {
        /*
        when (PictureNo) {
            0 -> img.setImageResource(R.drawable.pu0)
            1 -> img.setImageResource(R.drawable.pu1)
            2 -> img.setImageResource(R.drawable.pu2)
            3 -> img.setImageResource(R.drawable.pu3)
        }
    }
     */
    var res:Int = getResources().getIdentifier("pu" + (PictureNo),
            "drawable", getPackageName())
        img.setImageResource(res)
}
        //
    override fun onLongPress(p0: MotionEvent?) {
        PictureNo = TotalPictures - 1
        ShowPicture()
    }

    override fun onShowPress(e: MotionEvent?) {
        TODO("Not yet implemented")
    }


    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        PictureNo = 0
        ShowPicture()
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }



    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        TODO("Not yet implemented")
    }



    override fun onDoubleTap(e: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }
//

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (e1.getX() < e2.getX()){  //向右快滑
            PictureNo++
            if (PictureNo == TotalPictures) {PictureNo = 0}
        }
        else{     //向左快滑
            PictureNo--;
            if (PictureNo < 0) {PictureNo = TotalPictures - 1 }
        }
        ShowPicture()
        return true
    }



}
