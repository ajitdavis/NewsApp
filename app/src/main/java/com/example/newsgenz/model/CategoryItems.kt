package com.example.newsgenz.model

sealed class CategoryItems() {
    data class CorouselItems(val list: List<String>):CategoryItems()
    data class NewsCategory(val list: List<Category>):CategoryItems()
    data class ListItems(val list: List<CommonDataClass>):CategoryItems()
}