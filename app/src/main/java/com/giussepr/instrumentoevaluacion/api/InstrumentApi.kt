package com.giussepr.instrumentoevaluacion.api

import com.giussepr.instrumentoevaluacion.data.InstrumentData
import com.giussepr.instrumentoevaluacion.data.InstrumentResponseDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface InstrumentApi {

    @POST("save-json/")
    suspend fun sendInstrumentData(@Body instrumentData: InstrumentData): Response<InstrumentResponseDTO>
}
