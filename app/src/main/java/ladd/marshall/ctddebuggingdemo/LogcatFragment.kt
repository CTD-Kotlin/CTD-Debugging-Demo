package ladd.marshall.ctddebuggingdemo


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_logcat.*

/**
 * A demonstration of different log levels and debugging
 * using breakpoints.
 *
 * @author Marshall Ladd
 */
class LogcatFragment : Fragment() {

    // Holds the number of times the button has been pushed.
    var numberOfPushes = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Debug level Logcat message
        Log.d(this.javaClass.name, "Now in onCreateView() numberOfPushes = $numberOfPushes")

        return inflater.inflate(R.layout.fragment_logcat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Debug Logcat message
        Log.d(this.javaClass.name, "Now in onViewCreated() numberOfPushes = $numberOfPushes")

        // Set the initial value of the text
        updateUI()

        // Tell the button what to do when it is clicked.
        buttonDontPush.setOnClickListener {

            // Warn Logcat message
            Log.w(this.javaClass.name, "UH-OH, Someone tried to push the button.")

            // Create a confirmation DialogFragment and shows it
            val alert = ButtonPushedDialog.newInstance { buttonPushed() }
            fragmentManager?.let { alert.show(it, "ButtonPushedAlert") }
        }
    }

    // update the text value in the UI to show the number of times the button has been pushed
    private fun updateUI() {
        Log.d(this.javaClass.name, "Now in updateUI() numberOfPushes = $numberOfPushes")

        textViewNumber.text = "$numberOfPushes"

        frameLayout.setBackgroundColor(
            when {
                numberOfPushes.isEven() -> Color.GRAY
                else -> Color.WHITE
            }
        )
    }

    // What to do when the button is pushed and confirmed in the DialogFragment
    private fun buttonPushed() {
        // Error level Logcat message

        // Increment the value of
        numberOfPushes++
        Log.e(this.javaClass.name, "SOMEONE PUSHED THE BUTTON!!! numberOfPushes = $numberOfPushes")

        // Comment out the above increment lines and un comment the 'if' statement
        // Use breakpoints and the debugger to figure out what's going wrong here
//        if (numberOfPushes++ >= 2) Log.wtf(
//            this.javaClass.name,
//            "THEY PUSHED THE BUTTON $numberOfPushes TIMES NOW!!!"
//        )

        // update the text with the new value
        updateUI()
    }


}
