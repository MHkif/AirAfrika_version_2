<%--
  Created by IntelliJ IDEA.
  User: Mhkif
  Date: 24/10/2023
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://unpkg.com/tailwindcss@2.0.1/dist/tailwind.min.css" rel="stylesheet">
    <title>Authentication</title>
</head>
<body>
<section class="min-h-screen flex items-stretch text-white ">
    <div class="lg:flex w-2/3 hidden bg-white bg-no-repeat bg-cover relative items-center " style="background-image: url('https://images.unsplash.com/photo-1519666336592-e225a99dcd2f?auto=format&fit=crop&q=80&w=1888&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
                    font-family: 'Prosto One', cursive;">
        <div class="absolute  bg-black bg-opacity-40 inset-0 z-0"></div>
        <div class="w-full px-24 z-10">
            <h1 class="text-5xl font-bold text-left tracking-wide">Explore the univers</h1>
            <p class="text-3xl my-4">We Take Care of Your Flight</p>
        </div>
    </div>

    <div class="lg:w-1/2 w-full flex items-center justify-center text-center md:px-16 px-0 z-0">
        <div class="absolute lg:hidden z-10 inset-0 bg-gray-500 bg-no-repeat bg-cover items-center" style="background-image: url('');
                    font-family: 'Prosto One', cursive;">
            <div class="absolute bg-black opacity-40 inset-0 z-0"></div>
        </div>
        <div class="w-full z-20">
            <a href="">
                <div class="flex justify-center items-center pb-6 md:pb-10" aria-label="Home" role="img" style="font-family: 'Prosto One', cursive;">
                    <img class="cursor-pointer w-16 sm:w-auto" src="https://img.icons8.com/stencil/32/airport.png"  alt="logo" />
                    <p class=" text-white text-2xl font-bold md:text-gray-900 ">AirAfrika</p>

                </div>
            </a>

            <form id="formlogin" action="adminAuth" method="POST" class="px-4 w-full md:w-96 mx-auto">
            <div class="pb-2 pt-4">
                <input type="text" name="email" value="${email}" id="email" placeholder="Email" class="block w-full text-lg  bg-gray-50 rounded border border-gray-300 text-gray-900 focus:ring-orange-500 focus:border-orange-500 p-2 md:p-3">
                <span class="flex text-sm bg-black bg-opacity-30 rounded px-2 py-1 md:bg-transparent text-red-600">
                ${email_err}
                </span>

            </div>

            <div class="py-4">
                <input class="block w-full text-lg  bg-gray-50 rounded border border-gray-300 text-gray-900 focus:ring-orange-500 focus:border-orange-500 p-2 md:p-3" type="password" name="password" id="password" placeholder="Password">
                <span class="flex text-sm bg-black bg-opacity-30 rounded px-2 md:bg-transparent" id="passwordER"></span>

                <span class="flex text-sm bg-black bg-opacity-30 rounded px-2 py-1 md:bg-transparent text-red-600">
                           ${password_err}
                        </span>
            </div>

                <div class="pb-2 pt-4">
                    <span class="flex text-sm font-bold bg-black bg-opacity-30 rounded px-2 py-1 md:bg-transparent text-red-600">
                        ${notFound}
                    </span>

                </div>
            <div class=" pb-2 pt-6">
                <button type="submit"  class="uppercase w-full text-white bg-black hover:bg-orange-700 focus:ring-4 focus:outline-none focus:ring-orange-300 font-medium rounded-lg text-center p-2 md:p-3">Login</button>
            </div>


            </form>
        </div>
    </div>
</section>
</body>
</html>
