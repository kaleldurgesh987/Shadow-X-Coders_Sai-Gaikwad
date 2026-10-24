package com.example.shadow_xcodershome_crew.navigation

import kotlinx.serialization.Serializable

@Serializable
enum class UserRole {
    CUSTOMER,
    WORKER
}

@Serializable
sealed interface NavKey {
    @Serializable
    data object Splash : NavKey

    @Serializable
    data object RoleSelection : NavKey

    @Serializable
    data class Auth(val role: UserRole) : NavKey

    @Serializable
    data class Dashboard(val role: UserRole) : NavKey

    @Serializable
    data object WorkerHub : NavKey

    @Serializable
    data object CustomerHome : NavKey

    @Serializable
    data object ServiceCategories : NavKey

    @Serializable
    data class CategoryWorkers(val categoryId: String, val categoryName: String) : NavKey

    @Serializable
    data class WorkerProfile(val workerId: String) : NavKey

    @Serializable
    data class QuotationComparison(val serviceRequestId: String) : NavKey

    @Serializable
    data class JobRequestForm(val categoryId: String? = null) : NavKey

    @Serializable
    data class BookingConfirmation(
        val bookingId: String = "HC12458",
        val workerName: String,
        val totalAmount: Double,
        val dateTime: String = "Today, 3:00 PM"
    ) : NavKey

    @Serializable
    data class BookingTracking(
        val bookingId: String = "HC12458",
        val workerName: String,
        val totalAmount: Double,
        val dateTime: String = "Today, 3:00 PM",
        val initialStep: Int = 3
    ) : NavKey
}
