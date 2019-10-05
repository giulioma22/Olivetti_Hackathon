package com.example.ssn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.social_media_post.*
import java.util.HashMap



class SocialMediaPost : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.social_media_post)

        PostButton.setOnClickListener {
            Log.d("FB post", "Posting to FB!")
            postFBmessage(fbPostMessage.text.toString())
        }
    }


    //NOTE : expires every two hours
    internal var fbKey =
        "Bearer EAAFa7O0P5AkBALNcZC7FzxdMZB7tR1cZAEaoHz6MdgyDNnJFyYRhSbDyZArxBzvQCvDh7UGFN12WGQd1f0FhnH7ZCMi0U4rHdcVpObRppdppymxnmMLevByQbSHGR5S6fvjOVRt1L2CCeojgpZAbS2PoeHcabIZAYYttYm75bIK3Lpl02G6HWKe9K6BaG9XGJWXyuNPWS5yhgZDZD"


    fun postFBmessage(msg: String) {
        //fbStatusMessageBox.requestStarted(); //TODO link this and others to a message box
        val queue = Volley.newRequestQueue(this)
        val sr = object : StringRequest(
            Method.POST,
            "https://graph.facebook.com/104577460953350/feed",
            Response.Listener { response ->
                println("Response is: $response")
                //fbStatusMessageBox.requestCompleted();
            },
            Response.ErrorListener {
                //fbStatusMessageBox.requestEndedWithError(error);
            }) {
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["message"] = msg
                params["og_action_type_id"] = "383634835006146" //feeeling
                params["og_object_id"] = "502842009736003" //wonderful
                params["og_icon_id"] = "1375828582720457" //earth
                params["place"] = "104577460953350" //shop id
                params["link"] =
                    "https://staticmedia.fauchon.com/media/catalog/product/cache/1/image/480x/040ec09b1e35df139433887a97daa66f/1/0/1008690.jpg" //link to picture or website
                params["object_id"] = "479384852111869" //generous
                params["icon_id"] = "201979713318928" // truck
                //TODO  param name for 467304226966610 //heart ?
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