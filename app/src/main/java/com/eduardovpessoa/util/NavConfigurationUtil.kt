package com.eduardovpessoa.util

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eduardovpessoa.data.dto.Profile
import com.eduardovpessoa.data.dto.Profiles
import com.eduardovpessoa.ui.profiles.ProfilesScreen
import com.eduardovpessoa.ui.profiledetails.ProfileDetailsScreen

@ExperimentalMaterial3Api
@Composable
fun NavConfigurationUtil(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "profiles"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        var profile: Profile? = null
        composable("profiles") {
            ProfilesScreen(
                onNavigateToProfileDetails = {
                    profile = it
                    navController.navigate("profile-details")
                }
            )
        }
        composable("profile-details") {
            profile?.let {
                ProfileDetailsScreen(profile = it) {
                    navController.popBackStack()
                }
            }
        }
    }

}