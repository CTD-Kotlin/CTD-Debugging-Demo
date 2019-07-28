package ladd.marshall.ctddebuggingdemo

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ButtonPushedDialog : DialogFragment() {

    private lateinit var positiveOnClick: () -> Unit

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!)
        return builder.setTitle("YOU PUSHED THE BUTTON")
            .setMessage("Do you really want to push the button?")
            .setPositiveButton("YES") {_, _ -> positiveOnClick() }
            .setNegativeButton("NO") {_, _ -> }
            .create()
    }

    companion object{
        fun newInstance(onConfirm: () -> Unit): ButtonPushedDialog {
            return ButtonPushedDialog().apply {
                positiveOnClick = onConfirm
            }
        }
    }
}