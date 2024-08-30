# Lokal Android Assignment

This project is an Android application built using Kotlin, Jetpack Compose, and various modern Android libraries. The app is designed with a focus on clean architecture, leveraging MVVM, state management, and robust network handling through sealed classes. Below, you'll find a detailed overview of the app, its key components, features, and media showcasing its functionality.

## Description

This Android application fetches job listings from a remote API and displays them in a clean, user-friendly UI. Users can browse jobs, view detailed information, and bookmark jobs for later reference. The app is built using modern Android development practices, ensuring scalability, maintainability, and a smooth user experience.

- **Images:** [Link to Images](https://github.com/AndroidLord/Lokal_Android_Assignment/tree/master/Images)
- **Video:** [Google Drive Video](https://drive.google.com/file/d/1DDRsx_Nnkw7GjAE1F6Hld56oMLh15NME/view?usp=sharing)

## Key Components

- **Kotlin & Jetpack Compose:** Used for building the UI and managing UI states efficiently.
- **Dagger-Hilt:** Dependency injection framework for providing dependencies across the app.
- **Flow & Coroutines:** Handle asynchronous data streams and manage background tasks.
- **Room Database:** Manage local data storage, specifically for storing bookmarked jobs.
- **Navigation Graph:** Manages in-app navigation with a single activity architecture.
- **Coil:** Load images efficiently in the app.
- **Retrofit & OkHttp:** Handle network requests and responses, including parsing JSON data with `GsonConverterFactory`.

## Features

- **Job Listing:** Display a list of job postings fetched from a remote API.
- **Pagination:** Automatically load more jobs as the user scrolls down.
- **Job Details:** View detailed information about each job, including location, salary, and contact information.
- **Bookmark Jobs:** Bookmark jobs for later viewing, even when offline.
- **Offline Support:** Bookmarked jobs are stored locally, allowing offline access.
- **Error Handling:** User-friendly error messages and retry options when network issues occur.
- **Loading States:** Smooth loading animations while data is being fetched.


## Video

- **App Demonstration:** [Watch the Video](https://drive.google.com/file/d/1DDRsx_Nnkw7GjAE1F6Hld56oMLh15NME/view?usp=sharing)


## Compact Images

<table>
<tr>
<td><img src="https://github.com/AndroidLord/Lokal_Android_Assignment/blob/master/Images/Job%20Screen.png" width="150" /></td>
<td><img src="https://github.com/AndroidLord/Lokal_Android_Assignment/blob/master/Images/job%20detail%20screen.png" width="150" /></td>
<td><img src="https://github.com/AndroidLord/Lokal_Android_Assignment/blob/master/Images/job%20detail%20screen2.png" width="150" /></td>
<td><img src="https://github.com/AndroidLord/Lokal_Android_Assignment/blob/master/Images/bookmark%20screen.png" width="150" /></td>
<td><img src="https://github.com/AndroidLord/Lokal_Android_Assignment/blob/master/Images/no%20more%20jobs.png" width="150" /></td>
</tr>
<tr>
<td style="text-align:center;">Job Screen</td>
<td style="text-align:center;">Detail Screen Part 1</td>
<td style="text-align:center;">Detail Screen Part 2</td>
<td style="text-align:center;">Bookmark Screen</td>
<td style="text-align:center;">No More Jobs Screen</td>
</tr>
</table>

## Images

<div style="overflow-x: auto; white-space: nowrap;">
  <img src="https://github.com/AndroidLord/Lokal_Android_Assignment/blob/master/Images/Job%20Screen.png" alt="Job Screen" width="300" style="display: inline-block; margin-right: 10px;">
  <img src="https://github.com/AndroidLord/Lokal_Android_Assignment/blob/master/Images/job%20detail%20screen.png" alt="Detail Screen Part 1" width="300" style="display: inline-block; margin-right: 10px;">
  <img src="https://github.com/AndroidLord/Lokal_Android_Assignment/blob/master/Images/job%20detail%20screen2.png" alt="Detail Screen Part 2" width="300" style="display: inline-block; margin-right: 10px;">
  <img src="https://github.com/AndroidLord/Lokal_Android_Assignment/blob/master/Images/bookmark%20screen.png" alt="Bookmark Screen" width="300" style="display: inline-block; margin-right: 10px;">
  <img src="https://github.com/AndroidLord/Lokal_Android_Assignment/blob/master/Images/no%20more%20jobs.png" alt="No More Jobs Screen" width="300" style="display: inline-block;">
</div>


