package com.rextrem.anotador.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rextrem.anotador.data.repository.NoteRepository
import com.rextrem.anotador.presentation.note_create.NoteCreateScreen
import com.rextrem.anotador.presentation.note_create.NoteCreateViewModel
import com.rextrem.anotador.presentation.notes_list.NotesListScreen
import com.rextrem.anotador.presentation.notes_list.NotesListViewModel

object Routes {
    const val LIST = "list"
    const val CREATE = "create"
}

@Composable
fun NavGraph(
    navController: NavHostController,
    repository: NoteRepository
) {
    NavHost(navController = navController, startDestination = Routes.LIST) {
        composable(Routes.LIST) {
            val vm = viewModel<NotesListViewModel>(factory = SimpleVmFactory { NotesListViewModel(repository) })
            NotesListScreen(
                viewModel = vm,
                onAddClick = { navController.navigate(Routes.CREATE) }
            )
        }
        composable(Routes.CREATE) {
            val vm = viewModel<NoteCreateViewModel>(factory = SimpleVmFactory { NoteCreateViewModel(repository) })
            NoteCreateScreen(
                viewModel = vm,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
