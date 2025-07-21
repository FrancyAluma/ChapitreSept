package com.example.chapitresept.navigation

import androidx.window.layout.FoldingFeature
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

sealed interface DeviceFoldPosture {

    data class BookPosture (val hingePosition: android.graphics.Rect) : DeviceFoldPosture

    data class SeparatingPosture (
        val hingePosition: android.graphics.Rect,
        val orientaion: FoldingFeature.Orientation
    ) : DeviceFoldPosture

    object NormalPosture : DeviceFoldPosture
}

@OptIn(ExperimentalContracts :: class)
fun isBookPosture (foldFeature : FoldingFeature?) : Boolean {

    contract { returns (true) implies (foldFeature != null) }
    return foldFeature?.state == FoldingFeature.State.HALF_OPENED &&
    foldFeature.orientation == FoldingFeature.Orientation.VERTICAL
}

@OptIn(ExperimentalContracts :: class)
fun isSeparating(foldFeature : FoldingFeature?) : Boolean {

    contract { returns(true) implies (foldFeature != null )  }
    return foldFeature?.state == FoldingFeature.State.FLAT && foldFeature.isSeparating

}


