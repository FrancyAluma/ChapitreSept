package com.example.chapitresept.data

interface PetsRepository {

    suspend fun getPets () : NetworkResult<List<Cat>>

}