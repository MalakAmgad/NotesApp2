package com.bankmisr.notesapp2.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bankmisr.notesapp2.AddingNoteScreen
import com.bankmisr.notesapp2.EditingNoteScreen
import com.bankmisr.notesapp2.HomeScreen
import com.bankmisr.notesapp2.routes.Route.ADD_NOTE
import com.bankmisr.notesapp2.routes.Route.EDIT_NOTE
import com.bankmisr.notesapp2.routes.Route.HOME

object Route {
    const val HOME = "home"
    const val ADD_NOTE = "add_note"
    const val EDIT_NOTE = "edit_note"
}

@Composable
fun ApppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME) {
        composable(route = HOME){ HomeScreen(navController = navController)}
        composable(route = ADD_NOTE){ AddingNoteScreen(navController = navController) }
        composable(route = "$EDIT_NOTE/{id}/{details}",
            arguments = listOf(navArgument("id"){type= NavType.IntType },
                navArgument("details"){type=NavType.StringType}
                )){
            val id =it.arguments?.getInt("id")!!
            val details =it.arguments?.getString("details")!!
            EditingNoteScreen(id,details,navController = navController)}

    }
}