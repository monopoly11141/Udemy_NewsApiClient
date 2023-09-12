package com.example.udemy_newsapiclient.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIServiceTest {

    private lateinit var newsAPIService: NewsAPIService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        newsAPIService = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueueMockResponse(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        mockWebServer.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected_Test() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val apiResponse = newsAPIService.getTopHeadlines("us", 1).body()
            val request = mockWebServer.takeRequest()
            assertThat(apiResponse).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=cb4cf77b6ce1463fa53410e369575b36")

        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctPageSize_Test() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val apiResponse = newsAPIService.getTopHeadlines("us", 1).body()
            val articlesList = apiResponse!!.articles
            assertThat(articlesList.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent_Test() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val apiResponse = newsAPIService.getTopHeadlines("us", 1).body()
            val articlesList = apiResponse!!.articles
            val article = articlesList[0]

            assertThat(article.author).isEqualTo("Chris Bumbaca, Cydney Henderson")
            assertThat(article.url).isEqualTo("https://www.usatoday.com/story/sports/nfl/2023/09/10/cowboys-giants-sunday-night-football-live-updates/70796318007/")
            assertThat(article.publishedAt).isEqualTo("2023-09-11T01:26:09Z")
        }
    }


    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}