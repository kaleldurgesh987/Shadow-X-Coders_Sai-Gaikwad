package com.example.shadow_xcodershome_crew.feature.worker

import kotlinx.serialization.Serializable

@Serializable
data class WorkerJob(
    val id: String,
    val title: String,
    val customerName: String,
    val address: String,
    val timeSlot: String,
    val amount: Double,
    val status: JobStatus,
    val category: String,
    val customerPhone: String,
    val notes: String
)

@Serializable
enum class JobStatus {
    INCOMING, SCHEDULED, COMPLETED, CANCELLED
}

@Serializable
data class EarningsData(
    val thisWeekTotal: Double,
    val thisMonthTotal: Double,
    val allTimeTotal: Double,
    val pendingPayments: Double,
    val availableBalance: Double,
    val completedJobsCount: Int,
    val weeklyChart: List<DailyEarnings>
)

@Serializable
data class DailyEarnings(
    val day: String,
    val amount: Double
)

@Serializable
data class WorkerCertificate(
    val id: String,
    val title: String,
    val issuedBy: String,
    val issueDate: String,
    val credentialId: String,
    val isVerified: Boolean
)

@Serializable
data class GrowthCourse(
    val id: String,
    val title: String,
    val category: String,
    val duration: String,
    val rating: Float,
    val enrolledCount: Int,
    val isCompleted: Boolean
)

@Serializable
data class ProofOfWorkItem(
    val id: String,
    val title: String,
    val customerName: String,
    val reviewComment: String,
    val rating: Float,
    val date: String,
    val beforeImage: String,
    val afterImage: String,
    val description: String
)
