package com.data

import com.entity.UsefulActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking

class UsefulActivitiesRepository {
    lateinit var activity:UsefulActivity
    fun getUsefulActivity(): UsefulActivity {

            runBlocking {
                val tasks = listOf(
                    async(Dispatchers.IO) { activity = RetrofitServices.activityApi.getActivity() },
                )
                tasks.awaitAll()
            }

        return activity

        }



}