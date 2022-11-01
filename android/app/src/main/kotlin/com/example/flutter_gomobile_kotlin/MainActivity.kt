package com.example.flutter_gomobile_kotlin

import io.flutter.embedding.android.FlutterActivity
import androidx.annotation.NonNull
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import gomobilelib.DataProcessor

class MainActivity: FlutterActivity() {
    private val CHANNEL = "example.com/gomobilelib"
    private lateinit var channel: MethodChannel
    val goMobileLib = DataProcessor()

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        channel = MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
        channel.setMethodCallHandler { call, result -> 
            if(call.method == "getRandomNumber") {
                val num = goMobileLib.randomNumber()
                result.success(num)
            }

        }
    }
}
