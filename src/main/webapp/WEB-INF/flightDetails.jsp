<%--
  Created by IntelliJ IDEA.
  User: Mhkif
  Date: 29/10/2023
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  language="java" %>
<html>
<head>
    <link href="https://unpkg.com/tailwindcss@2.0.1/dist/tailwind.min.css" rel="stylesheet">
    <title><c:out value = "${flight.departureAirport.city}"/>  -  To  -  <c:out value = "${flight.arrivalAirport.city}"/></title>

</head>
<body>

<nav class="bg-white px-2 md:px-4 py-1">
    <div class="flex flex-wrap items-center justify-between max-w-screen-xl mx-auto">
        <div class="flex items-center" aria-label="Home" role="img" style="font-family: 'Prosto One', cursive;">
            <img class="cursor-pointer h-8 sm:w-auto" src="https://img.icons8.com/stencil/32/airport.png"  alt="logo" />
            <p class="ml-2  text-lg lg:text-xl font-bold text-dark dark:text-white">AirAfrika</p>

        </div>


        <div class="flex gap-4 items-center md:order-2">

            <button data-collapse-toggle="mega-menu" type="button" class="inline-flex items-center p-2 ml-1 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600" aria-controls="mega-menu" aria-expanded="false">
                <span class="sr-only">Open main menu</span>
                <svg aria-hidden="true" class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd"></path>
                </svg>
            </button>
        </div>
        <div id="mega-menu" class="items-center justify-between hidden w-full text-sm md:flex md:w-auto md:order-1">
            <ul class="flex flex-col items-center mt-4 font-medium md:flex-row md:space-x-8 md:mt-0" style="font-family: 'Prosto One', cursive;">

                <li class="text-dark text-lg hover:text-red-500  cursor-pointer py-2">
                    <a href="/" class="inline-block rounded-md px-3 py-1.5 text-sm font-semibold leading-6 text-gray-900 shadow-sm ring-1 ring-red-500 ring-inset  hover:ring-red-600 hover:ring-0 hover:bg-red-500 hover:text-white" type="button">Flights</a>
                </li>

                <li>
                    <a href="/my-reservations" class="inline-block rounded-lg px-3 py-1.5 text-sm font-semibold leading-6 text-gray-900 shadow-sm ring-1 ring-red-500 ring-inset  hover:ring-red-600 hover:ring-0 hover:bg-red-500 hover:text-white" type="button">My Reservations</a>
                </li>

            </ul>
        </div>
    </div>
</nav>

<section class=" w-full rounded-lg group md:flex  bg-white  hover:rounded-xl" style="font-family: 'Poppins', sans-serif;">
    <div class="flex w-full flex-col justify-between items-start p-4">


        <span class="text-sm text-gray-600"> <fmt:formatDate type = "date" value = "${flight.departAt}" /> </span>

        <div class="flex w-full flex-col justify-between md:flex-row">
            <div class="p-4 w-auto flex flex-col justify-between md:p-6 gap-2">
                <div class="flex flex-col  baseline sm:flex-row">
                    <h4 class="text-md font-bold text-gray-900 md:text-lg">

                        <fmt:formatDate type = "time" value = "${flight.departAt}" pattern = "HH:mm" /> - <fmt:formatDate type = "time" value = "${flight.arrivedAt}" pattern = "HH:mm"  />
                    </h4>
                </div>
                <div class="flex flex-col  baseline sm:flex-row">
                    <h4 class="text-sm font-normal text-gray-900 md:text-md" style="font-family: 'Prosto One', cursive;">
                        <c:out value = "${flight.departureAirport.city}"/>  <span class="text-black font-bold"> -  To  - </span>  <c:out value = "${flight.arrivalAirport.city}"/>
                    </h4>
                </div>
            </div>
            <div class="flex flex-col  md:p-8 baseline sm:flex-row">
                <h4 class="text-sm font-bold text-gray-900 md:text-md">
                    <c:out value = "${flight.flightType}"/>
                </h4>
            </div>
            <div class="flex flex-col  md:p-8  baseline sm:flex-row">
                <h4 class="text-sm font-bold text-gray-900 md:text-md">
                    1h:30
                </h4>
            </div>
        </div>
    </div>

    <div class=" p-4 flex items-center flex-col space-y-2 justify-center md:space-y-4 md:p-4 w-1/3">
        <h3 class="text-xl font-semibold text-cyan-900 sm:text-2xl" style="font-family: 'Prosto One', cursive;">
            <c:out value = "${flight.amount}"/>
            <span class="text-sm"> MAD</span>
        </h3>
        <a id="i" type="button" href="/booking?flight_id=${flight.id}" class="inline-flex w-full justify-center px-4 py-2.5 bg-red-600 text-white font-medium text-xs leading-normal uppercase rounded shadow-md hover:bg-red-800  cursor-pointer hover:shadow-lg focus:bg-orange-600 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-orange-600 active:shadow-lg transition duration-150 ease-in-out">
            Continuer
            <svg aria-hidden="true" class="w-4 h-4 ml-2 -mr-1" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
            </svg>
        </a>

    </div>

</section>

</body>
</html>
