package com.coolreece.squareproject

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.coolreece.squareproject.activity.MainActivity
import com.coolreece.squareproject.ui.compose.MainDisplay
import com.coolreece.squareproject.ui.theme.SquareProjectTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class SquareProjectTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    @Test
    fun myTest() {
        // Start the app
        composeTestRule.setContent {
            SquareProjectTheme {
                MainDisplay()
            }
        }

        val text = composeTestRule.activity.getString(R.string.app_bar_title)
        composeTestRule.onNodeWithText(text).assertIsDisplayed()
    }
}