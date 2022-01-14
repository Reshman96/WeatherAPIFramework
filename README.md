#WeatherAPIFramework

WeatherAPIFramework is a framework which is made to provide Weather API testers with readily made methods to check 
validity of data being received from the OpenWeatherMap.org website.


## Table of contents
* [Installation](#Installation)
* [Use](#Use)
* [Areas of potential extension](#Areas-of-potential-extension)
* [Contributing](#Contributing)
* [Authors and acknowledgment](#Authors-and-acknowledgment)


## Installation

In order to install WeatherAPIFramework, download the code from GitHub, and have Java installed on your computer.

## Use

In order to use the framework, the user must create a config.properties file at src/test/resources and have two variables. 
One variable called "APIKEY" with the API key provided by OpenWeatherMap.org once you have signed up with the website.
Another variable called "BASEURL" which is assigned the following String: "https://api.openweathermap.org/data/2.5/weather".

You can then write test cases within the FrameworkTests class if you wish to do so.

If you wish to try the tests on a JSON file, you can place the file in the resources folder and then make use of the 
Injector class method called "InjectFileDTO", passing the Relative Path to the file as the input parameter.

## Areas of potential extension

Currently, the project relies on the API provided by OpenWeatherMap.org however the project could be extended to take
in response from other APIs from different weather websites too.

## Contributing

Project not currently open for extension.

## Authors and acknowledgment

Authors: Alexander Jarrett, George Gregory, Reshman Siva.