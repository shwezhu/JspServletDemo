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
            $("#infoArea").hide();
            $("#allInfoArea").hide();
            $("#search").click(function(){
                const studentID = document.getElementById("studentID").value;
                if (studentID === '') {
                    alert("Student ID can't empty!");
                    return;
                }

                let studentTable = $("#studentTable tr:not(:first)").empty("");
                //The jQuery post() method sends asynchronous http POST request to the server to submit the data to the server and get the response.
                //Syntax: $.post(url,[data],[callback],[type]);
                //In servlet: request.getParameter("studentID") is json name blew.
                $.post('${pageContext.request.contextPath}/SearchStudentServletName', {studentID: studentID}, function(responseJson){
                    if(responseJson!=null){
                        studentTable = $("#studentTable");
                        const newRow = $("<tr><td></td><td></td><td></td><td></td></tr>");
                        newRow.children().eq(0).text(responseJson['id']);
                        newRow.children().eq(1).text(responseJson['name']);
                        newRow.children().eq(2).text(responseJson['gender']);
                        newRow.children().eq(3).text(responseJson['phone']);
                        newRow.appendTo(studentTable);
                        $("#infoArea").show();
                    }
                    else{
                        alert("Can not find this student's information!")
                    }
                });
            });

            $("#searchAll").click(function(){
                let allStudentTable = $("#allStudentTable tr:not(:first)").empty("");
                //The $.get() method requests data from the server with an HTTP GET request.
                //Syntax: $.get(URL,callback);
                $.get('${pageContext.request.contextPath}/GetStudentServletName', function(responseJson){
                    if(responseJson!=null){
                        allStudentTable = $("#allStudentTable");
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
                        $("#allInfoArea").show();
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
    <div class="topNavigationArea">
        <img src="images/head.jpg" class="head" alt="">
        <h3 style="position: absolute;left: 60px;top: 2px;">xxx Management System</h3>
    </div>

    <div class="leftNavigationArea">
        <a class="sidenav_bar" href="">Home</a>
    </div>

    <div class="searchArea">
        <h3>Manage students information</h3>
        <div>
            <label>Student ID<input id="studentID" name="studentID" type="text"></label>
            <button id="search">Search</button>
        </div>
        <div id="infoArea">
            <table id="studentTable" border="1" style='width: 400px;'>
                <tr>
                    <th scope="col">Student ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Gender</th>
                    <th scope="col">Phone</th>
                </tr>
            </table>
        </div>

        <button id="searchAll">Search all information</button>
        <div id="allInfoArea">
            <table id="allStudentTable" border="1" style='width: 400px;'>
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