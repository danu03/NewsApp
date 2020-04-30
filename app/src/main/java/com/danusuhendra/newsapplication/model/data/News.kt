package com.danusuhendra.newsapplication.model.data

import java.util.*


data class News(var title : String = "",
                var content : String = "",
                var category : String = "",
                var imgThumbnail : Int = 0,
                var imgLarge : Int = 0,
                var date : String = ""
)