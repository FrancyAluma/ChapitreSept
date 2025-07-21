package com.example.chapitresept.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class PetsRepositoryImpl (

    private val catsAPI : CatsAPI ,
    private val dispatcher : CoroutineDispatcher

) : PetsRepository {

    override suspend fun getPets(): NetworkResult <List<Cat>> {

        return withContext (dispatcher) {

            try {

                val response = catsAPI.fetchCats("cute")
                if (response.isSuccessful) {
                    NetworkResult.Success(response.body()!!)
                } else {

                    NetworkResult.Error (response.errorBody().toString())
                }
            } catch (e:Exception) {

                NetworkResult.Error(e.message ?: "Unkown error")
            }

            /* try {
                 val response = catsAPI.fetchCats("cute")
                 if (response.isSuccessful) {
                     val body = response.body()
                     if (body != null) {
                         NetworkResult.Success(body)
                     } else {
                         NetworkResult.Error("Response body is null")
                     }
                 } else {
                     NetworkResult.Error(response.errorBody()?.string() ?: "Unknown error")
                 }
             } catch (e: Exception) {
                 NetworkResult.Error(e.message ?: "Unknown error")
             }
 */

        }

    }
}