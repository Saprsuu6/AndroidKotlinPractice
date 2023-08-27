package com.example.plantshandbook.models

class StatusCodes {
    companion object {
        var codes: ArrayList<String> = arrayListOf()

        init {
            for (statusCode in 100..103) {
                codes.add(statusCode.toString())
            }
            for (statusCode in 200..208) {
                codes.add(statusCode.toString())
            }
            codes.add("226")
            for (statusCode in 300..308) {
                codes.add(statusCode.toString())
            }
            for (statusCode in 400..451) {
                codes.add(statusCode.toString())
            }
            codes.add("499")
            for (statusCode in 500..526) {
                codes.add(statusCode.toString())
            }
        }
    }
}
