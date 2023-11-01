<%--
  Created by IntelliJ IDEA.
  User: Mhkif
  Date: 18/10/2023
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link href="https://unpkg.com/tailwindcss@2.0.1/dist/tailwind.min.css" rel="stylesheet">

    <title>Reservations</title>
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

<form class=" flex flex-col p-8 justify-between items-center gap-8" action="/booking" method="post">
    <input type="hidden" name="flight_id" value="${flight.getId()}">
    <div class="flex flex-row items-center gap-4">
            <div class="flex flex-col">
                <h2 class="text-2xl font-bold text-gray-900 " style="font-family: 'Prosto One', sans-serif;">
                    <c:out value = "${flight.departureAirport.city}"/>
                </h2>

                <h4 class="text-md font-normal text-gray-600 " style="font-family: 'Prosto One', sans-serif;">
                    <c:out value = "${flight.departureAirport.name}"/>
                </h4>
            </div>
            <span class="text-black font-bold"> - - - </span>
            <img width="28" height="28" src="https://img.icons8.com/pastel-glyph/64/1-stop-flight--v4.png" alt="1-stop-flight--v4"/>
            <span class="text-black font-bold"> - - - </span>

            <div class="flex flex-col ">
                <h2 class="text-2xl font-bold text-gray-900 " style="font-family: 'Prosto One', sans-serif;">
                    <c:out value = "${flight.arrivalAirport.city}"/>
                </h2>
                <h4 class="text-sm font-normal text-gray-600 " style="font-family: 'Prosto One', sans-serif;">
                    <c:out value = "${flight.arrivalAirport.name}"/>
                </h4>
            </div>

        </div>

    <div class=" px-12 flex flex-col items-center justify-between w-full  md:flex-row gap-6 bg-white  " style="font-family: 'Poppins', sans-serif;">
      <div class="p-4 w-full md:w-1/3 flex flex-col gap-4">
                <h4 class="text-md font-medium text-gray-700 md:text-lg">
                    <fmt:formatDate type = "date" value = "${flight.departAt}" />
                </h4>
                <h4 class="text-md font-bold text-gray-900 md:text-lg">
                    <fmt:formatDate type = "time" value = "${flight.departAt}" pattern = "HH:mm" />  <span class="text-sm font-normal text-gray-600"> <c:out value = "${flight.departureAirport.name}"/> </span>
                </h4>
                <h3 class="text-md font-bold text-gray-800">    <c:out value = "${flight.flightType}"/> <span class="text-sm font-medium text-gray-700"> flight</span> </h3>
                <h4 class="text-md font-bold text-gray-900 md:text-lg">
                    <fmt:formatDate type = "time" value = "${flight.arrivedAt}" pattern = "HH:mm"  />  <span class="text-sm font-normal text-gray-600"> <c:out value = "${flight.arrivalAirport.name}"/> </span>
                </h4>
                <h4 class="text-md font-bold text-gray-900 md:text-lg">
                    <span class="text-sm font-normal text-gray-600"> Duration  </span> <c:out value = "${durationHours}"/>h </span> <c:out value = "${durationMins}"/> min
                </h4>
            </div>
      <div class="p-4 w-full md:w-1/3  flex flex-col gap-3">
          <div class="w-full flex flex-col gap-2">
              <label for="flightClass" class="text-sm text-gray-900 font-medium ">Flight's Class</label>
              <select name="flightClass" id="flightClass" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" aria-label="Default select example" required>
                  <option value="" disabled selected>Flight's Class </option>
                  <c:forEach  var = "flightClass" items= "${flightClasses}"  >
                      <option value="<c:out value = "${flightClass.name()}"/>"><c:out value = "${flightClass.name()}"/></option>
                  </c:forEach>
              </select>
          </div>
          <div class="w-full flex flex-col gap-2">
                  <label for="extras" class="text-sm text-gray-900 font-medium">Extras</label>
                  <select name="extras" id="extras" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" aria-label="Default select example" required>
                      <option value="" disabled selected>Extras</option>
                      <c:forEach  var = "extras" items= "${extras}"  >
                          <option value="<c:out value = "${extras.name()}"/>"><c:out value = "${extras.name()}"/></option>
                      </c:forEach>
                  </select>
              </div>
          <div class="w-full flex flex-col gap-2">
                  <label for="extraCost" class="text-sm text-gray-900 font-medium">Cost</label>
                  <input type="number" name="extraCost" id="extraCost" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"  />
              </div>
      </div>
      <div class="p-4 w-full md:w-1/3 flex flex-col gap-3">
         <div class="w-full flex flex-col gap-2">
                  <label for="baggageType" class="text-sm text-gray-900 font-medium">Baggage Type</label>
                  <select name="baggageType" id="baggageType" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" aria-label="Default select example" required>
                      <option value="" disabled selected>Baggage Type </option>
                      <c:forEach  var = "baggageType" items= "${baggageTypes}"  >
                          <option value="<c:out value = "${baggageType.name()}"/>"><c:out value = "${baggageType.name()}"/></option>
                      </c:forEach>
                  </select>
              </div>
         <div class="w-full flex flex-col gap-2">
                  <label for="weight" class="text-sm text-gray-900 font-medium">Weight</label>
                  <input type="number" name="weight" id="weight" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"  />
              </div>
         <div class="w-full flex flex-col gap-2">
                <label for="paymentMode" class="text-sm text-gray-900 font-medium">Payment Mode</label>
                <select name="paymentMode" id="paymentMode" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" aria-label="Default select example" required>
                    <option value="" disabled selected>Payment Mode </option>
                    <c:forEach  var = "paymentMode" items= "${paymentModes}"  >
                        <option value="<c:out value = "${paymentMode.name()}"/>"><c:out value = "${paymentMode.name()}"/></option>
                    </c:forEach>
                </select>
            </div>
      </div>
    </div>

    <div class="w-full flex flex-col py-6 px-12 gap-6">
        <div class="w-full flex flex-col gap-6 p-4">
            <div>
                <h3 class ="text-md font-bold text-gray-900 md:text-lg">
                    Personal Information
                </h3>
                <div class="py-4 w-full flex flex-col md:flex-row gap-8">
                    <div class="w-full flex flex-col gap-2">
                        <label for="civility" class="text-sm text-gray-900 font-medium ">Civility</label>
                        <select name="civility" id="civility" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" aria-label="Default select example" required>
                            <option value="" disabled selected>Civility</option>
                            <option value="M."> M. </option>
                            <option value="Mme"> Mme </option>
                            <option value="Mlle"> Mlle </option>
                        </select>
                    </div>
                    <div class="w-full flex flex-col gap-2">
                        <label for="lastName" class=" text-sm font-medium text-gray-900 dark:text-white">Last name on your passport: *</label>
                        <input type="text" name="lastName" id="lastName" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Last Name" required>
                    </div>
                    <div class="w-full flex flex-col gap-2">
                        <label for="firstName" class="text-sm font-medium text-gray-900 dark:text-white">First name on your passport: *</label>
                        <input type="text" name="firstName" id="firstName" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Last Name" required>
                    </div>
                </div>
            </div>
            <div>
                <h3 class ="text-md font-bold text-gray-900 md:text-lg">
                    Contact Information
                </h3>
                <div class="py-4 w-full flex flex-col md:flex-row md:w-2/3 gap-8">
                    <div class="w-full flex flex-col gap-2">
                        <label for="email" class="text-sm font-medium text-gray-900 dark:text-white">Enter your e-mail address: *</label>
                        <input type="email" name="email" id="email" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Email" required>
                    </div>
                    <div class="w-full flex flex-col gap-2">
                        <label for="phone" class="text-sm font-medium text-gray-900 dark:text-white">Cell phone : *</label>
                        <input type="number" name="phone" id="phone" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Phone number" required>
                    </div>
                </div>
            </div>
            <div class="w-full flex items-center flex-row justify-end ">
                <input type="submit" value="Confirm" class="inline-flex  justify-center px-6 py-3 bg-red-600 text-white font-medium text-xs leading-normal uppercase rounded shadow-md hover:bg-red-800  cursor-pointer hover:shadow-lg focus:bg-orange-600 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-orange-600 active:shadow-lg transition duration-150 ease-in-out">


            </div>

        </div>
     </div>

</form>


</body>
</html>
