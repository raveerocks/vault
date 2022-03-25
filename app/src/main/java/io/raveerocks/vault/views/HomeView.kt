package io.raveerocks.vault.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeView:ViewModel() {

    abstract class Item(val name: String,val value: Any)
    data class Note(val noteName:String,val noteValue:String): Item(noteName,noteValue)
    data class Number(val numberName:String,val numberValue:Int): Item(numberName,numberValue)
    data class BoardingPass(val numberName:String,val passValue:String): Item(numberName,passValue)
    data class Gift(val numberName:String,val giftValue:String): Item(numberName,giftValue)
    data class Location(val numberName:String,val locationValue:String): Item(numberName,locationValue)

    val items : LiveData< List<Item>>
        get() = _items

    private val _items = MutableLiveData< List<Item>>()


    init {
        val list = listOf<Item>(
            BoardingPass("India","first note"),
            Number("Access Key",856),
            Note("First","first note"),
            BoardingPass("Nepal","fifth note"),
            Gift("Third","third note"),
            Note("Fourth","fourth note"),
            Note("Fifth","fifth note"),
            Number("Passcode",23456),
            BoardingPass("Australia","second note"),
            BoardingPass("Kuwait","third note"),
            Note("Second","second note"),
            BoardingPass("Canada","fourth note"),
            Note("Third","third note"),
            BoardingPass("India","first note"),
            Number("Access Key",856),
            Gift("Canada","fourth note"),
            Gift("Australia","second note"),
            Note("First","first note"),
            Location("Italy","second note"),
            BoardingPass("Nepal","fifth note"),
            Note("Fourth","fourth note"),
            Note("Fifth","fifth note"),
            Number("Passcode",23456),
            Gift("Third","third note"),
            BoardingPass("Australia","second note"),
            BoardingPass("Kuwait","third note"),
            Gift("Second","second note"),
            Note("Second","second note"),
            BoardingPass("Canada","fourth note"),
            Note("Third","third note"),
            Location("France","second note"),
            BoardingPass("India","first note"),
            Number("Access Key",856),
            Note("First","first note"),
            BoardingPass("Nepal","fifth note"),
            Gift("Second","second note"),
            Note("Fourth","fourth note"),
            Note("Fifth","fifth note"),
            Number("Passcode",23456),
            BoardingPass("Australia","second note"),
            BoardingPass("Kuwait","third note"),
            Note("Second","second note"),
            Gift("Kuwait","third note"),
            Gift("Canada","fourth note"),
            BoardingPass("Canada","fourth note"),
            Note("Third","third note"),
            Location("Australia","second note")

        )
        _items.postValue(list)
    }

}