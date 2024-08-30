package com.example.lokalandroidassignment.ui.screen.Job

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.BookmarkAdd
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lokalandroidassignment.R
import com.example.lokalandroidassignment.data.local.modal.BookmarkJob
import com.example.lokalandroidassignment.data.remote.model.ResultModal
import com.example.lokalandroidassignment.ui.theme.GoodBlue
import com.example.lokalandroidassignment.ui.theme.GoodYellow
import com.example.lokalandroidassignment.ui.theme.LightBlue


@Composable
fun JobCard(
    modifier: Modifier = Modifier,
    job: ResultModal,
    isBookmarked: Boolean,
    addBookmarkJob: (ResultModal) -> Unit,
    onInfoClicked: () -> Unit,
) {

    val context = LocalContext.current

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .fillMaxWidth(),

            ) {
            // Row for Job Title and Bookmark Icon
            JobTitleWithBookmarkRow(job, isBookmarked, addBookmarkJob, context)


            if (job.company_name.isNotEmpty()) {
                IconWithText(image = R.drawable.officebuilding, text = "${job.company_name}")
            }

            IconWithText(text = job.job_location_slug)

            Spacer(modifier = Modifier.height(16.dp))

            // Row for Tags Chips
            TagChipRow(job = job)
            Spacer(modifier = Modifier.height(16.dp))

            // Job Description/Title
            Text(
                text = job.title,
                fontSize = 14.sp,
                lineHeight = 15.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Row for Mobile Number and Call Icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .border(BorderStroke(1.dp, LightGray), RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(GoodYellow)
                        .padding(8.dp)
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "\uD83D\uDCDE  Call HR",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    modifier = Modifier
                        .border(BorderStroke(1.dp, LightGray), RoundedCornerShape(12.dp))
                        .clip(RoundedCornerShape(12.dp))
                        .background(LightBlue)
                        .size(40.dp),
                    onClick = { onInfoClicked() }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = GoodBlue
                    )
                }
            }
        }
    }
}

@Composable
public fun TagChipRow(
    modifier: Modifier = Modifier,
    job: ResultModal
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        job.job_tags.forEach {
            TagChipItem(text = it.value)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun TagChipItem(
    modifier: Modifier = Modifier,
    text: String
) {

    Box(
        modifier = modifier
            .background(LightBlue, RoundedCornerShape(6.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            color = GoodBlue,
            lineHeight = 14.sp
        )
    }

}

@Composable
private fun JobTitleWithBookmarkRow(
    job: ResultModal,
    isBookmarked: Boolean,
    addBookmarkJob: (ResultModal) -> Unit,
    context: Context
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(.9f)
        ) {

            Text(
                text = job.job_role,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = GoodBlue,
                lineHeight = 20.sp

            )

            if (job.salary_min != 0 && job.salary_max != 0) {
                Text(
                    text = "₹${job.salary_min} - ${job.salary_max}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            } else {
                Text(
                    text = "Depends on Experience/position",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        // Bookmark Icon
        IconButton(
            modifier = Modifier.weight(.1f),
            onClick = {
                addBookmarkJob(job)
                if (!isBookmarked)
                    Toast.makeText(context, "Bookmark Added", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(context, "Bookmark Removed", Toast.LENGTH_SHORT).show()
            }) {
            Icon(
                imageVector =
                when {
                    isBookmarked -> Icons.Filled.BookmarkAdd
                    else -> Icons.Outlined.BookmarkBorder
                },
                contentDescription = "Bookmark",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}


@Composable
fun IconWithText(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    image: Int? = null,
    text: String,
    textSize: TextUnit = 12.sp,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        if (icon != null)
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(16.dp)
            )
        else if (image != null)
            Icon(
                painter = painterResource(id = image),
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(14.dp)
            )
        if (icon != null || image != null)
            Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = textSize,
            fontWeight = FontWeight.Light,
            lineHeight = textSize
        )
    }

}