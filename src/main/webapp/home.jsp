<%--
  Created by IntelliJ IDEA.
  User: shaowen
  Date: 12/1/21
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/home.css"/>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>

    <script type="text/javascript">
        //This is to prevent any jQuery code from running before the document is finished loading (is ready).
        //If not, for example, function probably cannot find the div or other labels before they are loaded.
        $(document).ready(function(){
            $("#info_area").hide();
            $("#all_info_area").hide();
            $("#search").click(function(){
                const studentID = document.getElementById("student_id").value;
                if (studentID === '') {
                    alert("Student ID can't empty!");
                    return;
                }

                let studentTable = $("#student_table tr:not(:first)").empty("");
                //The jQuery post() method sends asynchronous http POST request to the server to submit the data to the server and get the response.
                //Syntax: $.post(url,[data],[callback],[type]);
                $.post('${pageContext.request.contextPath}/SearchStudentServletName', {student_id: studentID}, function(responseJson){
                    if(responseJson!=null){
                        studentTable = $("#student_table");
                        const newRow = $("<tr><td></td><td></td><td></td><td></td></tr>");
                        newRow.children().eq(0).text(responseJson['id']);
                        newRow.children().eq(1).text(responseJson['name']);
                        newRow.children().eq(2).text(responseJson['gender']);
                        newRow.children().eq(3).text(responseJson['phone']);
                        newRow.appendTo(studentTable);
                        $("#info_area").show();
                    }
                    else{
                        alert("Can not find this student's information!")
                    }
                });
            });

            $("#all_search").click(function(){
                let allStudentTable = $("#all_student_table tr:not(:first)").empty("");
                //The $.get() method requests data from the server with an HTTP GET request.
                //Syntax: $.get(URL,callback);
                $.get('${pageContext.request.contextPath}/GetStudentServletName', function(responseJson){
                    if(responseJson!=null){
                        allStudentTable = $("#all_student_table");
                        //The each() method in jQuery specifies a function that runs for every matched element.
                        //Syntax: $(selector).each(function(index, element))
                        $.each(responseJson, function(key,value){
                            const newRow = $("<tr><td></td><td></td><td></td><td></td></tr>");
                            newRow.children().eq(0).text(value['id']);
                            newRow.children().eq(1).text(value['name']);
                            newRow.children().eq(2).text(value['gender']);
                            newRow.children().eq(3).text(value['phone']);
                            newRow.appendTo(allStudentTable);
                        });
                        $("#all_info_area").show();
                    }
                    else{
                        alert("Can not find this student's information!")
                    }
                });
            });
        });
    </script>
</head>
<body>

<div class="top_nav_area">
    <img src="images/head.jpg" class="head" alt="">
    <h3 style="position: absolute;left: 60px;top: 2px;">xxx Management System</h3>
</div>

<div class="sidenav_area">
    <a class="sidenav_bar" href="">Home</a>
    <a class="sidenav_bar" href="">Students info</a>
</div>

<div class="search_area">
    <h3>Manage students information</h3>

    <div>
        <label>Student ID<input id="student_id" name="student_id" type="text"></label>
        <button id="search">Search</button>
    </div>
    <div id="info_area">
        <table id="student_table" border="1" style='width: 400px;'>
            <tr>
                <th scope="col">Student ID</th>
                <th scope="col">Name</th>
                <th scope="col">Gender</th>
                <th scope="col">Phone</th>
            </tr>
        </table>
    </div>

    <button id="all_search">Search all inforamtion</button>
    <div id="all_info_area">
        <table id="all_student_table" border="1" style='width: 400px;'>
            <tr>
                <th scope="col">Student ID</th>
                <th scope="col">Name</th>
                <th scope="col">Gender</th>
                <th scope="col">Phone</th>
            </tr>
        </table>
    </div>
</div>

</body>
</html>