<%@ page import="java.util.List" %>
<%@ page import="com.example.javaeedemo2.manager.Manager" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manager Information</title>
    <script>
        function editManager(id, name, sex, ssn, birthday, age, nation, political, hometown) {
            document.getElementById('formAction').value = 'update';
            document.getElementById('cmId').value = id;
            document.getElementById('cmName').value = name;
            document.getElementById('cmSex').value = sex;
            document.getElementById('cmSsn').value = ssn;
            document.getElementById('cmBirthday').value = birthday;
            document.getElementById('cmAge').value = age;
            document.getElementById('cmNation').value = nation;
            document.getElementById('cmPolitical').value = political;
            document.getElementById('cmHometown').value = hometown;
            document.getElementById('submitBtn').value = 'Update Manager';
        }

        function clearForm() {
            document.getElementById('managerForm').reset();
            document.getElementById('formAction').value = 'add';
            document.getElementById('cmId').value = '';
            document.getElementById('submitBtn').value = 'Add Manager';
        }
    </script>
</head>
<body>
<h1>Manager Information Management</h1>

<!-- 添加/修改表单 -->
<h2 id="formTitle">Add New Manager</h2>
<form id="managerForm" action="managers" method="post">
    <input type="hidden" name="action" id="formAction" value="add">
    <input type="hidden" name="cmId" id="cmId">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="cmName" id="cmName" required></td>
        </tr>
        <tr>
            <td>Sex:</td>
            <td><input type="text" name="cmSex" id="cmSex" required></td>
        </tr>
        <tr>
            <td>SSN:</td>
            <td><input type="text" name="cmSsn" id="cmSsn" required></td>
        </tr>
        <tr>
            <td>Birthday:</td>
            <td><input type="date" name="cmBirthday" id="cmBirthday" required></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><input type="number" name="cmAge" id="cmAge" required></td>
        </tr>
        <tr>
            <td>Nation:</td>
            <td><input type="text" name="cmNation" id="cmNation" required></td>
        </tr>
        <tr>
            <td>Political:</td>
            <td><input type="text" name="cmPolitical" id="cmPolitical" required></td>
        </tr>
        <tr>
            <td>Hometown:</td>
            <td><input type="text" name="cmHometown" id="cmHometown" required></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" id="submitBtn" value="Add Manager">
                <input type="button" value="Clear" onclick="clearForm()">
            </td>
        </tr>
    </table>
</form>

<!-- 数据展示表格 -->
<h2>Manager List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Sex</th>
        <th>SSN</th>
        <th>Birthday</th>
        <th>Age</th>
        <th>Nation</th>
        <th>Political</th>
        <th>Hometown</th>
        <th>Actions</th>
    </tr>
    <%
        List<Manager> managers = (List<Manager>) request.getAttribute("managers");
        if (managers != null && !managers.isEmpty()) {
            for (Manager manager : managers) {
    %>
    <tr>
        <td><%= manager.getCmId() %></td>
        <td><%= manager.getCmName() %></td>
        <td><%= manager.getCmSex() %></td>
        <td><%= manager.getCmSsn() %></td>
        <td><%= manager.getCmBirthday() != null ? manager.getCmBirthday() : "" %></td>
        <td><%= manager.getCmAge() %></td>
        <td><%= manager.getCmNation() %></td>
        <td><%= manager.getCmPolitical() %></td>
        <td><%= manager.getCmHometown() %></td>
        <td>
            <button onclick="editManager('<%= manager.getCmId() %>', '<%= manager.getCmName() %>', '<%= manager.getCmSex() %>', '<%= manager.getCmSsn() %>', '<%= manager.getCmBirthday() != null ? manager.getCmBirthday() : "" %>', '<%= manager.getCmAge() %>', '<%= manager.getCmNation() %>', '<%= manager.getCmPolitical() %>', '<%= manager.getCmHometown() %>')">Edit</button>
            <form action="managers" method="post" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="cmId" value="<%= manager.getCmId() %>">
                <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this manager?')">
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="10">暂无数据</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
