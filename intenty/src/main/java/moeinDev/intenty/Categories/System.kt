package moeinDev.intenty.Categories

import android.Manifest
import android.content.Context
import android.content.Intent
import android.support.annotation.RequiresPermission


/*
This class simplifies using system Intents 👾
More information:
https://developer.android.com/guide/components/intents-common
 */
class System(val context: Context) {
    /*
    Set Alarm intent:
    Intent filters:
    <intent-filter>
        <action android:name="android.intent.action.SET_ALARM" />
        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>
     */
    @RequiresPermission(Manifest.permission.SET_ALARM)
    fun setAlarm(){

    }

    @RequiresPermission(Manifest.permission.SET_ALARM)
    fun setAlarm(intent: Intent){
        if (intent.resolveActivity(context.packageManager) != null){
            context.startActivity(intent)
        }
    }
    /*
    Set Alarm intent.
     */
}