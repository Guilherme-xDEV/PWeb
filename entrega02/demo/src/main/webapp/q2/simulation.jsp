<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buy a Vehicle Page</title>
</head>
<body>

    <h1>Simulate a Buy:</h1>

    <form action="/demo/simulateBuy" method="POST">
        
        <label>Vehicle Value:</label>
        <input type="text" name="VehicleValue" placeholder=""><br>

        <label>Entry Value:</label>
        <input type="text" name="EntryValue" placeholder=""><br>

        <label>Tax:</label>
        <input type="text" name="Tax" placeholder=""><br>

        <label>Time:</label>
        <input type="text" name="Time" placeholder=""><br>

        <button type="submit">Simulate Buy</button>

    </form>
    
</body>
</html>