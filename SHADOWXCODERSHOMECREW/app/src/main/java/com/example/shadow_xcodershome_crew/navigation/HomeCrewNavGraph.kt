package com.example.shadow_xcodershome_crew.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.material3.Text
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.shadow_xcodershome_crew.feature.auth.AuthScreen
import com.example.shadow_xcodershome_crew.feature.dashboard.DashboardScreen
import com.example.shadow_xcodershome_crew.feature.role.RoleSelectionScreen
import com.example.shadow_xcodershome_crew.feature.splash.SplashScreen
import com.example.shadow_xcodershome_crew.feature.customer.CustomerHomeViewModel
import com.example.shadow_xcodershome_crew.feature.customer.CustomerHomeScreen
import com.example.shadow_xcodershome_crew.feature.customer.ServiceCategoriesScreen
import com.example.shadow_xcodershome_crew.feature.customer.CategoryWorkersScreen
import com.example.shadow_xcodershome_crew.feature.customer.WorkerProfileScreen
import com.example.shadow_xcodershome_crew.feature.customer.QuotationComparisonScreen
import com.example.shadow_xcodershome_crew.feature.customer.BookingConfirmationScreen
import com.example.shadow_xcodershome_crew.feature.customer.JobRequestFormScreen
import com.example.shadow_xcodershome_crew.feature.customer.BookingTrackingScreen
import com.example.shadow_xcodershome_crew.feature.worker.WorkerHubScreen

@Composable
fun HomeCrewNavGraph() {
    val backStack = remember { mutableStateListOf<NavKey>(NavKey.Splash) }
    val customerViewModel = remember { CustomerHomeViewModel() }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is NavKey.Splash -> NavEntry(key) {
                    SplashScreen(
                        onNavigateToRoleSelection = {
                            backStack.clear()
                            backStack.add(NavKey.RoleSelection)
                        }
                    )
                }
                is NavKey.RoleSelection -> NavEntry(key) {
                    RoleSelectionScreen(
                        onRoleSelected = { role ->
                            backStack.add(NavKey.Auth(role))
                        }
                    )
                }
                is NavKey.Auth -> NavEntry(key) {
                    AuthScreen(
                        role = key.role,
                        onBackClick = { backStack.removeLastOrNull() },
                        onSuccessAuth = {
                            backStack.clear()
                            if (key.role == UserRole.CUSTOMER) {
                                backStack.add(NavKey.CustomerHome)
                            } else {
                                backStack.add(NavKey.WorkerHub)
                            }
                        }
                    )
                }
                is NavKey.Dashboard -> NavEntry(key) {
                    DashboardScreen(
                        role = key.role,
                        onSignOut = {
                            backStack.clear()
                            backStack.add(NavKey.RoleSelection)
                        }
                    )
                }
                is NavKey.WorkerHub -> NavEntry(key) {
                    WorkerHubScreen(
                        onSignOut = {
                            backStack.clear()
                            backStack.add(NavKey.RoleSelection)
                        }
                    )
                }
                is NavKey.CustomerHome -> NavEntry(key) {
                    CustomerHomeScreen(
                        viewModel = customerViewModel,
                        onNavigateToCategories = {
                            backStack.add(NavKey.ServiceCategories)
                        },
                        onNavigateToCategoryWorkers = { catId, catName ->
                            backStack.add(NavKey.CategoryWorkers(catId, catName))
                        },
                        onNavigateToWorkerProfile = { workerId ->
                            backStack.add(NavKey.WorkerProfile(workerId))
                        },
                        onNavigateToQuotationComparison = { reqId ->
                            backStack.add(NavKey.QuotationComparison(reqId))
                        },
                        onNavigateToJobRequest = {
                            backStack.add(NavKey.JobRequestForm())
                        },
                        onNavigateToBookingTracking = {
                            backStack.add(NavKey.BookingTracking(workerName = "Alex Rivera", totalAmount = 115.0))
                        },
                        onSignOut = {
                            backStack.clear()
                            backStack.add(NavKey.RoleSelection)
                        }
                    )
                }
                is NavKey.ServiceCategories -> NavEntry(key) {
                    ServiceCategoriesScreen(
                        onBackClick = { backStack.removeLastOrNull() },
                        onCategoryClick = { catId, catName ->
                            backStack.add(NavKey.CategoryWorkers(catId, catName))
                        }
                    )
                }
                is NavKey.CategoryWorkers -> NavEntry(key) {
                    CategoryWorkersScreen(
                        categoryId = key.categoryId,
                        categoryName = key.categoryName,
                        onBackClick = { backStack.removeLastOrNull() },
                        onWorkerClick = { workerId ->
                            backStack.add(NavKey.WorkerProfile(workerId))
                        }
                    )
                }
                is NavKey.WorkerProfile -> NavEntry(key) {
                    val worker = customerViewModel.getWorkerById(key.workerId)
                    if (worker != null) {
                        WorkerProfileScreen(
                            worker = worker,
                            onBackClick = { backStack.removeLastOrNull() },
                            onRequestQuotation = { workerId ->
                                backStack.add(NavKey.QuotationComparison("req_1"))
                            }
                        )
                    } else {
                        Text("Worker not found")
                    }
                }
                is NavKey.JobRequestForm -> NavEntry(key) {
                    JobRequestFormScreen(
                        initialCategoryId = key.categoryId,
                        onBackClick = { backStack.removeLastOrNull() },
                        onSubmitRequest = { reqId ->
                            backStack.add(NavKey.QuotationComparison(reqId))
                        }
                    )
                }
                is NavKey.QuotationComparison -> NavEntry(key) {
                    QuotationComparisonScreen(
                        serviceRequestId = key.serviceRequestId,
                        onBackClick = { backStack.removeLastOrNull() },
                        onBookWorker = { workerName, totalAmount ->
                            backStack.add(NavKey.BookingConfirmation(workerName = workerName, totalAmount = totalAmount))
                        }
                    )
                }
                is NavKey.BookingConfirmation -> NavEntry(key) {
                    BookingConfirmationScreen(
                        bookingId = key.bookingId,
                        workerName = key.workerName,
                        totalAmount = key.totalAmount,
                        dateTime = key.dateTime,
                        onTrackBooking = {
                            backStack.add(NavKey.BookingTracking(bookingId = key.bookingId, workerName = key.workerName, totalAmount = key.totalAmount, dateTime = key.dateTime))
                        },
                        onViewDetails = {
                            backStack.add(NavKey.BookingTracking(bookingId = key.bookingId, workerName = key.workerName, totalAmount = key.totalAmount, dateTime = key.dateTime))
                        },
                        onBackToHome = {
                            backStack.clear()
                            backStack.add(NavKey.CustomerHome)
                        }
                    )
                }
                is NavKey.BookingTracking -> NavEntry(key) {
                    BookingTrackingScreen(
                        bookingId = key.bookingId,
                        workerName = key.workerName,
                        totalAmount = key.totalAmount,
                        initialStep = key.initialStep,
                        onBackClick = { backStack.removeLastOrNull() },
                        onHomeClick = {
                            backStack.clear()
                            backStack.add(NavKey.CustomerHome)
                        }
                    )
                }
                else -> NavEntry(key) { Text("Unknown destination") }
            }
        }
    )
}
