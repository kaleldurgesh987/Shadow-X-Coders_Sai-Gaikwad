package com.example.shadow_xcodershome_crew.model

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
data class ServiceCategory(
    val id: String,
    val name: String,
    val description: String,
    val startingPrice: Double,
    val workerCount: Int,
    val iconName: String // identifier for icon mapping
)

@Serializable
data class Review(
    val id: String,
    val authorName: String,
    val rating: Float,
    val comment: String,
    val date: String
)

@Serializable
data class Worker(
    val id: String,
    val name: String,
    val categoryId: String,
    val categoryName: String,
    val rating: Float,
    val reviewCount: Int,
    val distanceKm: Double,
    val hourlyRate: Double,
    val experienceYears: Int,
    val skills: List<String>,
    val bio: String,
    val verified: Boolean,
    val completedJobs: Int,
    val portfolioImages: List<String>,
    val reviews: List<Review>
)

@Serializable
data class Quotation(
    val id: String,
    val workerId: String,
    val workerName: String,
    val workerAvatar: String,
    val rating: Float,
    val hourlyRate: Double,
    val labourCost: Double,
    val materialCost: Double,
    val totalEstimate: Double,
    val estimatedHours: Int,
    val deliveryTime: String,
    val perks: List<String>
)
