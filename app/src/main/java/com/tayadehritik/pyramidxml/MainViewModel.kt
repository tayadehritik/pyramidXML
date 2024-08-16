package com.tayadehritik.pyramidxml

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tayadehritik.pyramidxml.data.Pyramid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel:ViewModel() {

    val _pyramid = MutableStateFlow(Pyramid(0))
    var pyramid = _pyramid.asStateFlow()

    fun updatePyramidHeight(value:Int) {
        _pyramid.value = Pyramid(value)
    }

    fun getResultString(): String {
        var resultString = mutableListOf<String>()
        for(i in 1.._pyramid.value.height) {
            var rowString = List<Char>((i*2)-1){'*'}
            resultString.add(rowString.joinToString("")+"\n")
            //need to string adjust the rowString
        }
        return resultString.joinToString()
    }
}