package com.hazrat.learning.sqldelightkmp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.hazrat.learning.sqldelightkmp.presentation.ReminderScreen
import com.hazrat.learning.sqldelightkmp.presentation.ReminderViewModel
import com.hazrat.learning.sqldelightkmp.presentation.reminderDetails.ReminderDetailsScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.koin.compose.viewmodel.koinViewModel


/**
 * @author hazratummar
 * Created on 07/01/26
 */
 
@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
){
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration{
            serializersModule = SerializersModule {
                polymorphic(NavKey::class){
                    subclass(Routes.ReminderList::class, Routes.ReminderList.serializer())
                    subclass(Routes.ReminderDetails::class, Routes.ReminderDetails.serializer())
                }
            }
        },
        Routes.ReminderList
    )

    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = { key ->
            when(key){
                is Routes.ReminderList ->{
                    NavEntry(key){

                        val reminderViewModel : ReminderViewModel = koinViewModel()

                        ReminderScreen(
                            onReminderClick = {
                                backStack.add(Routes.ReminderDetails("Reminder $it"))
                            },
                            reminderViewModel = reminderViewModel
                        )
                    }
                }

                is Routes.ReminderDetails ->{
                    NavEntry(key){
                        ReminderDetailsScreen(
                            reminder  = key.reminderDescription
                        )
                    }
                }

                else -> error("Unknown route")
            }
        }
    )
}