<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <link href="https://unpkg.com/tailwindcss@2.0.1/dist/tailwind.min.css" rel="stylesheet">
  <title>AirAfrika</title>
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
            <a href="/" class="inline-block rounded-md px-3 py-1.5 text-sm font-semibold leading-6  shadow-sm ring-1 ring-red-500 ring-inset  hover:ring-red-600 hover:ring-0 bg-red-500 text-white" type="button">Flights</a>
          </li>

        <li>
          <a href="/my-reservations" class="inline-block rounded-lg px-3 py-1.5 text-sm font-semibold leading-6 text-gray-900 shadow-sm ring-1 ring-red-500 ring-inset  hover:ring-red-600 hover:ring-0 hover:bg-red-500 hover:text-white" type="button">My Reservations</a>
        </li>

      </ul>
    </div>
  </div>
</nav>

<!-- Booking -->
<section id="booking" class=" my-10 px-6 md:px-8  md:my-14" style="font-family: 'Prosto One', cursive;">
  <div class="w-full flex flex-col  justify-center items-center">
    <h1 class=" max-w-md text-1xl font-bold text-center my-6 md:text-3xl md:text-left md:my-8">
      Where do you want to go?
    </h1>
  </div>

  <form class="w-full flex flex-col justify-center items-end gap-4 md:flex-row md:gap-6 mb-6" action="/flights" method="post">
    <div class="w-full flex flex-col  md:w-44 gap-2 " >
      <label for="departure" class="text-base font-medium text-gray-800">From</label>
      <select  name="departure" id="departure" class="form-select appearance-none block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white border border-solid border-gray-400 rounded" aria-label="Default select example" required>
        <option selected disabled>Select a Airport</option>
        <c:forEach  var = "airPort" items= "${airPorts}"  >
          <option value="<c:out value = "${airPort.id}"/>"><c:out value = "${airPort.name}"/></option>
        </c:forEach>
      </select>
    </div>

    <div class="text-black">
      <img width="40" height="40" src="https://img.icons8.com/dotty/80/sorting-arrows-horizontal.png" alt="sorting-arrows-horizontal"/>
    </div>

    <div class="w-full flex flex-col  md:w-44 gap-2 " >
      <label for="arrival" class="text-base font-medium text-gray-800">To</label>
      <select  name="arrival" id="arrival" class="form-select appearance-none block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white border border-solid border-gray-400 rounded" aria-label="Default select example" required>
        <option selected disabled>Select a Airport</option>
        <c:forEach  var = "airPort" items= "${airPorts}"  >
          <option value="<c:out value = "${airPort.id}"/>"><c:out value = "${airPort.name}"/></option>
        </c:forEach>
      </select>
    </div>
    <div class="w-full flex flex-col  md:w-44 gap-2 " >
      <label for="depart_At" class="text-base font-medium text-gray-800">Depart At</label>
      <input  name="depart_At" id="depart_At" type="date" class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-400 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none" placeholder="dd/mm/yy" required>
    </div>

    <input type="submit" value="Search" class="inline-flex justify-center  content-center px-4 py-2.5 bg-red-600 text-white font-medium text-xs leading-normal uppercase rounded shadow-md hover:bg-red-800  cursor-pointer hover:shadow-lg focus:bg-orange-600 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-orange-600 active:shadow-lg transition duration-150 ease-in-out">

  </form>
</section>

<!-- Flights -->
<section class="container-fluid flex flex-col justify-center items-center bg-white space-y-12 px-4 md:px-10 my-10">
  <h1 class="max-w-md text-xl font-bold text-center md:text-2xl md:text-left" style="font-family: 'Poppins', sans-serif;">
    All Flights
  </h1>


  <ul id="paginated-list" data-current-page="1" aria-live="polite" class="grid gap-y-6  grid-cols px-4 w-3/4">

    <c:forEach  items= "${flights}" var = "flight" >

      <li class="shadow-md  items-center md:justify-between w-full rounded-lg group md:flex  bg-white  hover:rounded-xl" style="font-family: 'Poppins', sans-serif;">
        <div class="flex w-full flex-col justify-between items-center p-4">
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
            Book
            <svg aria-hidden="true" class="w-4 h-4 ml-2 -mr-1" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
            </svg>
          </a>

        </div>

      </li>

    </c:forEach>

  </ul>



  <nav class="pagination-container inline-flex ">
    <button class="pagination-button px-1 sm:px-3 sm:py-1 ml-0 mr-2 font-bold leading-tight text-white bg-gray-900 rounded-l-sm hover:bg-red-500 hover:text-gray-100 " id="prev-button" aria-label="Previous page" title="Previous page">
      <
    </button>



    <button class="pagination-button px-3 py-2 ml-2 font-bold leading-tight text-white bg-gray-900 rounded-r-sm hover:bg-red-500 hover:text-gray-100" id="next-button" aria-label="Next page" title="Next page">
      >
    </button>
  </nav>


</section>


</body>
</html>