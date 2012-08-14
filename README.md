Turpial for Android
===================

Android version of Turpial, Twitter and Identi.ca client. Light, fast and fully functional.

Clone the common part
---------------------

Turpial for Android needs the common part built using Phonegap, so before building all you need to clone Turpial-mobile repository into "assets" folder typing something like this:

	git clone Your-Turpial-mobile.git www

For example:

	git clone git@github.com:Turpial/Turpial-mobile.git www

How to build it:
----------------

- Install ant
- Download the Android SDK from http://developer.android.com/sdk/index.html if you don't have it yet.
- Extract the package somewhere (I placed it in my home directory /home/andrea/android-sdk-linux_x86).
- Set ANDROID_SDK environment variable with the path where your SDK folder is placed.
- Run "make" to build the .apk
- Run "make upload" to launch Turpial on your device. For any problem read the YMCA makefile.
