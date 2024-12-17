# Matrix Train Depature Board Display

<img src="https://andersonquigley.com/content/uploads/2022/11/ljmu_logo.png" alt="LJMU Banner Logo" width="100%" />

## Project Objective

The aim of this project is to develop a custom Train Depature Board as seen at train stations displaying the latest train leaving a certain station.

## Hardware

The matrix displays are being driven by **Interstate 75 W** boards controlled by a **Raspberry Pico 2**. We are currently using 4 boards to display one platforms information. We are also running the Java server on a **Kubernetes Cluster**.


## Features

### Implemented Features

#### API Request

-   Able to create a GET request through the Rail Data Marketplace for any chosen Train Station Code which gives us information based on all the services currently avaliable at that station. Improvements to this by adding a post request to allow the change of Station on the fly.

#### Matrix Output Display

-   Once the request has been made, the information is used to create a .PNG image for the first service avaliable at the chosen station and sends the image to the pico for display.

#### Server Hosted

- The Java server which creates the API request and draws the image is now being ran on a Kubernetes Cluster.

### Features Not Yet Implemented

-   **Server hosted**
- **Multiple Platforms Displayed**
- **Better handling of scaling sizing**
- **Optimised code**
- **Add post request for changing stations**

### Output Display

V.1


![First Display](images/WhatsApp%20Video%202024-12-16%20at%2013.40.05.mp4)