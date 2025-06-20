Dessert Clicker App
===================

A simple Android game built with Jetpack Compose and MVVM architecture, designed for learning Android lifecycle, state management, and UI composition.

---

Table of Contents
-----------------
- [Introduction](#introduction)
- [Architecture Overview](#architecture-overview)
- [Main Components](#main-components)
- [State Management](#state-management)
- [UI Flow](#ui-flow)
- [How to Run](#how-to-run)
- [Pre-requisites](#pre-requisites)
- [Learnings](#learnings)

---

Introduction
------------

Dessert Clicker is a game about making desserts.  
Press the button, make a dessert, and earn revenue.  
This app demonstrates:
- Android lifecycle logging
- State management with ViewModel and StateFlow
- UI composition with Jetpack Compose

---

Architecture Overview
---------------------

The app follows the MVVM (Model-View-ViewModel) pattern:

- **Model:** Data classes representing desserts.
- **ViewModel:** Holds UI state and business logic.
- **View (Compose UI):** Renders UI based on state.

---

Main Components
---------------

- **Dessert (model/Dessert.kt):**  
  Data class with `imageId`, `price`, and `startProductionAmount`.

- **Datasource (data/Datasource.kt):**  
  Provides a static list of available desserts.

- **DessertUiState (viewmodel/DessertUiState.kt):**  
  Data class holding current revenue, desserts sold, current dessert price, and image.

- **DessertViewModel (viewmodel/DessertViewModel.kt):**  
  - Holds `DessertUiState` in a `MutableStateFlow`.
  - Handles dessert click logic and determines which dessert to show.

- **MainActivity (MainActivity.kt):**  
  - Sets up Compose content and logs lifecycle events.
  - Hosts the main UI and connects to the ViewModel.

---

State Management
----------------

- **StateFlow:**  
  The ViewModel exposes a `StateFlow<DessertUiState>` for the UI to observe.
- **Immutability:**  
  UI state is managed as an immutable data class, updated via `.copy()`.

---

UI Flow
-------

1. **App Bar:**  
   Displays app name and a share button.
2. **Dessert Image:**  
   Clicking the image increases desserts sold and revenue.
3. **Transaction Info:**  
   Shows total revenue and desserts sold.

---

How to Run
----------

1. Open the project in Android Studio.
2. Build and run the app on an emulator or device.

---

Pre-requisites
--------------

You need to know:
- How to open, build, and run apps with Android Studio.
- What an activity is, and how to create one in your app.
- What the activity's `onCreate()` method does, and the kind of operations performed in that method.

---

Learnings
---------

- **ViewModel Initialization:**  
  The `init` block sets up initial state using the first dessert from the datasource.
- **State Updates:**  
  Clicking the dessert updates the state via `StateFlow` and triggers UI recomposition.
- **Lifecycle Logging:**  
  MainActivity logs all major lifecycle events for learning purposes.

---
