package pe.devpicon.android.myliniochallengeapplication.application

import android.app.Application
import java.io.InputStream

/**
 * Created by armando on 7/25/17.
 */
class MyApp : Application() {

    companion object {
        const val CONSTANT = 12
        lateinit var jsonInputStream: InputStream
    }

    override fun onCreate() {
        super.onCreate()
        jsonInputStream = applicationContext.resources.getAssets().open("wish_list.json")
    }

}