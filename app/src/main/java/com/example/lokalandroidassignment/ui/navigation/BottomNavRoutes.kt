package com.example.lokalandroidassignment.ui.navigation

sealed class BottomNavRoutes(val routes: String){

    object Job : Routes("Job")
    object JobDetail : Routes("Job_Detail/{jobId}"){
        fun passJobID(jobId: Long): String {
            return "Job_Detail/$jobId"
        }
    }

    object Bookmark : Routes("Bookmark")
    object BookmarkDetail : Routes("Bookmark_Detail/{jobId}"){
        fun passBookmarkJobId(jobId: Long): String {
            return "Bookmark_Detail/$jobId"
        }
    }

}