Turpial for Android
===================

Android version of Turpial, the Twitter and Identi.ca client, light, fast and fully functional.

How to collaborate
------------------

Turpial for Android and in general Turpial Mobile is built using Phonegap, a cool framework that allows you to make apps using web technologies, so the main work will take place on the common part mainly (Turpial-mobile repo, take a look at its README first). 

The Android part is used to launch the application and providing a background service to fetch contents.

Any suggestion and patch are welcome, won't be ignored and will be discussed with the whole Turpial team.

Clone the common part
---------------------

Turpial for Android requires the common part built using Phonegap, so before start building you need to clone Turpial-mobile repository into "assets" folder typing something like this:

	git clone Your-Turpial-mobile.git www

For example:

	git clone git@github.com:Turpial/Turpial-mobile.git www

How to build it:
----------------

Requires:

- Apache Ant http://ant.apache.org
- Android SDK http://developer.android.com/sdk

Steps:

- Set ANDROID_SDK environment variable with the path where your Android SDK folder is placed.
- Run "make" to build the .apk
- Run "make upload" to launch Turpial on your device. For any problem read the YMCA Makefile.
