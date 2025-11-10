<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.javaeedemo2.product.Product" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Information</title>
    <script>
        function editProduct(id, name, price, stock) {
            document.getElementById('formAction').value = 'update';
            document.getElementById('id').value = id;
            document.getElementById('name').value = name;
            document.getElementById('price').value = price;
            document.getElementById('stock').value = stock;
            document.getElementById('submitBtn').value = 'Update Product';
        }

        function clearForm() {
            document.getElementById('productForm').reset();
            document.getElementById('formAction').value = 'add';
            document.getElementById('id').value = '';
            document.getElementById('submitBtn').value = 'Add Product';
        }
    </script>
</head>
<body>
<h1>Product Information Management</h1>

<!-- 添加/修改表单 -->
<h2 id="formTitle">Add New Product</h2>
<form id="productForm" action="products" method="post">
    <input type="hidden" name="action" id="formAction" value="add">
    <input type="hidden" name="id" id="id">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" id="name" required></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="number" step="0.01" name="price" id="price" required></td>
        </tr>
        <tr>
            <td>Stock:</td>
            <td><input type="number" name="stock" id="stock" required></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" id="submitBtn" value="Add Product">
                <input type="button" value="Clear" onclick="clearForm()">
            </td>
        </tr>
    </table>
</form>

<!-- 数据展示表格 -->
<h2>Product List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Stock</th>
        <th>Actions</th>
    </tr>
    <%
        List<Product> products = (List<Product>) request.getAttribute("products");
        if (products != null && !products.isEmpty()) {
            for (Product product : products) {
    %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %></td>
        <td><%= product.getStock() %></td>
        <td>
            <button onclick="editProduct('<%= product.getId() %>', '<%= product.getName() %>', '<%= product.getPrice() %>', '<%= product.getStock() %>')">Edit</button>
            <form action="products" method="post" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= product.getId() %>">
                <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this product?')">
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">暂无数据</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
