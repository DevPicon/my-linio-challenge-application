package pe.devpicon.android.myliniochallengeapplication.application

import android.app.Application

/**
 * Created by armando on 7/25/17.
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this


    }

    fun getAssest() = applicationContext.resources.getAssets().open("wish_list.json")

    companion object {
        lateinit var instance: MyApp
            private set


    }


}