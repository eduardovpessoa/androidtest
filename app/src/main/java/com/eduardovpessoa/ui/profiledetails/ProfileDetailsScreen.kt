package com.eduardovpessoa.ui.profiledetails

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.eduardovpessoa.R
import com.eduardovpessoa.data.dto.Profile
import com.eduardovpessoa.ui.composables.DivvyToolbar
import java.util.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ProfileDetailsScreen(
    profile: Profile,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            DivvyToolbar(title = stringResource(R.string.profile_details), true) {
                onBackPressed()
            }
        },
        content = {
            ProfileDetailsScreenInfo(profile = profile, paddingValues = it)
        }
    )
}

@Composable
fun ProfileDetailsScreenInfo(profile: Profile, paddingValues: PaddingValues) {
    val context = LocalContext.current
    val state = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(state, enabled = true)
            .fillMaxWidth()
            .padding(top = paddingValues.calculateTopPadding(), start = 16.dp, end = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(profile.picture.orEmpty())
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape).align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.name),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = profile.name.orEmpty(),
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.title),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = profile.title.orEmpty(),
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.phone),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = profile.phone.orEmpty(),
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.email),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        Text(
            text = profile.email.orEmpty(),
            fontSize = 18.sp,
            maxLines = 2,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.birthday),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        Text(
            text = profile.birthday.orEmpty(),
            fontSize = 18.sp,
            maxLines = 2,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.address),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        Text(
            text = profile.formatAddress(),
            fontSize = 18.sp,
            maxLines = 2,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.align(CenterHorizontally),
            onClick = {
                // Display a label at the location of Google's Sydney office
                val gmmIntentUri = Uri.parse("geo:0,0?q=${profile.formatAddress()}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                context.startActivity(mapIntent)
            }) {
            Icon(imageVector = Icons.Rounded.Map, contentDescription = "")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(R.string.open_maps))
        }
        Spacer(modifier = Modifier.height(32.dp))
    }
}
