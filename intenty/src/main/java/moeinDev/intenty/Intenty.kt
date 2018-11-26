package moeinDev.intenty

import android.content.Context
import moeinDev.intenty.Categories.System

class Intenty(val context: Context) {
    fun getSystem(): System = moeinDev.intenty.Categories.System(context)

}