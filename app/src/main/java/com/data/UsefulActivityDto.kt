package com.data

import com.entity.UsefulActivity

class UsefulActivityDto(override var activity: String,
                        override var type: String,
                        override var participants: Int,
                        override var price: Float,
                        override var link: String,
                        override var key: String,
                        override var accessibility: Float
) : UsefulActivity {
}

