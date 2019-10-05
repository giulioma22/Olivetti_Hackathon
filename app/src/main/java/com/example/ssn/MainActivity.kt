package com.example.ssn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.TextView
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import java.util.HashMap

class MainActivity : AppCompatActivity() {


    //NOTE : expires every two hours
    internal var fbKey =
        "Bearer EAAFa7O0P5AkBALNcZC7FzxdMZB7tR1cZAEaoHz6MdgyDNnJFyYRhSbDyZArxBzvQCvDh7UGFN12WGQd1f0FhnH7ZCMi0U4rHdcVpObRppdppymxnmMLevByQbSHGR5S6fvjOVRt1L2CCeojgpZAbS2PoeHcabIZAYYttYm75bIK3Lpl02G6HWKe9K6BaG9XGJWXyuNPWS5yhgZDZD"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DoSomething.setOnClickListener {
            d("olivetti","Do something!")
            startActivity(Intent(this, AboutMe::class.java))
        }


    }


    fun postFBmessage(msg: String) {
        //fbMessageBox.requestStarted(); //TODO link this and others to a message box
        val queue = Volley.newRequestQueue(this)
        val sr = object : StringRequest(
            Method.POST,
            "https://graph.facebook.com/104577460953350/feed",
            Response.Listener { response ->
                println("Response is: $response")
                //fbMessageBox.requestCompleted();
            },
            Response.ErrorListener {
                //fbMessageBox.requestEndedWithError(error);
            }) {
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["message"] = msg
                return params
            }

            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val params = HashMap<String, String>()
                params["Authorization"] = fbKey
                return params
            }
        }
        println(sr.toString())
        queue.add(sr)
    }

}
