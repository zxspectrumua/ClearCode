package com.data

import com.entity.UsefulActivity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UsefulActivityDto(
    @Json(name = "activity") override var activity:String,
    @Json(name = "type") override var type:String,
    @Json(name = "participants") override var participants:Int,
    @Json(name = "price") override var price:Float,
    @Json(name = "link") override var link:String,
    @Json(name = "key") override var key:String,
    @Json(name = "accessibility") override var accessibility:Float,

    ): UsefulActivity {
}

