package br.cericatto.gok.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.cericatto.gok.network.GokApi
import br.cericatto.gok.network.GokProperty
import br.cericatto.gok.utils.GokApiStatus
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    /**
     * API.
     */

    private val _status = MutableLiveData<GokApiStatus>()
    val status: LiveData<GokApiStatus>
        get() = _status

    private val _properties = MutableLiveData<GokProperty>()
    val properties: LiveData<GokProperty>
        get() = _properties

    private val _displayDataOnUI = MutableLiveData<GokProperty>()
    val displayDataOnUI: LiveData<GokProperty>
        get() = _displayDataOnUI

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    /**
     * Retrofit.
     */

    fun getGokData() {
        viewModelScope.launch {
            _status.value = GokApiStatus.LOADING
            try {
                _properties.value = GokApi.retrofitService.getProperties()
                _status.value = GokApiStatus.DONE
                displayPropertyDetails(properties.value!!)
            } catch (e: Exception) {
                _status.value = GokApiStatus.ERROR
//                _properties.value = GokProperty()
            }
        }
    }

    /**
     * API Return.
     */

    private fun displayPropertyDetails(property: GokProperty) {
        _displayDataOnUI.value = property
    }
}