# Explore LLMs - Android Mobile Application

Explore LLMs is an educational Android application designed to introduce users to popular Large Language Models (LLMs) such as ChatGPT, Gemini, Claude, TigerLLM, and more. Built with Java using Android Studio, this app features multimedia content, multilingual support, interactive search, user ratings, and smooth navigation to provide an engaging learning experience.

---

## Demo Screenshots
![_cgi-bin_mmwebwx-bin_webwxgetmsgimg__ MsgID=3792475713129078465 skey=@crypt_2f3fff13_ab1e890f2c7e051f3603f4c330dc0cae mmweb_appid=wx_webfilehelper](https://github.com/user-attachments/assets/701e8e87-f138-4b2e-b0a1-cce02b1b241a)![_cgi-bin_mmwebwx-bin_webwxgetmsgimg__ MsgID=5372941363292951177 skey=@crypt_2f3fff13_ab1e890f2c7e051f3603f4c330dc0cae mmweb_appid=wx_webfilehelper](https://github.com/user-attachments/assets/098c508b-8807-4f84-9a06-0cbfb3ad3841)![Uploading _cgi-bin_mmwebwx-bin_webwxgetmsgimg__&MsgID=4478462371698021037&skey=@crypt_2f3fff13_ab1e890f2c7e051f3603f4c330dc0cae&mmweb_appid=wx_webfilehelper.jpg…]()![_cgi-bin_mmwebwx-bin_webwxgetmsgimg__ MsgID=2127456199610840321 skey=@crypt_2f3fff13_ab1e890f2c7e051f3603f4c330dc0cae mmweb_appid=wx_webfilehelper](https://github.com/user-attachments/assets/8c23b126-5b14-4669-99b4-46047852d0c5)




---

## Features

- **Landing Screen** with animated background and music  
- **Bottom Navigation** for easy access to Home, About, and Settings  
- **List/Grid View** to browse LLMs with logos, descriptions, and release dates  
- **Search Functionality** with real-time filtering of LLM names  
- **Detail View** including banners, ratings, history, introduction, and videos  
- **User Rating System** for each LLM  
- **Multilingual Support** with English and Chinese translations  
- **Dynamic Layout Switching** between grid and list  

---

## Project Structure
java/dev/rabiulhassan/explore_llms/
├── adapter/LLMAdapter.java # RecyclerView adapter with filtering
├── model/LLM.java # Data model class
├── DetailActivity.java # LLM details screen
├── LandingActivity.java # Welcome screen with animation
├── ListActivity.java # LLM list/grid display
├── MainActivity.java # Main app activity with navigation

res/
├── layout/ # XML layouts for activities and list items
├── drawable/ # Images, icons, and banners
├── raw/ # Media files (video, audio)
├── values/ # Strings, colors, and themes (English)
├── values-zh/ # Strings for Chinese localization
├── menu/ # Navigation and toolbar menus


---

## Technologies Used

- Java  
- Android Studio  
- RecyclerView & Adapter Pattern  
- Material Components (BottomNavigationView, Toolbar)  
- VideoView for media playback  
- Localization for multilingual support  

---

## Installation

1. Clone the repository:  
   ```bash
   git clone https://github.com/rabiulhassandev/java-android-mobile-app-explore-LLM.git
2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator (API level 21+).

## Usage:
- Launch the app to see the animated landing screen.
- Use the bottom navigation to switch between Home, About, and Settings.
- Browse the list or grid of LLM cards.
- Use the search bar to filter models by name instantly.
- Tap "Read More" on any card to see detailed information and watch embedded videos.
- Rate each LLM using the interactive rating bar.
- Change device language to see app localization (English / Chinese).

## Future Improvements:
- Backend integration for dynamic data and persistent user ratings

- Additional language support
- User authentication and profile management
- More interactive multimedia content and demos
- Accessibility improvements and animations


Contact:
Rabiul Hassan
Hangzhou Dianzi University
Email: rabiulhassandev@gmail.com

Thank you for exploring LLMs with this app! Contributions and feedback are welcome.

