package com.example.personaldetails

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name: TextView = findViewById(R.id.name)
        val age: TextView = findViewById(R.id.age)
        val date: TextView = findViewById(R.id.dob)
        val btn: Button = findViewById(R.id.button)
        val web: WebView = findViewById(R.id.webView)
        val body: TextView = findViewById(R.id.body)

        //To change the ststusbar from purple to black
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)


        //setting the texts
        name.text = "Oluwatunmise Ayeni"
        age.text = "Age:18"
        date.text = "Date:15-03-2005"
        body.text = "Born in the Western part of Nigeria, Lagos State to be precise, I am an Enthusiastic learner and have been in the tech space for" +
                "about a year plus with Foundations in HTML, CSS, JavaScript, Java and so on. I am a Computer Science Student at Babcock University, I enjoy " +
                "playing games like FIFA in my freetime and watching football. I spend most of my time learning more about Mobile development with Kotlin."

        //setting up the webView
        web.webViewClient = WebViewClient()

        //when clicked, opens the url in the app
        btn.setOnClickListener() {
            val url = "https://github.com/TunmiseAyeni"
            web.apply {
                loadUrl(url)
                web.visibility = View.VISIBLE
                settings.javaScriptEnabled = true
                settings.safeBrowsingEnabled = true
            }
        }

    }
    //Allowing it to go back to the previous page
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val web: WebView = findViewById(R.id.webView)
        if (web.canGoBack()){
            web.goBack()
        }else{
            super.onBackPressed()
        }

    }

}