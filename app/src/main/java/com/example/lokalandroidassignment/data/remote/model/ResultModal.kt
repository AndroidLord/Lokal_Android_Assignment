package com.example.lokalandroidassignment.data.remote.model

import com.example.lokalandroidassignment.data.local.modal.BookmarkJob

data class ResultModal(
    val id: Long,
    val amount: String,
    val button_text: String,
    val company_name: String,
    val content: String,
    val created_on: String,
    val custom_link: String,
    val expire_on: String,
    val fb_shares: Int,
    val fees_charged: Int,
    val fees_text: String,
    val is_applied: Boolean,
    val job_category: String,
    val job_hours: String,
    val job_location_slug: String,
    val job_role: String,
    val num_applications: Int,
    val openings_count: Int,
    val other_details: String,
    val premium_till: String,
    val salary_max: Int,
    val salary_min: Int,
    val shares: Int,
    val title: String,
    val updated_on: String,
    val views: Int,
    val whatsapp_no: String,

    val contact_preference: ContactPreference,
    val primary_details: PrimaryDetails,
    val job_tags: List<JobTag>,
    val creatives: List<Creative>,
    val contentV3: ContentV3,
    ) {

    fun isValid(): Boolean {
        return this.id != 0L
    }

    fun toBookmarkJob(): BookmarkJob {

        return BookmarkJob(
            id = id,
            amount = amount,
            button_text = button_text,
            company_name = company_name,
            content = content,
            created_on = created_on,
            custom_link = custom_link,
            expire_on = expire_on,
            fb_shares = fb_shares,
            fees_charged = fees_charged,
            fees_text = fees_text,
            is_applied = is_applied,
            job_category = job_category,
            job_hours = job_hours,
            job_location_slug = job_location_slug,
            job_role = job_role,
            num_applications = num_applications,
            openings_count = openings_count,
            other_details = other_details,
            premium_till = premium_till,
            salary_max = salary_max,
            salary_min = salary_min,
            shares = shares,
            title = title,
            updated_on = updated_on,
            views = views,
            whatsapp_no = whatsapp_no,
            contact_preference = contact_preference,
            primary_details = primary_details,
            job_tags = job_tags,
            creatives = creatives,
            V3 = contentV3.V3
        )
    }

}