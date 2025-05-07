/**
 * Repository Item component
 * Displays a GitHub repository in a card format with key information
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.githubapp.data.model.Repository

@Composable
fun RepositoryItem(
    repository: Repository,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = repository.owner.avatarUrl,
                    contentDescription = "Owner avatar",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 8.dp)
                )
                
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = repository.fullName,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    
                    repository.description?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.body2,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Stars",
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "${repository.stars}",
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                
                repository.language?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}
