package moeinDev.intenty.Categories

import android.Manifest
import android.content.Context
import android.content.Intent
import android.provider.AlarmClock
import android.provider.CalendarContract
import android.support.annotation.RequiresApi
import android.support.annotation.RequiresPermission


/*
This class simplifies using system Intents 👾
More information:
https://developer.android.com/guide/components/intents-common
 */
class System(private val context: Context) {
    /*
    Set Alarm intent:
    Intent filters:
    <intent-filter>
        <action android:name="android.intent.action.SET_ALARM" />
        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>
     */
    @RequiresPermission(Manifest.permission.SET_ALARM)
    fun setAlarm(message: String,hour: Int,minutes: Int){
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }

    fun setAlarm(intent: Intent){
        if (intent.resolveActivity(context.packageManager) != null){
            context.startActivity(intent)
        }
    }

    /*
    Set Alarm intent.
     */

    /*
    Create timer intent:
    Intent filters:
    <intent-filter>
        <action android:name="android.intent.action.SET_TIMER" />
        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>
     */
    @RequiresApi(19)
    @RequiresPermission(Manifest.permission.SET_ALARM)
    fun createTimer(message: String, seconds: Int){
        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }

    fun createTimer(intent: Intent){
        if (intent.resolveActivity(context.packageManager) != null){
            context.startActivity(intent)
        }
    }
    /*
    Create timer intent.
     */

    //Calendar:
    /* Add Event:
    intent filters:
    <intent-filter>
        <action android:name="android.intent.action.INSERT" />
        <data android:mimeType="vnd.android.cursor.dir/event" />
        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>
     */
    fun addCalendarEvent(title: String,location: String,begin: Long,end: Long){
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, title)
            putExtra(CalendarContract.Events.EVENT_LOCATION, location)
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }

    fun addCalendarEvent(intent: Intent){
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }
    /*
    Add event.
     */
    //Calendar.

}