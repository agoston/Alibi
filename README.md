![Alibi, Witness every moment](readme_content/banner.webp)

# Alibi

<p float="left" align="center">
    <img src="fastlane/metadata/android/en-US/images/phoneScreenshots/01.webp" width="30%" />
    <img src="fastlane/metadata/android/en-US/images/phoneScreenshots/02.webp" width="30%" />
    <img src="fastlane/metadata/android/en-US/images/phoneScreenshots/03.webp" width="30%" />
    <img src="fastlane/metadata/android/en-US/images/phoneScreenshots/04.webp" width="30%" />
    <img src="fastlane/metadata/android/en-US/images/phoneScreenshots/05.webp" width="30%" />
    <img src="fastlane/metadata/android/en-US/images/phoneScreenshots/06.webp" width="30%" />
</p>

Alibi keeps recording audio/video in the background and saves the last 30 minutes at your request.
Everything is completely configurable. No internet connection required.

# Download

[<img src="readme_content/google-play-badge.png" alt="Get it on Google Play" height="80">](https://play.google.com/store/apps/details?id=app.myzel394.alibi)
[<img src="https://fdroid.gitlab.io/artwork/badge/get-it-on.png" alt="Get it on F-Droid" height="80">](https://f-droid.org/packages/app.myzel394.alibi)
[<img src="readme_content/github-badge.webp" alt="Get it on GitHub" height="80">](https://github.com/Myzel394/Alibi/releases)

# Automation intents

Alibi can be controlled by automation apps such as Tasker by sending broadcast intents.
These intents control audio recording only and do not open the Alibi app UI.

Before using them, open Alibi once and grant the required microphone and notification permissions.
For reliable background starts, also disable battery optimization for Alibi in Android settings.

| Action | Effect |
| --- | --- |
| `app.myzel394.alibi.action.START_AUDIO_RECORDING` | Starts audio recording in the background. If recording is already running, nothing changes. |
| `app.myzel394.alibi.action.STOP_AUDIO_RECORDING` | Saves the current recording using your Alibi settings, then stops recording. If no recording is running, Alibi just stops the background service. |

## Tasker example

Create a task with **Action Category: System -> Send Intent** and use these values:

| Field | Value |
| --- | --- |
| Action | `app.myzel394.alibi.action.START_AUDIO_RECORDING` or `app.myzel394.alibi.action.STOP_AUDIO_RECORDING` |
| Cat | `None` |
| Mime Type | leave empty |
| Data | leave empty |
| Extra | leave empty |
| Package | `app.myzel394.alibi` |
| Class | leave empty |
| Target | `Broadcast Receiver` |

## ADB examples

```sh
adb shell am broadcast -p app.myzel394.alibi -a app.myzel394.alibi.action.START_AUDIO_RECORDING
adb shell am broadcast -p app.myzel394.alibi -a app.myzel394.alibi.action.STOP_AUDIO_RECORDING
```

# Supporting Alibi

You can support Alibi in various ways:

## Contribute to the project

Add a new feature or fix bugs.

## Add translations

[Translate Alibi into your language using Crowdin](https://crowdin.com/project/alibi), so that other
people can use it more easily.

## Donate

It might sound crazy, but if you would just donate $ 1, it would totally mean the world to me, since
it's a really small amount and if everyone did that, I could focus on Alibi and my other open
source projects. :)

You can donate via [GitHub Sponsors](https://github.com/sponsors/Myzel394) or via [crypto currencies](https://github.com/Myzel394/contact-me?tab=readme-ov-file#donations).
