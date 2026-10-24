package com.example.shadow_xcodershome_crew.data

import com.example.shadow_xcodershome_crew.model.Quotation
import com.example.shadow_xcodershome_crew.model.Review
import com.example.shadow_xcodershome_crew.model.ServiceCategory
import com.example.shadow_xcodershome_crew.model.Worker

object HomeCrewRepository {

    val categories = listOf(
        ServiceCategory(
            id = "electrician",
            name = "Electrician",
            description = "Wiring, appliance repair, socket installation & lighting.",
            startingPrice = 35.0,
            workerCount = 42,
            iconName = "Bolt"
        ),
        ServiceCategory(
            id = "plumber",
            name = "Plumber",
            description = "Leak fixing, pipe installation, bathroom fittings & drainage.",
            startingPrice = 40.0,
            workerCount = 38,
            iconName = "WaterDrop"
        ),
        ServiceCategory(
            id = "cleaner",
            name = "Cleaner",
            description = "Deep cleaning, dusting, window washing & sanitization.",
            startingPrice = 25.0,
            workerCount = 65,
            iconName = "CleaningServices"
        ),
        ServiceCategory(
            id = "carpenter",
            name = "Carpenter",
            description = "Furniture assembly, custom woodwork, door & lock repair.",
            startingPrice = 45.0,
            workerCount = 29,
            iconName = "Build"
        ),
        ServiceCategory(
            id = "painter",
            name = "Painter",
            description = "Interior/exterior wall painting, waterproofing & texture design.",
            startingPrice = 30.0,
            workerCount = 31,
            iconName = "FormatPaint"
        ),
        ServiceCategory(
            id = "more",
            name = "More Services",
            description = "AC repair, pest control, gardening, smart home setup & roofing.",
            startingPrice = 20.0,
            workerCount = 80,
            iconName = "Category"
        )
    )

    val workers = listOf(
        Worker(
            id = "w1",
            name = "Alex Rivera",
            categoryId = "electrician",
            categoryName = "Electrician",
            rating = 4.9f,
            reviewCount = 128,
            distanceKm = 1.2,
            hourlyRate = 45.0,
            experienceYears = 8,
            skills = listOf("Circuit Repair", "Smart Home", "Panel Upgrades", "Lighting"),
            bio = "Certified Master Electrician with 8+ years of residential and commercial experience. Quick diagnosis and clean execution guaranteed.",
            verified = true,
            completedJobs = 340,
            portfolioImages = listOf("portfolio_1", "portfolio_2"),
            reviews = listOf(
                Review("r1", "Sarah Jenkins", 5.0f, "Alex fixed our tripped breaker panel in no time. Super professional and neat!", "2 days ago"),
                Review("r2", "Michael Chang", 4.8f, "Installed smart switches throughout the house. Great attention to detail.", "1 week ago")
            )
        ),
        Worker(
            id = "w2",
            name = "David Vance",
            categoryId = "electrician",
            categoryName = "Electrician",
            rating = 4.7f,
            reviewCount = 94,
            distanceKm = 2.5,
            hourlyRate = 38.0,
            experienceYears = 6,
            skills = listOf("Wiring", "Appliance Repair", "Generator Setup"),
            bio = "Reliable electrician ready for emergencies and routine upgrades. Available 24/7 for urgent power outages.",
            verified = true,
            completedJobs = 210,
            portfolioImages = listOf("portfolio_3"),
            reviews = listOf(
                Review("r3", "Elena Rostova", 5.0f, "Arrived at 11 PM for an urgent short circuit issue. Lifesaver!", "3 days ago")
            )
        ),
        Worker(
            id = "w3",
            name = "Marcus Vance",
            categoryId = "plumber",
            categoryName = "Plumber",
            rating = 4.8f,
            reviewCount = 156,
            distanceKm = 0.8,
            hourlyRate = 50.0,
            experienceYears = 10,
            skills = listOf("Leak Detection", "Pipe Re-routing", "Water Heaters", "Drain Cleaning"),
            bio = "Master plumber specializing in high-pressure leak detection, modern bathroom fixtures, and emergency pipe bursts.",
            verified = true,
            completedJobs = 480,
            portfolioImages = listOf("portfolio_4", "portfolio_5"),
            reviews = listOf(
                Review("r4", "Jessica Alba", 5.0f, "Fixed a major kitchen pipe leak within 30 minutes. Extremely polite and efficient.", "Yesterday"),
                Review("r5", "Robert Downey", 4.7f, "Installed our tankless water heater flawlessly.", "2 weeks ago")
            )
        ),
        Worker(
            id = "w4",
            name = "Elena Rostova",
            categoryId = "cleaner",
            categoryName = "Cleaner",
            rating = 4.9f,
            reviewCount = 210,
            distanceKm = 1.9,
            hourlyRate = 30.0,
            experienceYears = 5,
            skills = listOf("Deep Cleaning", "Sanitization", "Post-Construction", "Carpet Care"),
            bio = "Detail-oriented professional cleaning specialist using eco-friendly products for pristine living spaces.",
            verified = true,
            completedJobs = 520,
            portfolioImages = listOf("portfolio_6"),
            reviews = listOf(
                Review("r6", "Tom Holland", 5.0f, "Apartment looks sparkling clean! Will definitely book again.", "4 days ago")
            )
        ),
        Worker(
            id = "w5",
            name = "Liam O'Connor",
            categoryId = "carpenter",
            categoryName = "Carpenter",
            rating = 4.6f,
            reviewCount = 82,
            distanceKm = 3.1,
            hourlyRate = 42.0,
            experienceYears = 9,
            skills = listOf("Custom Cabinetry", "Furniture Assembly", "Door Fitting", "Wood Repair"),
            bio = "Skilled craftsman turning raw timber into functional art. Custom wardrobes, shelving, and precision repairs.",
            verified = true,
            completedJobs = 195,
            portfolioImages = listOf("portfolio_7"),
            reviews = listOf(
                Review("r7", "Emma Watson", 4.5f, "Built custom bookshelves in our study. Beautiful craftsmanship.", "1 month ago")
            )
        ),
        Worker(
            id = "w6",
            name = "Carlos Santana",
            categoryId = "painter",
            categoryName = "Painter",
            rating = 4.8f,
            reviewCount = 115,
            distanceKm = 2.0,
            hourlyRate = 35.0,
            experienceYears = 7,
            skills = listOf("Interior Painting", "Exterior Coating", "Texture Finishes", "Waterproofing"),
            bio = "Transform your walls with flawless finishes. Premium paints, meticulous prep work, and zero mess left behind.",
            verified = true,
            completedJobs = 310,
            portfolioImages = listOf("portfolio_8"),
            reviews = listOf(
                Review("r8", "Chris Pratt", 5.0f, "Painted our 3-bedroom apartment in just 2 days. Stunning quality!", "5 days ago")
            )
        )
    )

    fun getQuotationsForRequest(requestId: String): List<Quotation> {
        return listOf(
            Quotation(
                id = "q1",
                workerId = "w1",
                workerName = "Alex Rivera",
                workerAvatar = "avatar_alex",
                rating = 4.9f,
                hourlyRate = 45.0,
                labourCost = 90.0,
                materialCost = 25.0,
                totalEstimate = 115.0,
                estimatedHours = 2,
                deliveryTime = "Today, 3:00 PM",
                perks = listOf("Free Inspection", "1 Year Warranty", "Eco-friendly parts")
            ),
            Quotation(
                id = "q2",
                workerId = "w2",
                workerName = "David Vance",
                workerAvatar = "avatar_david",
                rating = 4.7f,
                hourlyRate = 38.0,
                labourCost = 76.0,
                materialCost = 20.0,
                totalEstimate = 96.0,
                estimatedHours = 2,
                deliveryTime = "Tomorrow, 10:00 AM",
                perks = listOf("Discounts on bulk work", "Quick turnaround")
            ),
            Quotation(
                id = "q3",
                workerId = "w3",
                workerName = "Marcus Vance",
                workerAvatar = "avatar_marcus",
                rating = 4.8f,
                hourlyRate = 50.0,
                labourCost = 100.0,
                materialCost = 35.0,
                totalEstimate = 135.0,
                estimatedHours = 2,
                deliveryTime = "Today, 5:00 PM",
                perks = listOf("Emergency Priority", "Zero Call-out Fee", "Satisfaction Guaranteed")
            )
        )
    }
}
