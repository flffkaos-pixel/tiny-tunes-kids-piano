# Tiny Tunes: Kids Piano (English release)

Kids piano music game for ages 1-6, modeled on ABC Piano
(`com.piano.toys.kids.learnmusic`). English UI, 16 public-domain songs.

## Project layout
- `www/index.html` — the app itself (single file, offline, no dependencies).
  Web Audio synthesis, no audio files. Keyboard C4..D5.
  - Play: Piano / Organ / Xylophone / Trumpet
  - Songs (23, all public-domain melodies, verified note-by-note):
    Twinkle, Baa Baa Black Sheep, ABC Song, Happy Birthday,
    Good Morning to You, Old MacDonald, London Bridge, Are You Sleeping?,
    Jingle Bells, Ode to Joy, Yankee Doodle, Oh! Susanna,
    Mary Had a Little Lamb, Merrily We Roll Along,
    Row Row Row Your Boat, Hot Cross Buns, Amazing Grace,
    Three Blind Mice, Auld Lang Syne, Itsy Bitsy Spider,
    Deck the Halls, Silent Night (Easy), Up on the Housetop
  - Animals: 12 animals with synthesized sounds + English TTS.
- `android-app/` — Gradle project (`com.tinytunes.kidspiano`, v1.0.0).
- `android/` — old WebView snippet (superseded by `android-app/`).
- `store-icon-512.png` — Play Store icon (512x512).
- `privacy-policy.html` — host this URL and link it in Play Console.
- `android-app/release.keystore` — upload key (alias `tinytunes`,
  passwords in `android-app/gradle.properties`). BACK IT UP.
  Losing it means a new package name for updates.

## Copyright notes
- Removed vs. the original app's list: Baby Shark (Pinkfong),
  School Bell "학교종" (Kim Mary, 1948 — protected until 2075),
  Wheels on the Bus (1937/39 — gray area), Finger Family (modern).
- Deliberately NOT added: You Are My Sunshine (1939, until 2034),
  I'm a Little Teapot (1939), Hokey Pokey (1940s),
  If You're Happy and You Know It (uncertain 1930s credit).
- Skipped as unverifiable (no reliable letter-note source):
  This Old Man, Bingo, Hickory Dickory Dock, Rain Rain Go Away,
  Skip to My Lou, We Wish You a Merry Christmas (source mismatch).
- Kept: everything published pre-1930 / PD-confirmed (incl. Happy
  Birthday, PD since the 2016 US ruling). Melodies are synthesized
  on-device; no lyrics are shown.

## Build (this PC is already set up)
Tools live outside the project (no admin needed):
`%LOCALAPPDATA%\Java\jdk-17.0.20.1+1`,
`%LOCALAPPDATA%\Android\Sdk`, `%LOCALAPPDATA%\Gradle\gradle-8.7`.
```powershell
$env:JAVA_HOME = "$env:LOCALAPPDATA\Java\jdk-17.0.20.1+1"
$env:ANDROID_HOME = "$env:LOCALAPPDATA\Android\Sdk"
& "$env:LOCALAPPDATA\Gradle\gradle-8.7\bin\gradle.bat" -p android-app assembleDebug   # test APK
& "$env:LOCALAPPDATA\Gradle\gradle-8.7\bin\gradle.bat" -p android-app bundleRelease   # store AAB
```
Outputs: `android-app/app/build/outputs/apk/debug/app-debug.apk`,
`android-app/app/build/outputs/bundle/release/app-release.aab` (verified signed).

## Play Console release checklist
1. Create app > `app-release.aab` upload (new apps must use AAB).
2. Target audience: 5 and under + Designed for Families path
   (no ads, no IAP, no data collection — matches Families Policy).
3. Data safety form: declare Device/Ad IDs collected by the Google
   AdMob SDK (purpose: advertising, non-personalized).
4. Privacy policy URL <- host `privacy-policy.html`.
5. Store listing: use `store-icon-512.png`, add feature graphic +
   2+ phone screenshots (take from `www/index.html` in a browser).
6. Content rating questionnaire (Everyone) + news/COVID declarations.
7. Closed testing track first, then production.

## Monetization (AdMob, kids-compliant)
- Code ships with Google TEST IDs: App ID in
  `android-app/app/src/main/AndroidManifest.xml`, banner unit in
  `MainActivity.java` (`BANNER_UNIT_ID`).
- Before release: create an AdMob account + app, replace both IDs,
  then rebuild. Never tap your own ads (account ban risk).
- Families checklist: target audience 5 and under, Designed for
  Families, G-rated non-personalized ads (already enforced in code),
  updated privacy policy URL + Data safety (Ad IDs) declaration.
- Honest note: kids banner eCPM is low; expect pocket money at
  first, not salary. No interstitials (policy risk + bad UX for toddlers).
