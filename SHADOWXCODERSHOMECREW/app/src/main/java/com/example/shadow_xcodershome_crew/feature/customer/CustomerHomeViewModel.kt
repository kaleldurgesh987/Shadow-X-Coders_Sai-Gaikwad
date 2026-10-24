package com.example.shadow_xcodershome_crew.feature.customer

import androidx.lifecycle.ViewModel
import com.example.shadow_xcodershome_crew.data.HomeCrewRepository
import com.example.shadow_xcodershome_crew.model.Quotation
import com.example.shadow_xcodershome_crew.model.ServiceCategory
import com.example.shadow_xcodershome_crew.model.Worker
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CustomerHomeUiState(
    val searchQuery: String = "",
    val selectedCategoryFilter: String? = null,
    val categories: List<ServiceCategory> = HomeCrewRepository.categories,
    val workers: List<Worker> = HomeCrewRepository.workers,
    val urgentHelpActive: Boolean = false,
    val activeQuotations: List<Quotation> = HomeCrewRepository.getQuotationsForRequest("req_1")
)

class CustomerHomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CustomerHomeUiState())
    val uiState: StateFlow<CustomerHomeUiState> = _uiState.asStateFlow()

    fun updateSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun selectCategoryFilter(categoryId: String?) {
        _uiState.update { it.copy(selectedCategoryFilter = categoryId) }
    }

    fun triggerUrgentHelp(active: Boolean) {
        _uiState.update { it.copy(urgentHelpActive = active) }
    }

    fun getWorkerById(workerId: String): Worker? {
        return _uiState.value.workers.find { it.id == workerId }
    }

    fun getWorkersForCategory(categoryId: String): List<Worker> {
        return _uiState.value.workers.filter { it.categoryId == categoryId }
    }

    fun getFilteredWorkers(): List<Worker> {
        val state = _uiState.value
        var list = state.workers
        if (!state.selectedCategoryFilter.isNullOrBlank()) {
            list = list.filter { it.categoryId == state.selectedCategoryFilter }
        }
        if (state.searchQuery.isNotBlank()) {
            val q = state.searchQuery.lowercase()
            list = list.filter {
                it.name.lowercase().contains(q) ||
                        it.categoryName.lowercase().contains(q) ||
                        it.skills.any { skill -> skill.lowercase().contains(q) } ||
                        it.bio.lowercase().contains(q)
            }
        }
        return list
    }
}
