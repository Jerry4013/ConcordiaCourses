<h3>Your Pizza Order:</h3>
<?php
    $cr = $_SESSION["crust"];
    $top = $_SESSION["toppings"];
    echo '<p style=" color: #ff0000;; font-weight: bold">';
    if ( $cr ) { echo "$cr, "; }
    if ( $top ){ echo "$top</p>"; }
?>
<form method="post" action="">
<p>Choose Crust:
<input id="tn" type="radio" name="crust" value="Thin crust" />
<label for="tn">Thin crust</label>
<input id="tk" type="radio" name="crust" value="Thick crust" />
<label for="tk">Thick crust</label><br /><br />
Add Toppings: <br />
<input id="ro" type="radio" name="top" value="pepperoni" />
<label for="ro">pepperoni</label>
<input id="hm" type="radio" name="top" value="ham" />
<label for="hm">ham</label><br />
<input id="rm" type="radio" name="top" value="mushroom" />
<label for="rm">mushroom</label>
<input id="on" type="radio" name="top" value="onion" />
<label for="on">onion</label>
<input id="ch" type="radio" name="top" value="extra cheese" />
<label for="ch">Extra Cheese</label><br /><br />
<input type="submit" name="submit" value=" Enter " /> 
<input type="submit" name="submit" value=" Done " /></p>
</form>
