<p align="center"><a href="https://titaniumsdk.com" target="_blank"><img width="120" src=".github/logo-titanium.png"></a></p>

<h1 align="center">Titanium SDK</h1>

<p align="center"><a href="https://github.com/tidev/titanium-sdk/actions/workflows/build.yml?query=branch%3Amaster" target="_blank"><img src="https://github.com/tidev/titanium-sdk/actions/workflows/build.yml/badge.svg?branch=master" /></a></p>

Welcome to the Titanium SDK open source project. Titanium SDK provides a mature platform for developers to build
completely native cross-platform mobile applications using JavaScript.

Currently supported native platforms are iOS and Android.

Titanium SDK is licensed under the OSI approved Apache Public License (version 2). Please
see the [LICENSE](LICENSE) file for specific details.

# Table of Contents

- [Table of Contents](#table-of-contents)
  - [Sponsors](#sponsors)
  - [Features](#features)
  - [Hyperloop](#hyperloop)
    - [Features](#features-1)
      - [Cross-Platform Reuse](#cross-platform-reuse)
      - [Direct API Access](#direct-api-access)
      - [JavaScript Everywhere](#javascript-everywhere)
      - [3rd-Party Libraries](#3rd-party-libraries)
      - [Custom Animations](#custom-animations)
      - [Run Native](#run-native)
    - [Example](#example)
    - [Getting Started](#getting-started)
  - [Alloy](#alloy)
    - [Example](#example-1)
  - [Getting Help](#getting-help)
    - [Official Documentation, Tutorials and Videos](#official-documentation-tutorials-and-videos)
    - [Developer Community](#developer-community)
    - [Video Tutorials](#video-tutorials)
    - [Slack](#slack)
    - [Twitter](#twitter)
    - [Blog](#blog)
    - [Commercial Support, Licensing](#commercial-support-licensing)
  - [Contributing](#contributing)
  - [Building Locally](#building-locally)
    - [Unit tests](#unit-tests)
      - [How it works](#how-it-works)
      - [How to modify the tests locally and in your PRs](#how-to-modify-the-tests-locally-and-in-your-prs)
    - [Upgrade gradle and gradle plugin](#upgrade-gradle-and-gradle-plugin)
  - [Legal Stuff](#legal-stuff)

## Sponsors

This project wouldn't be possible without the help of our world wide developer community. Become a sponsor
today and benefit from 1:1 sessions with the core team, exclusive modules, merchandise and more!

Learn more about sponsoring TiDev, the organization behind the Titanium SDK, [here](https://github.com/sponsors/tidev) 🚀.

<!-- sponsors --><a href="https://github.com/phobeous"><img src="https:&#x2F;&#x2F;github.com&#x2F;phobeous.png" width="60px" alt="User avatar: Rodrigo Farfán" /></a><a href="https://github.com/dlewis23"><img src="https:&#x2F;&#x2F;github.com&#x2F;dlewis23.png" width="60px" alt="User avatar: dlewis23" /></a><a href="https://github.com/dethier1958"><img src="https:&#x2F;&#x2F;github.com&#x2F;dethier1958.png" width="60px" alt="User avatar: Daniel Ethier" /></a><a href="https://github.com/zenjoe"><img src="https:&#x2F;&#x2F;github.com&#x2F;zenjoe.png" width="60px" alt="User avatar: Joe Kniesek" /></a><a href="https://github.com/desarrollogotit"><img src="https:&#x2F;&#x2F;github.com&#x2F;desarrollogotit.png" width="60px" alt="User avatar: " /></a><a href="https://github.com/Astrovic"><img src="https:&#x2F;&#x2F;github.com&#x2F;Astrovic.png" width="60px" alt="User avatar: Vittorio Sorbera" /></a><a href="https://github.com/Arood"><img src="https:&#x2F;&#x2F;github.com&#x2F;Arood.png" width="60px" alt="User avatar: Marcus Olovsson" /></a><a href="https://github.com/Rearmachine"><img src="https:&#x2F;&#x2F;github.com&#x2F;Rearmachine.png" width="60px" alt="User avatar: " /></a><a href="https://github.com/alexlarocca"><img src="https:&#x2F;&#x2F;github.com&#x2F;alexlarocca.png" width="60px" alt="User avatar: Alessandro La Rocca" /></a><a href="https://github.com/reshopper"><img src="https:&#x2F;&#x2F;github.com&#x2F;reshopper.png" width="60px" alt="User avatar: Reshopper" /></a><a href="https://github.com/safadig"><img src="https:&#x2F;&#x2F;github.com&#x2F;safadig.png" width="60px" alt="User avatar: Gus" /></a><a href="https://github.com/designbymind"><img src="https:&#x2F;&#x2F;github.com&#x2F;designbymind.png" width="60px" alt="User avatar: Jason David Miller" /></a><a href="https://github.com/greatschism"><img src="https:&#x2F;&#x2F;github.com&#x2F;greatschism.png" width="60px" alt="User avatar: " /></a><a href="https://github.com/enzoq"><img src="https:&#x2F;&#x2F;github.com&#x2F;enzoq.png" width="60px" alt="User avatar: Vincenzo Quacquarelli" /></a><a href="https://github.com/mighty-office"><img src="https:&#x2F;&#x2F;github.com&#x2F;mighty-office.png" width="60px" alt="User avatar: Mighty GmbH" /></a><a href="https://github.com/korelogic"><img src="https:&#x2F;&#x2F;github.com&#x2F;korelogic.png" width="60px" alt="User avatar: Korelogic Limited" /></a><a href="https://github.com/eddyinet"><img src="https:&#x2F;&#x2F;github.com&#x2F;eddyinet.png" width="60px" alt="User avatar: " /></a><a href="https://github.com/gouldjw"><img src="https:&#x2F;&#x2F;github.com&#x2F;gouldjw.png" width="60px" alt="User avatar: John Gould" /></a><a href="https://github.com/mediabug51"><img src="https:&#x2F;&#x2F;github.com&#x2F;mediabug51.png" width="60px" alt="User avatar: " /></a><a href="https://github.com/victorpl"><img src="https:&#x2F;&#x2F;github.com&#x2F;victorpl.png" width="60px" alt="User avatar: " /></a><a href="https://github.com/PatrickMounteney"><img src="https:&#x2F;&#x2F;github.com&#x2F;PatrickMounteney.png" width="60px" alt="User avatar: Patrick Mounteney" /></a><a href="https://github.com/lambus-platform"><img src="https:&#x2F;&#x2F;github.com&#x2F;lambus-platform.png" width="60px" alt="User avatar: Lambus" /></a><a href="https://github.com/emptybox"><img src="https:&#x2F;&#x2F;github.com&#x2F;emptybox.png" width="60px" alt="User avatar: Vaughn Dabney" /></a><a href="https://github.com/Whatslively"><img src="https:&#x2F;&#x2F;github.com&#x2F;Whatslively.png" width="60px" alt="User avatar: Whatslively" /></a><a href="https://github.com/JeremyFlight"><img src="https:&#x2F;&#x2F;github.com&#x2F;JeremyFlight.png" width="60px" alt="User avatar: Jeremy Flight" /></a><a href="https://github.com/Alpine-Software"><img src="https:&#x2F;&#x2F;github.com&#x2F;Alpine-Software.png" width="60px" alt="User avatar: Alpine Software" /></a><a href="https://github.com/elusu"><img src="https:&#x2F;&#x2F;github.com&#x2F;elusu.png" width="60px" alt="User avatar: " /></a><a href="https://github.com/wittawoot"><img src="https:&#x2F;&#x2F;github.com&#x2F;wittawoot.png" width="60px" alt="User avatar: Wittawoot Thongbor" /></a><a href="https://github.com/PayMon-app"><img src="https:&#x2F;&#x2F;github.com&#x2F;PayMon-app.png" width="60px" alt="User avatar: PayMon" /></a><a href="https://github.com/oshevans"><img src="https:&#x2F;&#x2F;github.com&#x2F;oshevans.png" width="60px" alt="User avatar: Osian Evans" /></a><a href="https://github.com/UniqueSchools"><img src="https:&#x2F;&#x2F;github.com&#x2F;UniqueSchools.png" width="60px" alt="User avatar: " /></a><!-- sponsors -->

## Features

With Titanium SDK, you use JavaScript to code your application. Titanium's compiler will compile
your application code into an efficient native executable for each target mobile platform.

- [x] Native apps built using JavaScript (no hybrid, no embedded WebView)
- [x] Apps are compiled and run locally with full offline support
- [x] Support for native platform UI controls (TabGroup (iOS), ActionBar (Android), AppBar (Windows), ...)
- [x] Support for watchOS targets
- [x] Support for in-application SQL database
- [x] Support for Geolocation (compass, geolocation, forward/reverse lookup)
- [x] Support for Camera (taking Photos, playing and recording Video)
- [x] Support for Calendar (creating & fetching Events)
- [x] Support for 3D-Touch (Peek and Pop, Application Shortcuts, ...)
- [x] Support for Photo Album (reading and writing)
- [x] Support for Contacts Database / Address Book
- [x] Support for Streaming Audio and Recording Audio, Audio Input Levels, Mic etc
- [x] Support for Vibration
- [x] Support for Social APIs such as Facebook, Twitter, etc.
- [x] Support for Yahoo YQL
- [x] Support for Web Services via REST, SOAP
- [x] Support for native Maps
- [x] Support for Push Notifications
- [x] Support for In-Application Email
- [x] Support for In-Application SMS, Telephone
- [x] Support for Filesystem (create, read, write, etc.)
- [x] Support for Gestures (such as Shake and Pinch)
- [x] Support for Platform and Device capabilities
- [x] Support for complex native views such as Coverflow, Image Views, Table Views, Grouped Views, Composites, etc.
- [x] Support for Web Views incorporating HTML5, CSS etc.
- [x] Completely extensible via Module API and Hyperloop for building your own controls or extending capabilities

And much, much more (see our [Documentation](https://titaniumsdk.com/) for more infos).

## Hyperloop

Use Hyperloop, our latest addition to the Appcelerator Platform, to extend your Titanium SDK apps by native API's using
JavaScript. Prior to Hyperloop, you would use [native modules](https://titaniumsdk.com/guide/Titanium_SDK/Titanium_SDK_How-tos/Extending_Titanium_Mobile/Titanium_Module_Concepts.html) to extend the Titanium SDK API. With
Hyperloop, you are now able to implement native classes, 3rd-Party libraries (Cocoapods, local frameworks, .aar files)
and more directly into your apps. Hyperloop is available for iOS, Android and Windows Phone (Tech Preview).

### Features

#### Cross-Platform Reuse

Build and maintain apps in a fraction of the time with up to 95% code reuse.

#### Direct API Access

Access 100% of platform APIs directly, with instant support for each new OS release.

#### JavaScript Everywhere

Create mobile apps using the world’s most popular programming language.

#### 3rd-Party Libraries

Incorporate 3rd-party native libraries using JavaScript, with no changes required.

#### Custom Animations

Easily create complex custom effects like dynamic animations using JavaScript.

#### Run Native

Mobile app development for every major mobile OS – with no hybrid compromises.

### Example

Create a native view in iOS and Android:

```js
// iOS
var view = new UIView();

// Android
var view = new View(activity);
```

### Getting Started

Check out our [Hyperloop Sample App](https://github.com/tidev/hyperloop-examples) and [Hyperloop Programming Guide](https://titaniumsdk.com/guide/Titanium_SDK/Titanium_SDK_Guide/Hyperloop/) to get started with Hyperloop today!

## Alloy

[Alloy](https://titaniumsdk.com/guide/Alloy_Framework/Alloy_Getting_Started.html) is the MVC application framework built
on top of Titanium SDK. It is optional. It rocks. Check it out if you're considering using Titanium SDK.
It is also a separate [open source project](https://github.com/tidev/alloy) available under Apache Public License.

### Example

Manage your application scope by separating your code into different models, views, controllers and more:

**index.xml** (View)

```xml
<Alloy>
  <Window title="Titanium SDK and Alloy">
    <Button onClick="handleClick" id="myButton">Click me!</Button>
  </Window>
</Alloy>
```

**index.js** (Controller)

```js
function handleClick() {
  alert('Hello from the Controller!');
}
```

**index.tss** (Style)

```js
Window: {
  backgroundColor: 'white'
}

"#myButton": {
  width: 200,
  height: 30,
  backgroundColor: 'green'
}
```

## Getting Help

There are a number of ways to get help with Titanium SDK.

### Official Documentation, Tutorials and Videos

Please visit the official documentation site at [https://titaniumsdk.com/](https://titaniumsdk.com/) for the latest and historical documentation on Titanium SDK, Alloy and other modules.

### Slack / Developer Community

Community support and discussion about Titanium SDK is available on Slack at [TiSlack](https://slack.tidev.io) or at [GitHub Discussions](https://github.com/tidev/titanium-sdk/discussions).

### Twitter

Please consider following [@Titanium SDK](http://www.twitter.com/titaniumsdk) and [@TiDev](https://twitter.com/tidevio) on Twitter for updates.

### Commercial Support, Licensing

We give our software away for FREE! In order to do that, we have programs for companies that require additional level of assistance through training or commercial support, need special licensing or want additional levels of capabilities. Please visit the [TiDev Website](https://tidev.io) for more information about TiDev or email [info@tidev.io](mailto:info@tidev.io).

## Contributing

Titanium SDK is an open source project. Titanium SDK wouldn't be where it is now without contributions by the community. Please consider forking Titanium SDK to improve, enhance or fix issues. If you feel like the community will benefit from your fork, please open a pull request.

To protect the interests of the Titanium SDK contributors, Appcelerator, customers and end users we require contributors to sign a Contributors License Agreement (CLA) before we pull the changes into the main repository. Our CLA is simple and straightforward - it requires that the contributions you make to any Appcelerator open source project are properly licensed and that you have the legal authority to make those changes. This helps us significantly reduce future legal risk for everyone involved. It is easy, helps everyone, takes only a few minutes, and only needs to be completed once.

[You can digitally sign the CLA](https://github.com/tidev/organization-docs/blob/main/AUTHORIZED_CONTRIBUTORS.md) online. Please indicate your email address in your first pull request so that we can make sure that will locate your CLA.  Once you've submitted it, you no longer need to send one for subsequent submissions.

## Building Locally

If you'd like to build the SDK locally you can use the included npm scripts:

```bash
npm ci
npm run cleanbuild
```

The build and package commands will default to all target platforms on your host OS unless explicitly specified. (i.e. Android, iOS on macOS; Windows and Android on Windows). It will compile, package and install the locally-built SDK for you
as well, so you can test it in your own applications without any further procedures.

The build command will look for the Android SDK directory path via the $ANDROID_SDK env variables if not explicitly passed using command line arguments.

You can use the `-h` flag to display the full list of comands and options.

```bash
npm ci
npm run cleanbuild -- [platform1] [platform2] --android-sdk /opt/android-sdk /Users/build/android-sdk-macosx
```

### Unit tests

We have a [unit test suite](tests/) intended to run across all supported platforms.

We have npm scripts set up to run a full clean, build, package, symlinked install, `ti sdk select` the built sdk, and then run the unit test suite:

```bash
npm run test:android
npm run test:iphone
npm run test:ipad
```

#### How it works

The test suite generates a single Titanium SDK project targeting the specified platform(s), builds the project for emulator, launches the app on the emulator and then runs a series of tests defined via ti-mocha and should.js.

The tests spit out their results to the console log, and the test scripts listen to the logs to gather the results. We then generate an overview on the console as well as a junit report xml file (to be consume by CI build systems like Jenkins).

#### How to modify the tests locally and in your PRs

The `tests` folder contains the test suite. Any files living within that directory are copied on top of the test app's structure.


### Upgrade gradle and gradle plugin

The gradle (tool, build system) and gradle plugin (plugin that adds several features that are specific to building Android apps) version numbers are located in:
* `android/build.gradle`
* `android/gradle/wrapper/gradle-wrapper.properties`
* `android/templates/build/root.build.gradle`.

In the `android/` folder you can run `./gradlew wrapper --gradle-version 8.10 --distribution-type all` to update the gradle tool. It will download the version, change the `gradle-wrapper.properties` link, update the gradlew file and the gradle-wrapper.jar.

To update the plugin to a newer version (check https://mvnrepository.com/artifact/com.android.tools.build/gradle?repo=google) you have to change the `build.gradle` and `root.build.gradle` from the links above.

When you change the gradle plugin make sure to look at the `Compatibility` section at https://developer.android.com/studio/releases/gradle-plugin#compatibility-7-1-0 and adjust the `android build tools` section in `android/package.json`. It will also tell you the minimum required version. E.g. `com.android.tools.build:gradle:8.5.x` (plugin) /android/gradle/wrapper/gradle-wrapper.properties to be 8.7 (tool).
If needed make sure the other libraries e.g. the kotlin version in `build.gradle` are working with the current setup.

After you've made the changes and compiled the SDK make sure to run the test suite, build the kitchensink and hyperloop example app. Create a and build a module (java and kotlin) and run those in a test app too.

### Update packaged modules

Some modules like ti.map or ti.facebook are included with the SDK. To update to the latest versions you have to edit the links in `support/module/packaged/modules.json` and run `node build/scons-modules-integrity.js`. This will download the files and update the integrity values.

### Update Android libraries
The `/android/titanium/build.gradle` file contains various Android libraries that are used in the SDK. If you want to update them check the corresponding release pages:
* https://developer.android.com/jetpack/androidx/releases/recyclerview
* https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout
* https://developer.android.com/jetpack/androidx/releases/camera
* https://developer.android.com/jetpack/androidx/releases/transition
* https://developer.android.com/jetpack/androidx/releases/vectordrawable
* https://developer.android.com/jetpack/androidx/releases/viewpager
* https://developer.android.com/jetpack/androidx/releases/cardview
* https://developer.android.com/jetpack/androidx/releases/drawerlayout
* https://developer.android.com/jetpack/androidx/releases/exifinterface
* https://developer.android.com/jetpack/androidx/releases/media

for a new version and change the number in the build.gradle file. Some version numbers are managed inside `/android/templates/build/ti.constants.gradle`. After that build the SDK and run `npm run test` to see if everything is still running. Building Kitchensink, Hyperloop-examples and a custom app is also helpful.

### Documentation

If you want to help updating and improving the documentation you can checkout the repository and edit the files in `/apidoc/`. Those files are shown in the API documentation at https://titaniumsdk.com/api/ and include all methods, properties, examples and so on. After you made changes run `npm run lint:docs` to see if your changes produce a valid documentation. The PR commit title you create should start with `docs: ` and a proper title like: `docs: updated textfield examples`.
All other documentation files (e.g. the guides) are located in the https://github.com/tidev/titanium-docs repository. In case you want to update guides, tutorials or spelling mistakes you clone that repo and follow the README file inside the main folder.

## Contributing

Interested in contributing? There are several ways you can help contribute to this project.

### New Features, Improvements, Bug Fixes, & Documentation

Source code contributions are always welcome! Before we can accept your pull request, you must sign a Contributor License Agreement (CLA). Please visit https://tidev.io/contribute for more information.

### Donations

Please consider supporting this project by making a charitable [donation](https://tidev.io/donate). The money you donate goes to compensate the skilled engineeers and maintainers that keep this project going.

### Code of Conduct

TiDev wants to provide a safe and welcoming community for everyone to participate. Please see our [Code of Conduct](https://tidev.io/code-of-conduct) that applies to all contributors.

## Security

If you find a security related issue, please send an email to [security@tidev.io](mailto:security@tidev.io) instead of publicly creating a ticket.

## Stay Connected

For the latest information, please find us on Twitter: [Titanium SDK](https://twitter.com/titaniumsdk) and [TiDev](https://twitter.com/tidevio).

Join our growing Slack community by visiting https://slack.tidev.io

## Legal

Titanium is a registered trademark of TiDev Inc. All Titanium trademark and patent rights were transferred and assigned to TiDev Inc. on 4/7/2022. Please see the LEGAL information about using our trademarks, privacy policy, terms of usage and other legal information at https://tidev.io/legal.
