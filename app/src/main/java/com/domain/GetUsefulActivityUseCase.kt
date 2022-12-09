package com.domain

import com.data.UsefulActivitiesRepository
import com.entity.UsefulActivity
import javax.inject.Inject

class GetUsefulActivityUseCase(var repository:UsefulActivitiesRepository) {

    fun execute():UsefulActivity{
        return repository.getUsefulActivity()
    }
}