<%--
  Created by IntelliJ IDEA.
  User: Mhkif
  Date: 29/10/2023
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <link href="https://unpkg.com/tailwindcss@2.0.1/dist/tailwind.min.css" rel="stylesheet">
  <title>My Reservations </title>
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
          <a href="/my-reservations" class="inline-block rounded-lg px-3 py-1.5 text-sm font-semibold leading-6 shadow-sm ring-1 ring-red-500 ring-inset  hover:ring-red-600 hover:ring-0 bg-red-500 text-white" type="button">My Reservations</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<c:set var = "reservationsCounts" value = "${reservationsCounts}"/>
<c:choose>
  <c:when test="${reservationsCounts > 0 }">

    <main class="container mx-auto px-12">

      <div class="flex items-center justify-between py-7 px-2">

        <div>
          <h1 class="text-2xl font-semibold leading-relaxed text-gray-800">My Reservations</h1>
        </div>

      </div>
      <div class=" overflow-x-auto">
        <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400" style="font-family: 'Poppins', sans-serif;">

          <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
          <tr>

            <th scope="col" class="px-6 py-3">
              Ref
            </th>
            <th scope="col" class="px-6 py-3">
              Flight
            </th>
            <th scope="col" class="px-6 py-3">
              Passenger
            </th>

            <th scope="col" class="px-6 py-3">
              Reservation Date
            </th>

            <th scope="col" class="px-6 py-3">
              Price (MAD)
            </th>


            <th scope="col" class="px-6 py-3">
              Action
            </th>
          </tr>
          </thead>
          <tbody>
          <c:forEach  var = "reservation" items= "${reservations}"  >
          <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">

            <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
              <c:out value = "${reservation.ref}"/>
            </th>

            <td class="px-6 py-4">
              <c:out value = "${reservation.flight.id}"/>
            </td>

            <td class="px-6 py-4">
              <c:out value = "${reservation.passenger.firstname}"/>  <c:out value = "${reservation.passenger.lastname}"/>
            </td>
            <td class="px-6 py-4">
              <c:out value = "${reservation.reservedAt}"/>
            </td>
            <td class="px-6 py-4">
              <c:out value = "${reservation.total}"/>
            </td>

            <td class="flex items-center px-6 py-4 space-x-3">
            <form action="/my-reservations" method="post">
              <input type="hidden" name="reservation_ref" value="${reservation.ref}">
              <input type="submit" value="Cancel" class="font-medium text-red-600 dark:text-red-500 hover:underline">
            </form>
            </td>
          </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>

    </main>

  </c:when>
  <c:otherwise>


    <div id="book-modal" tabindex="-1" aria-hidden="true" class="fixed top-0 left-0 right-0 z-50 hidden w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-modal md:h-full">
      <div class="relative w-full h-full max-w-md md:h-auto">
        <!-- Modal content -->
        <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
          <button type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white" data-modal-hide="book-modal">
            <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path>
            </svg>
            <span class="sr-only">Close modal</span>
          </button>
          <div class="px-4 py-8 lg:px-6 flex flex-col gap-8">
            <div class="flex  items-center justify-center" aria-label="Home" role="img" style="font-family: 'Prosto One', cursive;">
              <p class="ml-2  text-base font-bold text-dark dark:text-white">Personal Information</p>
            </div>
            <form class="space-y-4" action="/my-reservations/find" >

              <div class="w-full flex gap-4">
                <div class="w-full">
                  <label for="firstName" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">First Name</label>
                  <input type="text" name="firstName" id="firstName" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="First Name" />
                </div>
                <div class="w-full">
                  <label for="lastName" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Last Name</label>
                  <input type="text" name="lastName" id="lastName" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Last Name" />
                </div>
              </div>

              <div class="w-full flex gap-4">
                <div class="w-full">
                  <label for="email" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Email</label>
                  <input type="email" name="email" id="email" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Email" />
                </div>
                <div class="w-full">
                  <label for="reservation_ref" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Reservation Ref</label>
                  <input type="text" name="reservation_ref" id="reservation_ref" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Reservation Ref" />
                </div>
              </div>

              <button type="submit" class="w-full text-white bg-red-600 hover:bg-red-700 focus:ring-4 focus:outline-none focus:ring-orange-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Create</button>

            </form>
          </div>
        </div>
      </div>
    </div>

    <main class="flex items-center justify-center px-12 h-96 ">

      <div class="flex flex-col  gap-8 py-7 px-2">

        <h1 class="text-2xl font-semibold leading-relaxed text-gray-800">You Have No Reservations Yet .</h1>
        <div class="flex space-x-2 justify-center ">
          <button class="inline-flex gap-x-2 items-center py-2.5 px-6 text-white bg-gray-900 rounded-md hover:bg-orange-600 focus:outline-none focus:ring-2 focus:ring-orange-500 focus:ring-offset-1" data-modal-target="book-modal" data-modal-toggle="book-modal" type="button">
            <span class="text-sm font-semibold tracking-wide">Find Reservation</span>
          </button>
         <!-- <a href="/flights" class="sm:w-auto inline-flex justify-center px-4 py-2 bg-red-500 text-white font-medium text-sm leading-normal uppercase rounded shadow-md hover:bg-red-700 hover:shadow-lg focus:bg-red-600 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-red-600 active:shadow-lg transition duration-150 ease-in-out">Find Reservation</a> -->
        </div>
      </div>


    </main>
  </c:otherwise>
</c:choose>


<script src="https://unpkg.com/flowbite@1.6.0/dist/flowbite.min.js"></script>

</body>
</html>
