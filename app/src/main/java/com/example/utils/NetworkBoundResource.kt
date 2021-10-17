package com.example.utils

import kotlinx.coroutines.flow.*


inline fun <resultType, requestType> networkBoundResource(
    crossinline query:()-> Flow<resultType>,
    crossinline fetch: suspend ()->requestType,
    crossinline saveFetchResult:suspend (requestType)->Unit,
    crossinline shouldFetch : (resultType)->Boolean = {true}

) = flow{

    val data = query().first()

    val flowResult = if(shouldFetch(data)){
        emit(Resource.Loading(data))
        try{
            saveFetchResult(fetch())
            query().map { Resource.Success(it) }
        }catch (throwable:Throwable){
            query().map{ Resource.Error(it,throwable)}
        }
    }else{
        query().map{
            Resource.Success(it)
        }
    }

    emitAll(flowResult)

}