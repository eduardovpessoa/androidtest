package com.eduardovpessoa.ui.profiles

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eduardovpessoa.R
import com.eduardovpessoa.data.dto.Profile
import com.eduardovpessoa.data.dto.Profiles
import com.eduardovpessoa.ui.composables.DivvyCircularProgressIndicator
import com.eduardovpessoa.ui.composables.DivvyToolbar
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ProfilesScreen(
    viewModel: ProfilesViewModel = getViewModel(),
    onNavigateToProfileDetails: (Profile) -> Unit
) {
    val profilesScreenUi = viewModel.profiles.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getProfiles()
    }

    Scaffold(
        topBar = {
            DivvyToolbar(
                title = stringResource(R.string.profile),
                false,
                onBackClick = {})
        },

        content = {
            if (profilesScreenUi.value.profiles.isEmpty()) {
                DivvyCircularProgressIndicator(it)
            } else {
                ProfileScreenList(
                    profilesUi = profilesScreenUi.value,
                    paddingValues = it,
                    onItemClick = { profile ->
                        onNavigateToProfileDetails(profile)
                    }
                )
            }
        }
    )
}

@Composable
fun ProfileScreenList(
    profilesUi: ProfilesScreenUI,
    paddingValues: PaddingValues,
    onItemClick: (Profile) -> Unit
) {
    val lazyState = rememberLazyListState()
    LazyColumn(
        state = lazyState,
        modifier = Modifier.padding(
            top = paddingValues.calculateTopPadding(),
            start = 16.dp,
            end = 16.dp
        )
    ) {
        items(profilesUi.profiles) { item ->
            ProfileScreenListItem(item) {
                onItemClick(it)
            }
        }
    }
}

@Composable
fun ProfileScreenListItem(
    item: Profile,
    onItemClick: (Profile) -> Unit
) {
    Text(
        text = item.name.orEmpty(),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                onItemClick(item)
            }
    )
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun ProfilesScreenPreview() {
    ProfilesScreen { }
}