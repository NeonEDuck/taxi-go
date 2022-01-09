package com.example.taxi_go

class Storage {
    companion object {
        var account = ""
        var recordList = listOf<Record>()
    }
}

class Record (
    var originId: Int,
    var destinationId: Int,
    var date: String?,
    var timeBefore: String?,
    var timeAfter: String?
)