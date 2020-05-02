# CodeExample
This is a example code to demostrate how to use Cookie. It requires Maven to build, no Server setup required, no Frontend source (HTML, JS...) required

## Setup
1. Install [IntelleJ](https://www.jetbrains.com/idea/)

2. Install [Maven](http://maven.apache.org/)

3. Open the project as Maven Project in IntelliJ

## Useage

1. Run `CookieServer.Main` to start the server
2. Vist localhost:8090/display to see your visit history, if you have been visited the web , you are allow to go to localhost:8090/clear to clear your visit history, it implemented in `CookieVisitsServlet`
3. Direct visit localhost:8090/clear will not allow clear history, it implemented in `CookieConfigServlet`




