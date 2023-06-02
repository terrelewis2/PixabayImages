# PixabayImages - A Pixabay client app for Android

PixabayImages is an Android app that allows users to search and view royalty free stock images. The images are fetched using the [Pixabay API](https://pixabay.com/).
It is written in Kotlin, uses Jetpack Compose, and follows Clean Architecture principles.

# Key features:
- Search for images using keywords
- View image details which includes likes, comments and downloads
- Searched images are cached in the database and can be viewed offline as well
- Dark theme support

# Screens
<table>
  <tr>
    <th>Feature</th>
    <th>Light Theme</th>
    <th>Dark Theme</th>
  </tr>
  <tr>
    <td>Search Images</td>
    <td><img src="https://github.com/terrelewis2/PixabayImages/assets/83067882/868283e5-ad29-4b14-a4af-b7d41152cca0"   height="550"  width="250"/></td>
    <td><img src="https://github.com/terrelewis2/PixabayImages/assets/83067882/c7d4026a-9fff-41df-919e-831392a65791"   height="550"  width="250"/></td>
  </tr>
    <tr>
    <td>View Image Detail</td>
    <td><img src="https://github.com/terrelewis2/PixabayImages/assets/83067882/b44edd85-4753-4345-abe7-d1ba53091b3a"   height="550"  width="250"/></td>
    <td><img src="https://github.com/terrelewis2/PixabayImages/assets/83067882/97319dc7-3554-4622-923d-197561be4307"   height="550"  width="250"/></td>
  </tr>
</table>

# To run the project: 

Add this to your local.properties file:
````
PIXABAY_API_KEY=YOUR_API_KEY
````

# Tech specifications
- 100% Kotlin based app
- Runs on Android 7.0 and higher
- Clean Architecture implementing two primary use cases: SearchImages and GetImageDetails
- UI built using Jetpack Compose and follows Material Design guidelines
