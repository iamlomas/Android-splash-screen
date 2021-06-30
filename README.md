# Android splash screen

Easily create splash screen for your app.

<img src="/resources/android_splash_screen.png" width="80%" alt="Android Splash Screen"/>

Create cool and customizable splash screen for your android apps with minimal effort using this library.

## SetUp

### Installation
This library is available on Jitpack.

* Steps for Gradle:

Step1:
In your build file add the JitPack repository.
Add it in your root build.gradle at the end of repositories:
```kotlin
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
Step 2:
Add the dependency
```kotlin
	dependencies {
	        implementation 'com.github.iamlomas:Android-splash-screen:v1.0'
	}
```

* Steps for maven:

Step 1:
Add the JitPack repository to your build file
```maven
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
 ```
Step 2:
Add the dependency
```maven
	<dependency>
	    <groupId>com.github.iamlomas</groupId>
	    <artifactId>Android-splash-screen</artifactId>
	    <version>v1.0</version>
	</dependency>
 ```

* Steps for sbt:

Step 1:
Add the JitPack repository to your build file
Add it in your build.sbt at the end of resolvers:
```sbt
    resolvers += "jitpack" at "https://jitpack.io"
```
Step 2:
Add the dependency
```sbt
	libraryDependencies += "com.github.iamlomas" % "Android-splash-screen" % "v1.0"
 ```

* Steps for leiningen:

Step 1:
Add the JitPack repository to your build file
Add it in your project.clj at the end of repositories:
 ```leiningen
    :repositories [["jitpack" "https://jitpack.io"]]
```

Step 2:
Add the dependency
```leiningen
	:dependencies [[com.github.iamlomas/Android-splash-screen "v1.0"]]	
```

### Available functions

```kotlin
withFullScreen()
// This functions hides status bar only.
// To hide action bar in specific activity, use theme with no action bar property in activity declaration in manifest file.

withTargetActivity(tAct: Class<*>?)
// Specifies the activity to open after splash screen.

withSplashTimeOut(timeout: Int)
// Sets the duration of splash screen - by default 2 seconds
// @param - timeout duration in milliseconds

withBundleExtras(bundle: Bundle?)
// Provide android bundle to target activity

withBackgroundColor(@ColorInt splashBackgroundColor: Int)
// Sets the background color for this view.
// @param - the color of the background

withBackgroundResource(splashBackgroundResource: Int)
// Set the background to a given resource.
// The resource should refer to a Drawable object or 0 to remove the background.
// @param - The identifier of the resource.

withLogo(@DrawableRes logo: Int)
// Sets a drawable as the logo.
// @param - the resource identifier of the drawable

withHeaderText(text: String?)
// @param - text to be displayed in the header.

withFooterText(text: String?)
// @param - text to be displayed in the footer.

withAboveLogoText(text: String?)
// @param - text to be displayed just above the logo.

withBelowLogoText(text: String?)
// @param - text to be displayed just below the logo.

create()
// Creates the specified splash screen.
```

### Customize views

```kotlin
 val config: AndroidSplashScreen = AndroidSplashScreen(this).apply {
    	withFullScreen()
        withTargetActivity(MainActivity::class.java)
        withSplashTimeOut(4000)
        withBackgroundResource(R.drawable.stars_in_the_sky)
        withHeaderText("It's Header")
        withFooterText("It's Footer")
        withAboveLogoText("It's above logo text")
        withLogo(R.drawable.logo_white)
        withBelowLogoText(
            "It's below logo text\n\"Photo by Juskteez Vu on Unsplash\""
        )
}

// customize all TextViews
config.apply {
    tvBelowLogoText!!.typeface = Typeface.createFromAsset(assets, "lucidaCalligraphy.ttf")
    tvHeader!!.setTextColor(Color.WHITE)
    tvFooter!!.setTextColor(Color.WHITE)
    tvAboveLogoText!!.setTextColor(Color.WHITE)
    tvBelowLogoText!!.setTextColor(Color.WHITE)
    tvBelowLogoText!!.textAlignment = TEXT_ALIGNMENT_CENTER
}

// finally create the view
setContentView(config.create())
```

## License

~~~
The MIT License (MIT)
Copyright (c) 2021 Lomas Singh

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files
(the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge,
publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
~~~
