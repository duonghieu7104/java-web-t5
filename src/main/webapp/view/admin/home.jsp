<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NIKA Style Homepage</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <style>
        /* Custom CSS for Adidas-style Homepage */
        body {
            font-family: Arial, sans-serif;
        }
        .navbar {
            background-color: #000;
        }
        .navbar-brand, .nav-link {
            color: #fff !important;
            font-size: 18px;
        }
        .hero {
            background-image: url('https://example.com/adidas-banner.jpg'); /* Replace with an actual Adidas banner image */
            background-size: cover;
            background-position: center;
            height: 2vh;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
        }
        .hero h1 {
            font-size: 48px;
            font-weight: bold;
            text-transform: uppercase;
        }
        .product-section {
            padding: 60px 0;
        }
        .product {
            margin-bottom: 30px;
        }
        .product img {
            width: 100%;
            border-radius: 8px;
        }
        .product h4 {
            text-align: center;
            margin-top: 15px;
            font-weight: bold;
        }
        .footer {
            background-color: #000;
            color: white;
            padding: 20px 0;
            text-align: center;
        }
        .footer a {
            color: white;
            text-decoration: none;
        }
        .footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>Welcome, <%= request.getAttribute("username") %>!</h1>
    <p>This is the admin home page.</p>
    
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <a class="navbar-brand" href="#">NIKA</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<%=request.getContextPath()%>/admin/updateprofile">Profile</a>



                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Men</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Women</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Kids</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Sale</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Hero Section -->
    <section class="hero">
        <h1>Elevate Your Game</h1>
    </section>

    <!-- Product Section -->
    <section class="product-section container">
        <div class="row">
            <div class="col-md-4 product">
                <img src="https://i.imgur.com/uZveXDI.jpeg" alt="Nika Shoe 1"> <!-- Replace with actual product image -->
                <h4>Nika superfly</h4>
            </div>
            <div class="col-md-4 product">
                <img src="https://i.imgur.com/h1hEr4V.jpeg" alt="Adidas Shoe 2"> <!-- Replace with actual product image -->
                <h4>Nika Airforce</h4>
            </div>
            <div class="col-md-4 product">
                <img src="https://i.pinimg.com/564x/fb/fd/41/fbfd41bbbded21f3d9972d27b5fae28d.jpg" alt="Adidas Shoe 3"> <!-- Replace with actual product image -->
                <h4>Nika AirForce1</h4>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
        <p>&copy; 2024 Nika | <a href="#">Privacy Policy</a></p>
    </footer>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
