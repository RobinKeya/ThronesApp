package com.example.thrones

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.example.thrones.presentation.characterDetails.CharacterDetailScreen
import com.example.thrones.presentation.characterDetails.CharacterDetailScreenState
import com.example.thrones.ui.theme.ThronesTheme
import com.example.thrones.utils.Constants
import com.example.thrones.utils.DummyContent
import org.junit.Rule
import org.junit.Test

class CharacterDetailsScreenTest {
    @get: Rule
    val testRule : ComposeContentTestRule = createComposeRule()

    @Test
    fun initialState_isInitialized(){
        testRule.setContent {
            ThronesTheme {
                CharacterDetailScreen(characterDetailScreenState = CharacterDetailScreenState(
                    characterInfo = null,
                    isLoading = true
                ))
            }
        }
        testRule.onNodeWithContentDescription(Constants.IS_LOADING).assertIsDisplayed()
    }

    @Test
    fun stateWithContent_isInitialized(){
        val character = DummyContent.characters[0]
        testRule.setContent {
            ThronesTheme {
                CharacterDetailScreen(characterDetailScreenState = CharacterDetailScreenState(
                    characterInfo = character,
                    isLoading = false,
                ))
            }
        }
        testRule.onNodeWithText(character.fullName).assertIsDisplayed()
        testRule.onNodeWithContentDescription(character.fullName).assertIsDisplayed()
        testRule.onNodeWithText(character.family).assertIsDisplayed()
        testRule.onNodeWithText(character.title).assertIsDisplayed()
        testRule.onNodeWithContentDescription(Constants.IS_LOADING).assertDoesNotExist()
    }

    @Test
    fun stateWithError_isInitialized(){
        val character = DummyContent.characters[0]
        testRule.setContent {
            ThronesTheme {
                CharacterDetailScreen(characterDetailScreenState = CharacterDetailScreenState(
                    characterInfo = null,
                    isLoading = false,
                    error = "Something went wrong"
                ))
            }
        }
        testRule.onNodeWithText("Something went wrong").assertIsDisplayed()
        testRule.onNodeWithContentDescription(Constants.IS_LOADING).assertDoesNotExist()
        testRule.onNodeWithText(character.fullName).assertDoesNotExist()
    }
}