# Matrix Train Depature Board Display

<img src="https://andersonquigley.com/content/uploads/2022/11/ljmu_logo.png" alt="LJMU Banner Logo" width="100%" />

## Project Objective

The aim of this project is to develop a custom Train Depature Board as seen at train stations displaying the latest train leaving a certain station.

## Hardware

The matrix displays are being driven by **Interstate 75 W** boards controlled by a **Raspberry Pico 2**. We are currently using 4 boards to display one platforms information.


## Features

### Implemented Features

#### Basic Loop & Data Logging

-   Reads sensors as fast as possible.
-   Outputs a debug string to the Serial output every 5 seconds.
-   The debug string includes the latest values for all sensor readings and system statuses, detailing whether sensors are either above, within, or below the set range.

#### User Output Display

-   Integrated output display screen that reports current sensor values and statuses.
-   Displays minimum and maximum temperature/humidity over the last 24 hours.

#### Mode Selection

-   Through the use of a rotary encoder, the user is now able to change the operating mode of the system.
-   Display has been updated to show value states using colour indicators , with values being printed in red if they are out of the defined range of the current operating mode, and green if they are within.

#### Custom User Mode

-   User is now able to create their custom operating mode and select it in the mode list.
-   Double buffering has now been added for a smoother display, eliminating flickering when the screen updates.

### Features Not Yet Implemented

-   **Server hosted**
- **Multiple Platforms Displayed*

### Output Displays

V.1

![PXL_20240327_142814390](img/ColdFrame-v1.jpg)

V.2
![PXL_20240530_111212887](img/ColdFrame-v2.jpg)