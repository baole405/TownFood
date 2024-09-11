<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Summary</title>
    <!-- MDB CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.0/mdb.min.css" rel="stylesheet">
    <style>
        .order-summary {
            max-width: 400px;
            margin: auto;
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 20px;
            background-color: #f8f9fa;
        }
        .summary-title {
            font-size: 1.25rem;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .summary-item {
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
        }
        .summary-total {
            display: flex;
            justify-content: space-between;
            font-size: 1.25rem;
            font-weight: bold;
            margin-top: 20px;
            padding-top: 10px;
            border-top: 1px solid #ddd;
        }
        .checkout-button {
            display: block;
            width: 100%;
            background-color: #4CAF50;
            color: white;
            text-align: center;
            padding: 15px;
            font-size: 1rem;
            text-decoration: none;
            border-radius: 8px;
            margin-top: 20px;
        }
        .coupon-code {
            color: green;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container my-5">
        <div class="order-summary">
            <div class="summary-title">Order Summary</div>
            <div class="summary-item">
                <span>Subtotal</span>
                <span>$418</span>
            </div>
            <div class="summary-item">
                <span>Shipping</span>
                <span>Free</span>
            </div>
            <div class="summary-total">
                <span>Total</span>
                <span>$418</span>
            </div>
            <a href="#" class="checkout-button">CHECKOUT</a>
        </div>
    </div>
    <!-- MDB JS -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.0/mdb.min.js"></script>
</body>
</html>
