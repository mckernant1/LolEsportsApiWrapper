package com.github.mckernant1.lolapi.team

import com.beust.klaxon.Json
import java.io.Serializable

data class Player(
    @Json("id") val playerId: String,
    val summonerName: String,
    val firstName: String,
    val lastName: String,
    val role: String,
    @Json("image") val imageURL: String
) : Serializable

data class Team(
    val teamId: String,
    val slug: String,
    val name: String,
    val code: String,
    val homeLeagueCode: String,
    val players: List<Player>
) : Serializable
