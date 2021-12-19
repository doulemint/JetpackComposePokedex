package com.jayesh.jetpackcomposepokedex

import PokemonListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.jayesh.jetpackcomposepokedex.pokemondetail.PokemonDetailScreen
import com.jayesh.jetpackcomposepokedex.ui.theme.JetpackComposePokedexTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePokedexTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,startDestination = "pokemon_list_screen"){
                    composable("pokemon_list_screen"){
                        PokemonListScreen(navController = navController)
                    }
                    composable("pokemon_detail_screen/{pokemonName}",
                    arguments = listOf(
                        navArgument("pokemonName"){
                            type = NavType.StringType
                        }
                    )){
                        val random = Random()
                        val dominantColor = Color(random.nextInt(256),
                            random.nextInt(256),
                            random.nextInt(256))

                        val pokemonName = it.arguments?.getString("pokemonName")

                        if (dominantColor != null) {
                            PokemonDetailScreen(
                                dominantColor = dominantColor,
                                pokemonName = pokemonName?.toLowerCase(Locale.ROOT) ?: "",
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}


