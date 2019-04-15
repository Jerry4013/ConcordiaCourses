<?php
/**
 * Created by PhpStorm.
 * User: JerryZhang
 * Date: 2018-11-29
 * Time: 2:11 PM
 *
 * This file is just used to creating some sample cottage information.
 */

if (!empty($_POST)){
    $file = fopen("cottage.txt","a+");
    fwrite($file, $_POST["cottage"]."\n");
    fclose($file);
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Author" content="Jingchao Zhang"/>
    <title>Random Cottage Generator</title>
    <link rel="stylesheet" type="text/css" href="mystyle.css">
    <script>
        function shuffle(arr) {
            var j, x, i;
            for (i = arr.length - 1; i > 0; i--) {
                j = Math.floor(Math.random() * (i + 1));
                x = arr[i];
                arr[i] = arr[j];
                arr[j] = x;
            }
            return arr;
        }
        function createCottage() {
            var petAllowed = [true, false];
            var type = ["1/2", "1/3","1/4","2/5"];
            var location = ["Mont-Tremblant", "Laurentides", "Magog", "Gatineau","Quebec City"];
            var amenities = ["fire","Laundromat","BBQ","Parking","Balcony","Water"];
            var address = ["300 Glenlake St., Griffintown, QC H3C X1G",
                "235 Lafayette St., Outremont, QC H2V B8P",
                "76 Tailwater St. La Prairie, QC J5R H3H",
                "507 Lakeshore Street Grand-Mère, QC G9T P6C",
                "485 Heather St. Maniwaki, QC J9E C9H",
                "475 Bayberry Street Sainte-Dorothée, QC H7X Y4X",
                "20 Delaware Dr. Gaspé, QC G4X N7H",
                "8789 South John Lane Val-des-Monts, QC J8N E0V",
                "9865 Plymouth St. Windsor, QC J1S L9G",
                "90 Catherine Dr. Asbestos, QC J1T V8H",
                "654 Pacific St. Laval-des-Rapides, QC H7N Y7Y",
                "211 Roehampton Street, Cap-Rouge, QC G1Y H5R",
                "8129 Arcadia Road, Saint-Émile, QC G3E P5S",
                "938 Cherry Hill Street, Lac-Megantic, QC G6B N0A",
                "7834 Lafayette Ave. Port-Cartier, QC G5B R2M",
                "443 Walt Whitman Dr., Estrie-Ouest, QC J0E J4A",
                "897 Harrison Street Gaspésie-Ouest, QC G0J L4H",
                "52 Queen Drive, Maisonneuve, QC H1V L8L"];

            var cottage = {};
            cottage.petsAllowed = petAllowed[Math.floor(Math.random()*petAllowed.length)];
            cottage.type = type[Math.floor(Math.random()*type.length)];
            cottage.location = location[Math.floor(Math.random()*location.length)];
            cottage.price = Math.floor(Math.random()*900)+300;
            var n = Math.floor(Math.random()*amenities.length)+1;
            shuffle(amenities);
            cottage.amenities = amenities.slice(0,n);
            cottage.address = address[Math.floor(Math.random()*address.length)];
            var myJSON = JSON.stringify(cottage);
            document.getElementById("cottage").value = myJSON;
        }
    </script>
</head>
<body>

<form action="" method="post">
    <input id="cottage" type="text" name="cottage">
    <button onclick="createCottage()">Generate a Random cottage</button>
</form>

</body>
</html>