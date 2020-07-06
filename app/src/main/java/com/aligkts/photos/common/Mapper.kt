package com.aligkts.photos.common

interface Mapper<R, D> {
    fun mapFrom(type: R): D
}