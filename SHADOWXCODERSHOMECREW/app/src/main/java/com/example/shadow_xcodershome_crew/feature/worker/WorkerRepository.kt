package com.example.shadow_xcodershome_crew.feature.worker

import com.example.shadow_xcodershome_crew.model.Worker

object WorkerRepository {
    val workerProfile = Worker(
        id = "w1",
        name = "Alex Rivera",
        categoryId = "electrician",
        categoryName = "Master Electrician",
        rating = 4.9f,
        reviewCount = 128,
        distanceKm = 0.0,
        hourlyRate = 45.0,
        experienceYears = 8,
        skills = listOf("Circuit Repair", "Smart Home", "Panel Upgrades", "Lighting", "Switchboard Repair"),
        bio = "Certified Master Electrician with 8+ years of residential and commercial experience. Quick diagnosis and clean execution guaranteed.",
        verified = true,
        completedJobs = 340,
        portfolioImages = listOf("portfolio_1", "portfolio_2"),
        reviews = emptyList()
    )

    val todayJobs = mutableListOf(
        WorkerJob(
            id = "job_1",
            title = "Switchboard & MCB Repair",
            customerName = "Priya Singh",
            address = "124 Park Avenue, Apt 4B",
            timeSlot = "Today, 10:00 AM - 11:30 AM",
            amount = 115.0,
            status = JobStatus.SCHEDULED,
            category = "Electrician",
            customerPhone = "+1 (555) 234-5678",
            notes = "Tripped breaker panel in kitchen and flickering socket in living room."
        ),
        WorkerJob(
            id = "job_2",
            title = "Smart Ceiling Fan Installation",
            customerName = "David Miller",
            address = "89 Elm Street, Suite 2",
            timeSlot = "Today, 2:00 PM - 3:30 PM",
            amount = 85.0,
            status = JobStatus.SCHEDULED,
            category = "Electrician",
            customerPhone = "+1 (555) 876-5432",
            notes = "Replace existing old ceiling fan with remote-controlled smart fan."
        )
    )

    val incomingRequests = mutableListOf(
        WorkerJob(
            id = "req_1",
            title = "Whole House Wiring Inspection",
            customerName = "Sophia Martinez",
            address = "412 Oakridge Drive",
            timeSlot = "Tomorrow, 9:00 AM",
            amount = 180.0,
            status = JobStatus.INCOMING,
            category = "Electrician",
            customerPhone = "+1 (555) 345-6789",
            notes = "Pre-purchase electrical inspection for 3-bedroom townhouse."
        )
    )

    val earningsData = EarningsData(
        thisWeekTotal = 640.0,
        thisMonthTotal = 2850.0,
        allTimeTotal = 34200.0,
        pendingPayments = 125.0,
        availableBalance = 450.0,
        completedJobsCount = 340,
        weeklyChart = listOf(
            DailyEarnings("Mon", 90.0),
            DailyEarnings("Tue", 120.0),
            DailyEarnings("Wed", 85.0),
            DailyEarnings("Thu", 150.0),
            DailyEarnings("Fri", 110.0),
            DailyEarnings("Sat", 85.0),
            DailyEarnings("Sun", 0.0)
        )
    )

    val certificates = listOf(
        WorkerCertificate(
            id = "c_1",
            title = "Master Electrician License & Certification",
            issuedBy = "State Electrical Board",
            issueDate = "Jan 2018",
            credentialId = "EL-98421-US",
            isVerified = true
        ),
        WorkerCertificate(
            id = "c_2",
            title = "OSHA Safety & Compliance Badge",
            issuedBy = "Occupational Safety and Health Administration",
            issueDate = "Mar 2020",
            credentialId = "OSHA-510-44",
            isVerified = true
        ),
        WorkerCertificate(
            id = "c_3",
            title = "Smart Home Automation Specialist",
            issuedBy = "National Electrical Contractors Association",
            issueDate = "Nov 2022",
            credentialId = "SH-SPEC-882",
            isVerified = true
        )
    )

    val growthCourses = mutableListOf(
        GrowthCourse(
            id = "course_1",
            title = "Advanced Electrical Work & High Voltage Panels",
            category = "Technical",
            duration = "6 hours",
            rating = 4.9f,
            enrolledCount = 1240,
            isCompleted = false
        ),
        GrowthCourse(
            id = "course_2",
            title = "OSHA Safety & Hazard Management Training",
            category = "Safety",
            duration = "4 hours",
            rating = 4.8f,
            enrolledCount = 3100,
            isCompleted = true
        ),
        GrowthCourse(
            id = "course_3",
            title = "Home Appliance Repair Masterclass",
            category = "Appliance",
            duration = "8 hours",
            rating = 4.7f,
            enrolledCount = 890,
            isCompleted = false
        ),
        GrowthCourse(
            id = "course_4",
            title = "Smart Home Ecosystems (IoT & Automation)",
            category = "Technology",
            duration = "5 hours",
            rating = 4.9f,
            enrolledCount = 1750,
            isCompleted = false
        )
    )

    val proofOfWorkItems = listOf(
        ProofOfWorkItem(
            id = "pow_1",
            title = "Switchboard & Breaker Panel Repair",
            customerName = "Priya Singh",
            reviewComment = "Alex fixed our tripped breaker panel in no time. Super professional, neat wiring, and explained everything clearly!",
            rating = 5.0f,
            date = "2 days ago",
            beforeImage = "before_switchboard",
            afterImage = "after_switchboard",
            description = "Replaced faulty 60A circuit breaker, reorganized tangled neutral wires, and installed surge protector."
        ),
        ProofOfWorkItem(
            id = "pow_2",
            title = "Recessed LED Lighting Setup",
            customerName = "Michael Chang",
            reviewComment = "Installed smart dimmable LED lights throughout the living room. Clean cutouts and flawless wiring.",
            rating = 4.9f,
            date = "1 week ago",
            beforeImage = "before_ceiling",
            afterImage = "after_ceiling",
            description = "Installed 8 recessed LED fixtures with wireless dimmer switches."
        )
    )
}
