package br.cericatto.gok.network

import okhttp3.OkHttpClient

object OkHttpProvider {
    val instance: OkHttpClient = OkHttpClient.Builder().build()
}