# Explore LLMs - Android Mobile Application

Explore LLMs is an educational Android application designed to introduce users to popular Large Language Models (LLMs) such as ChatGPT, Gemini, Claude, TigerLLM, and more. Built with Java using Android Studio, this app features multimedia content, multilingual support, interactive search, user ratings, and smooth navigation to provide an engaging learning experience.

---

## Demo Screenshots

<div>
  <img src="https://github.com/user-attachments/assets/3de3ae7e-86fa-420e-a041-ccad35ba38ae" width="150"/>
  <img src="https://github.com/user-attachments/assets/44a89e6a-e063-4ba5-a4cf-19c9bfad0077" width="150"/>
  <img src="https://github.com/user-attachments/assets/83a0f02f-b7f2-40da-8974-f560fe63072d" width="150"/>
  <img src="https://github.com/user-attachments/assets/66c8f42c-a660-4119-a907-cf2fc4476af4" width="150"/>
</div>





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

