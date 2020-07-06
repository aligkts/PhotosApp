package com.aligkts.photos.data.photos.response

import com.google.gson.annotations.SerializedName

data class RecentPhotos (

	@SerializedName("page")
	val page : Int,

	@SerializedName("pages")
	val pages : Int,

	@SerializedName("perpage")
	val perPage : Int,

	@SerializedName("total")
	val total : Int,

	@SerializedName("photo")
	val photoModel : List<PhotoModel>
)