package com.aligkts.photos.data.photos.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PhotoModel(

	@SerializedName("id")
	val id: Long?,

	@SerializedName("owner")
	val owner: String?,

	@SerializedName("secret")
	val secret: String?,

	@SerializedName("server")
	val server: Int?,

	@SerializedName("farm")
	val farm: Int?,

	@SerializedName("title")
	val title: String?,

	@SerializedName("ispublic")
	val ispublic: Int?,

	@SerializedName("isfriend")
	val isfriend: Int?,

	@SerializedName("isfamily")
	val isfamily: Int?,

	@SerializedName("url_m")
	val url_m: String?,

	@SerializedName("height_m")
	val height_m: Int?,

	@SerializedName("width_m")
	val width_m: Int?
): Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readValue(Long::class.java.classLoader) as? Long,
		parcel.readString(),
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(id)
		parcel.writeString(owner)
		parcel.writeString(secret)
		parcel.writeValue(server)
		parcel.writeValue(farm)
		parcel.writeString(title)
		parcel.writeValue(ispublic)
		parcel.writeValue(isfriend)
		parcel.writeValue(isfamily)
		parcel.writeString(url_m)
		parcel.writeValue(height_m)
		parcel.writeValue(width_m)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<PhotoModel> {
		override fun createFromParcel(parcel: Parcel): PhotoModel {
			return PhotoModel(parcel)
		}

		override fun newArray(size: Int): Array<PhotoModel?> {
			return arrayOfNulls(size)
		}
	}

}