package com.github.mckernant1.lol.heimerdinger.team

import com.github.mckernant1.lol.heimerdinger.ClientBaseTest
import org.apache.http.HttpException
import org.junit.Test

internal class TeamClientTest : ClientBaseTest() {

    private val teamClient: TeamClient = TeamClient(noCacheEsportsApiConfig)

    @Test
    fun getAllTeams() {
        val allTeams = teamClient.getAllTeams()
        assert(allTeams.isNotEmpty())
    }


    @Test
    fun getTeamBySlug() {
        try {
            val cloud9 = teamClient.getTeamBySlug("cloud9")
            assert(cloud9.slug == "cloud9")
        } catch (e: HttpException) {
            if (e.message?.contains("Server response timeout") == true) {
                println("Server timeout error. Skipping test")
            } else {
               throw e
            }
        }
    }

    @Test
    fun getTeamByCode() {
        val tsm = teamClient.getTeamByCode("tsm")
        assert(tsm.code.toLowerCase() == "tsm")
    }
}
