<?php
require "header.php";
$result = array();
$resultWithAddress = array();

if (!empty($_POST)){
    $file = fopen("cottage.txt","r");
    if ($file) {
        while (($buffer = fgets($file, 4096)) !== false) {
            //JSON example: {"petsAllowed":true,"type":"2/5","location":"Laurentides",
            //     "price":1180,"amenities":["fire","Laundromat","BBQ","Water","Laundromat"]}
            $json = trim($buffer);
            $myCottage = json_decode($json, true);
            if ($myCottage['petsAllowed'] == false && (isset($_POST['cats']) ||
                    isset($_POST['dogs']) || isset($_POST['Other']))) continue;
            if ((isset($_POST["1/2"]) || isset($_POST["1/3"]) || isset($_POST["1/4"]) ||
                        isset($_POST["2/5"])) && !isset($_POST[$myCottage['type']])) continue;

            if ((isset($_POST["Mont-Tremblant"]) || isset($_POST["Laurentides"]) || isset($_POST["Magog"]) ||
                        isset($_POST["Gatineau"]) || isset($_POST["Quebec City"]))
                && !isset($_POST[$myCottage['location']])) continue;
            if ($_POST['price'] == '<500' && $myCottage['price'] >= 500) continue;
            if ($_POST['price'] == '500to800' && ($myCottage['price'] > 800 || $myCottage['price'] < 500)) continue;
            if ($_POST['price'] == '801to1000' && ($myCottage['price'] > 1000 || $myCottage['price'] < 801)) continue;
            if ($_POST['price'] == '1001to1200' && ($myCottage['price'] > 1200 || $myCottage['price'] < 1001)) continue;
            if (isset($_POST['fire']) && !in_array('fire', $myCottage['amenities'])) continue;
            if (isset($_POST['Laundromat']) && !in_array('Laundromat', $myCottage['amenities'])) continue;
            if (isset($_POST['BBQ']) && !in_array('BBQ', $myCottage['amenities'])) continue;
            if (isset($_POST['Parking']) && !in_array('Parking', $myCottage['amenities'])) continue;
            if (isset($_POST['Balcony']) && !in_array('Balcony', $myCottage['amenities'])) continue;
            if (isset($_POST['Water']) && !in_array('Water', $myCottage['amenities'])) continue;
            if ($myCottage['petsAllowed']){
                $yn = "yes";
            } else {
                $yn = "no";
            }
            $amenities = implode(", ", $myCottage['amenities']);
            $stringWithoutAddress = "Pets allowed: {$yn}, type: {$myCottage['type']}, ".
                "location: {$myCottage['location']}, price: {$myCottage['price']}, amenities: ".
            "{$amenities}.";
            $stringWithAddress = $stringWithoutAddress.", ".$myCottage['address'];
            array_push($result, $stringWithoutAddress);
            array_push($resultWithAddress,$stringWithAddress);
        }
        if (!feof($file)) {
            echo "Error: unexpected fgets() fail\n";
        }
        fclose($file);
    }
}
?>
<form method="post">
    <fieldset id="ExpertSuggestion">
        <legend id="suggestionLegend">Expert Suggestion</legend>

            <?php
            if (!empty($_POST)){
                echo "<script>document.getElementById(\"ExpertSuggestion\").style.display = \"inline\"</script>";
                echo "<script>document.getElementById(\"ExpertSuggestion\").style.width = \"98%\" </script>";
            }
            if (empty($result)){
                echo "<h2>It is very difficult to find a cottage like this...Please try again.</h2>";
            } else {
                echo "<h2>Search result:</h2>";
                echo "<ol>";
                if ($_SESSION['login'] == True){
                    foreach ($resultWithAddress as $string){
                        echo "<li class='prompt'>$string</li>";
                    }
                } elseif ($_SESSION['login'] == False){
                    foreach ($result as $string){
                        echo "<li class='prompt'>$string</li>";
                    }
                    ?>
                    <br/>
                    <div class="newLoginButton">
                        <button type="button" class="button" onclick="login()">login to show the address</button>
                    </div>
            <?php
                }
            }
            ?>

        </ol>

    </fieldset>
    <fieldset id="RenterInfo">
        <legend id="rentLegend">Renter(s) Information</legend>
        <label class="prompt">How many people will come to this cottage?
            <input type="number" min="1" name="number of renter"/>
        </label>
        <p>
            <label class="prompt">Smoker?</label>
            <label><input type="radio" name="smoker" value="yes">Yes</label>
            <label><input type="radio" name="smoker" value="no">No</label>
        </p>
        <p>
            <label class="prompt">Any pets?</label><br/>
            <label><input type="checkbox" name="cats" value="cats">Cat(s)</label><br/>
            <label><input type="checkbox" name="dogs" value="dogs">Dog(s)</label><br/>
            <label><input type="checkbox" name="Other" value="Other">Other </label>
            <label class="prompt">Specify:<input type="text" name="other pets"></label><br/>
            <label><input type="checkbox" name="noPets" value="no">No Pets</label>
        </p>
    </fieldset>
    <br>
    <fieldset id="CottageInfo">
        <legend id="CottageLegend">What are you looking for?</legend>
        <ul>
            <li>
                <label class="prompt">Number of Bathrooms/Bedrooms:</label><br/>
                <label><input type="checkbox" name="1/2" value="1/2">&frac12;</label>
                <label><input type="checkbox" name="1/3" value="1/3">&frac13;</label>
                <label><input type="checkbox" name="1/4" value="1/4">&frac14;</label>
                <label><input type="checkbox" name="2/5" value="2/5">&frac25;</label>
            </li>
            <li>
                <p>
                    <label class="prompt">Do you have preferred locations?</label><br/>
                    <label><input type="checkbox" name="Mont-Tremblant" value="Mont-Tremblant">Mont-Tremblant</label>
                    <label><input type="checkbox" name="Laurentides" value="Laurentides">Laurentides</label>
                    <label><input type="checkbox" name="Magog" value="Magog">Magog</label>
                    <label><input type="checkbox" name="Gatineau" value="Gatineau">Gatineau</label>
                    <label><input type="checkbox" name="Quebec City" value="Quebec City">Quebec City</label>
                    <label><input type="checkbox" name="Don't care" value="Don't care">Don't care</label>
                </p>
            </li>
            <li>
                <p>
                    <label class="prompt">Price Range/Weekend <br>
                        <select name="price" id="price">
                            <option value="<500">&lt;$500</option>
                            <option value="500to800">$500-$800</option>
                            <option value="801to1000">$801-$1000</option>
                            <option value="1001to1200">$1001-$1200</option>
                            <option value="no price">No price limit</option>
                        </select>
                    </label>
                </p>
            </li>
            <li>
                <p>
                    <label class="prompt">Would be nice to have </label><br>
                    <label><input type="checkbox" name="fire" value="fire">Fire place</label>
                    <label><input type="checkbox" name="Laundromat" value="Laundromat">Laundromat in building</label>
                    <label><input type="checkbox" name="BBQ" value="BBQ">BBQ</label>
                    <label><input type="checkbox" name="Parking" value="Parking">Output Parking</label>
                    <label><input type="checkbox" name="Balcony" value="Balcony">Balcony</label>
                    <label><input type="checkbox" name="Water" value="Water">Water Front</label>
                </p>
            </li>
        </ul>
    </fieldset>
    <br>

    <p>
        Let's see what we can find...
    </p>
    <p>
        <input type="submit" value="Search" >
        <input type="reset" value="Start over">
    </p>
</form>
<?php
require "footer.php";
?>
