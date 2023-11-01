<%--
  Created by IntelliJ IDEA.
  User: Mhkif
  Date: 25/10/2023
  Time: 01:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <link href="https://unpkg.com/tailwindcss@2.0.1/dist/tailwind.min.css" rel="stylesheet">
  <title>Flight Panel</title>
</head>
<body>
<div class="text-sm font-medium text-center text-gray-500 border-b border-gray-200 ">
  <ul class="flex justify-center  flex-wrap -mb-px">
    <li class="mr-2">
      <a href="/flightPanel" class="inline-block text-orange-600  p-4 border-b-2 border-orange-600   rounded-t-lg hover:text-gray-600 hover:border-gray-300 ">Flights</a>
    </li>
    <li class="mr-2">
      <a href="/reservationPanel" class="inline-block p-4  border-b-2 border-transparent rounded-t-lg " >Reservations</a>
    </li>



  </ul>
</div>

<div class="w-full min-h-screen font-sans text-gray-900 bg-gray-50 flex overflow-hidden ">
  <!-- Flight Modal -->

  <div id="flight-modal" tabindex="-1" aria-hidden="true" class="fixed top-0 left-0 right-0 z-50 hidden w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-modal md:h-full">
    <div class="relative w-full h-full max-w-md md:h-auto">
      <!-- Modal content -->
      <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
        <button type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white" data-modal-hide="flight-modal">
          <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path>
          </svg>
          <span class="sr-only">Close modal</span>
        </button>
        <div class="px-4 py-8 lg:px-6 flex flex-col gap-8">
          <div class="flex  items-center justify-center" aria-label="Home" role="img" style="font-family: 'Prosto One', cursive;">
            <p class="ml-2  text-base font-bold text-dark dark:text-white">Create New Flight</p>
          </div>
          <form class="space-y-4" action="/flightPanel" method="POST">
            <div class="w-full">
              <label for="airPlane" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">AirPlane</label>
              <select name="airPlane" id="airPlane" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" aria-label="Default select example" required>
                <option value="" disabled selected>Flight's Airplane </option>
                <c:forEach  var = "airPlane" items= "${airPlanes}"  >
                  <option value="<c:out value = "${airPlane.id}"/>"><c:out value = "${airPlane.name}"/></option>
                </c:forEach>
              </select>
            </div>

            <div class="w-full flex gap-4">
              <div class="w-full">
                <label for="departureAirport" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Departure</label>
                <select name="departureAirport" id="departureAirport" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" aria-label="Default select example" required>
                  <option value="" disabled selected>Flight's Departure Airport </option>
                  <c:forEach  var = "airPort" items= "${airPorts}"  >
                    <option value="<c:out value = "${airPort.id}"/>"><c:out value = "${airPort.name}"/></option>
                  </c:forEach>
                </select>
              </div>
              <div class="w-full">
                <label for="arrivalAirport" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Arrival</label>
                <select name="arrivalAirport" id="arrivalAirport" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" aria-label="Default select example" required>
                  <option value="" disabled selected>Flight's Arrival Airport </option>
                  <c:forEach  var = "airPort" items= "${airPorts}"  >
                    <option value="<c:out value = "${airPort.id}"/>"><c:out value = "${airPort.name}"/></option>
                  </c:forEach>
                </select>
              </div>
            </div>

            <div class="w-full flex gap-4">
              <div class="w-full">
                <label for="date_depart" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Departure Date</label>
                <input type="datetime-local" name="date_depart" id="date_depart" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Select a date" data-mdb-toggle="datepicker" />
              </div>
              <div class="w-full">
                <label for="date_arrival" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Arrival Date</label>
                <input type="datetime-local" name="date_arrival" id="date_arrival" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Select a date" data-mdb-toggle="datepicker" />
              </div>
            </div>


            <div class="w-full flex gap-4">
              <div class="w-full">
                <label for="flightType" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Type</label>
                <select name="flightType" id="flightType" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" aria-label="Default select example" required>
                  <option value="" disabled selected>Flight's Type </option>
                  <c:forEach  var = "flightType" items= "${flightTypes}"  >
                    <option value="<c:out value = "${flightType.name()}"/>"><c:out value = "${flightType.name()}"/></option>
                  </c:forEach>
                </select>
              </div>
              <div class="w-full">
                <label for="amount" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Amount</label>
                <input type="number" name="amount" id="amount" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Flight Price" required>
              </div>

            </div>

            <button type="submit" class="w-full text-white bg-red-600 hover:bg-red-700 focus:ring-4 focus:outline-none focus:ring-orange-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Create</button>

          </form>
        </div>
      </div>
    </div>
  </div>


  <main class="flex-1 overflow-x-scroll px-4 ">
    <div class="flex items-center justify-between py-7 px-2">
      <div>
        <h1 class="text-2xl font-semibold leading-relaxed text-gray-800">Flights</h1>
      </div>
      <button class="inline-flex gap-x-2 items-center py-2.5 px-6 text-white bg-gray-900 rounded-md hover:bg-orange-600 focus:outline-none focus:ring-2 focus:ring-orange-500 focus:ring-offset-1" data-modal-target="flight-modal" data-modal-toggle="flight-modal" type="button">
        <span class="text-sm font-semibold tracking-wide">Create Flight</span>
      </button>
    </div>

    <div class="w-full mb-8 overflow-hidden rounded-sm  p-2">

      <div class="w-full overflow-x-auto">
        <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400" style="font-family: 'Prosto One', cursive;">

          <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
          <tr>
            <th scope="col" class="px-6 py-3">
              Flight ref
            </th>
            <th scope="col" class="px-6 py-3">
              From
            </th>
            <th scope="col" class="px-6 py-3">
              To
            </th>

            <th scope="col" class="px-6 py-3">
              Date
            </th>

            <th scope="col" class="px-6 py-3">
              Depart At
            </th>
            <th scope="col" class="px-6 py-3">
              Arrived At
            </th>

            <th scope="col" class="px-6 py-3">
              Type
            </th>

            <th scope="col" class="px-6 py-3">
              Amount
            </th>

            <th scope="col" class="px-6 py-3">
              Action
            </th>
          </tr>
          </thead>
          <tbody>


          <c:forEach  var = "flight" items= "${flights}"  >
            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">

              <th  class="px-6 py-4 font-medium text-gray-500 whitespace-nowrap dark:text-white">
               <c:out value = "${flight.id}"/>
              </th>
              <td class="px-6 py-4 font-medium text-gray-500 whitespace-nowrap dark:text-white">
                <c:out value = "${flight.departureAirport.city}"/>
              </td>
              <td  class="px-6 py-4 font-medium text-gray-500 whitespace-nowrap dark:text-white">
                <c:out value = "${flight.arrivalAirport.city}"/>
              </td>
              <td  class="px-6 py-4 font-medium text-gray-500 whitespace-nowrap dark:text-white">
                <fmt:formatDate type = "date" value = "${flight.departAt}" />
              </td>
              <td  class="px-6 py-4 font-medium text-gray-500 whitespace-nowrap dark:text-white">
                <fmt:formatDate type = "time" value = "${flight.departAt}" pattern = "HH:mm" />
              </td>
              <td class="px-6 py-4 font-medium text-gray-500 whitespace-nowrap dark:text-white">
                <fmt:formatDate type = "time" value = "${flight.arrivedAt}" pattern = "HH:mm" />
              </td>
              <td class="px-6 py-4 font-medium text-gray-500 whitespace-nowrap dark:text-white">
                <c:out value = "${flight.flightType}"/>
              </td>
              <td class="px-6 py-4 font-medium text-gray-500 whitespace-nowrap dark:text-white">
                <c:out value = "${flight.amount}"/>
              </td>

              <td  class="flex gap-3 px-6 py-4 font-medium text-gray-500 whitespace-nowrap dark:text-white">
                <a href="/flightPanel/flight/update?flight_id=<c:out value = "${flight.id}"/>">
                  <img width="28" height="28" src="https://img.icons8.com/external-anggara-flat-anggara-putra/32/external-edit-user-interface-anggara-flat-anggara-putra-2.png" alt="external-edit-user-interface-anggara-flat-anggara-putra-2"/>
                </a>
                <a href="/flightPanel/flight/delete?flight_id=<c:out value = "${flight.id}"/>">
                <img width="28" height="28" src="https://img.icons8.com/fluency/48/delete-forever.png" alt="delete-forever"/>
                </a>
              </td>
            </tr>
          </c:forEach>

          </tbody>
        </table>
      </div>
    </div>


  </main>
</div>
<script src="https://unpkg.com/flowbite@1.6.0/dist/flowbite.min.js"></script>
</body>
</html>
