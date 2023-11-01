<%--
  Created by IntelliJ IDEA.
  User: Mhkif
  Date: 30/10/2023
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://unpkg.com/tailwindcss@2.0.1/dist/tailwind.min.css" rel="stylesheet">
    <title>Update Flight</title>
</head>
<body>
<div class="px-4 py-8 lg:px-6 flex flex-col gap-8">
    <div class="flex  items-center justify-center" aria-label="Home" role="img" style="font-family: 'Prosto One', cursive;">
        <p class="ml-2  text-base font-bold text-dark dark:text-white">Update Flight</p>
    </div>
    <form class="py-6 px-10 space-y-6" action="/flightPanel/flight/update?flight_id=<c:out value = "${flight.id}"/>" method="POST">
       <div class="px-10 space-y-4">
        <div class="w-full">
            <label for="airPlane" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">AirPlane</label>
            <select name="airPlane" id="airPlane" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" aria-label="Default select example" required>
                <option value="<c:out value = "${flight.airplane.id}"/>"  selected><c:out value = "${flight.airplane.name}"/> </option>
                <c:forEach  var = "airPlane" items= "${airPlanes}"  >
                    <option value="<c:out value = "${airPlane.id}"/>"><c:out value = "${airPlane.name}"/></option>
                </c:forEach>
            </select>
        </div>
        <div class="w-full flex gap-4">
            <div class="w-full">
                <label for="departureAirport" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Departure</label>
                <select name="departureAirport" id="departureAirport" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" aria-label="Default select example" required>
                    <option value="<c:out value = "${flight.departureAirport.id}"/>"  selected><c:out value = "${flight.departureAirport.name}"/> </option>
                    <c:forEach  var = "airPort" items= "${airPorts}"  >
                        <option value="<c:out value = "${airPort.id}"/>"><c:out value = "${airPort.name}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="w-full">
                <label for="arrivalAirport" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Arrival</label>
                <select name="arrivalAirport" id="arrivalAirport" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" aria-label="Default select example" required>
                    <option value="<c:out value = "${flight.arrivalAirport.id}"/>"  selected><c:out value = "${flight.arrivalAirport.name}"/> </option>
                    <c:forEach  var = "airPort" items= "${airPorts}"  >
                        <option value="<c:out value = "${airPort.id}"/>"><c:out value = "${airPort.name}"/></option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="w-full flex gap-4">
            <div class="w-full">
                <label for="date_depart" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Departure Date</label>
                <input type="datetime-local" value="<c:out value = "${flight.departAt}"/>" name="date_depart" id="date_depart" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Select a date" data-mdb-toggle="datepicker" />
            </div>
            <div class="w-full">
                <label for="date_arrival" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Arrival Date</label>
                <input type="datetime-local" value="<c:out value = "${flight.arrivedAt}"/>" name="date_arrival" id="date_arrival" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Select a date" data-mdb-toggle="datepicker" />
            </div>
        </div>
        <div class="w-full flex gap-4">
            <div class="w-full">
                <label for="flightType" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Type</label>
                <select name="flightType" id="flightType" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" aria-label="Default select example" required>
                    <option value="<c:out value = "${flight.flightType}"/>"  selected><c:out value = "${flight.flightType}"/></option>
                    <c:forEach  var = "flightType" items= "${flightTypes}"  >
                        <option value="<c:out value = "${flightType.name()}"/>"><c:out value = "${flightType.name()}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="w-full">
                <label for="amount" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Amount</label>
                <input type="number" name="amount" value="<c:out value = "${flight.amount}"/>" id="amount" class="bg-white border border-gray-300 text-gray-900 text-sm rounded focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Flight Price" required>
            </div>

        </div>
       </div>
        <button type="submit" class="w-full md:w-44 text-white bg-red-600 hover:bg-red-700 focus:ring-4 focus:outline-none focus:ring-orange-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Update</button>



    </form>
</div>
</body>
</html>
