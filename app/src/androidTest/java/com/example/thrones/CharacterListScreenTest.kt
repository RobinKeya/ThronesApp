package com.example.thrones

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.thrones.presentation.characterList.CharacterListScreen
import com.example.thrones.presentation.characterList.CharacterListScreenState
import com.example.thrones.ui.theme.ThronesTheme
import com.example.thrones.utils.Constants
import com.example.thrones.utils.DummyContent
import org.junit.Rule
import org.junit.Test

class CharacterListScreenTest {
    @get: Rule
    val testRule: ComposeContentTestRule= createComposeRule()
    
    @Test
    fun initialState_isInitiated(){
        testRule.setContent {
            ThronesTheme() {
                CharacterListScreen(
                    characterListScreenState = CharacterListScreenState(
                        chars = emptyList(),
                        isLoading = true
                    ) ,
                    cardClick ={} )
            }
        }
        testRule.onNodeWithContentDescription(Constants.IS_LOADING).assertIsDisplayed()
    }
    @Test
    fun stateWithContent_isRendered(){
        val character = DummyContent.characters[0]
        testRule.setContent {
            ThronesTheme() {
                CharacterListScreen(
                    characterListScreenState = CharacterListScreenState(
                        chars = DummyContent.characters,
                        isLoading = false
                    ) ,
                    cardClick ={} )
            }
        }
        testRule.onNodeWithText(character.fullName).assertIsDisplayed()
        testRule.onNodeWithContentDescription(Constants.IS_LOADING).assertDoesNotExist()
    }

    @Test
    fun stateWithError_isRendered(){
        testRule.setContent {
            ThronesTheme() {
                CharacterListScreen(characterListScreenState = CharacterListScreenState(
                    chars = listOf(),
                    isLoading = false,
                    error = "Something went wrong"
                ) ,
                    cardClick = {}
                )
            }
        }
        testRule.onNodeWithText("Something went wrong").assertIsDisplayed()
    }

    @Test
    fun clickAction_isPerformed(){
        val character = DummyContent.characters[0]
        testRule.setContent {
            CharacterListScreen(characterListScreenState = CharacterListScreenState(
                chars = DummyContent.characters,
                isLoading = false
            ),
                cardClick ={id -> assert(id== DummyContent.characters[0].id)  } )
        }
        testRule.onNodeWithContentDescription(Constants.IS_LOADING).assertDoesNotExist()
        testRule.onNodeWithText(character.fullName).performClick()
    }
}