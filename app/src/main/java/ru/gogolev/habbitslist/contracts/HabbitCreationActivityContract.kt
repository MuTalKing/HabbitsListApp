package ru.gogolev.habbitslist.contracts

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import ru.gogolev.habbitslist.HabbitCreationActivity
import ru.gogolev.habbitslist.dto.Habbit


class HabbitCreationActivityContract: ActivityResultContract<Unit, Habbit>() {

    override fun createIntent(context: Context, input: Unit?): Intent {
        return Intent(context, HabbitCreationActivity::class.java)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Habbit? {
        return if (Activity.RESULT_OK != resultCode) null
        else intent!!.extras!!.getParcelable("output")
    }
}