package com.abramkinapps.android.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abramkinapps.android.shoppinglist.data.ShopListRepositoryImpl
import com.abramkinapps.android.shoppinglist.data.ShopListRepositoryImpl.getShopList
import com.abramkinapps.android.shoppinglist.domain.DeleteShopItemUseCase
import com.abramkinapps.android.shoppinglist.domain.EditShopItemUseCase
import com.abramkinapps.android.shoppinglist.domain.GetShopListUseCase
import com.abramkinapps.android.shoppinglist.domain.ShopItem


class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem) {

        deleteShopItemUseCase.deleteShopItem(shopItem)


    }

    fun changeEnableState(shopItem: ShopItem) {

        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)



    }
}