<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>HTML5 All in One for Dummies</title>
    <link rel="stylesheet" type="text/css" href="highLow.php_files/haio.css">
  </head>
  <body>
    <h1>highLow.php</h1>

  <h2>Source of highLow.php</h2> 
    <pre>&lt;!doctype html&gt;
&lt;html lang="en"&gt;
&lt;head&gt;
  &lt;meta charset="UTF-8"&gt;
  &lt;title&gt;highLow.php&lt;/title&gt;
&lt;/head&gt;
&lt;body&gt;
  &lt;h1&gt;High or low?&lt;/h1&gt;
  &lt;p&gt;
    &lt;a href = "highLow.php"&gt;roll again&lt;/a&gt;
  &lt;/p&gt;
  &lt;?php
  $roll = rand(1,6);
	print &lt;&lt;&lt;HERE
  &lt;p&gt;
	  &lt;img src = "images/dado_$roll.png"
	       alt = "$roll"
               height = "100px"
               width = "100px" /&gt;
  &lt;/p&gt;
HERE;
  if ($roll &gt; 3){
    print "&lt;h2&gt;You rolled a high one&lt;/h2&gt;\n";
  } else {
    print "&lt;h2&gt;That's pretty low&lt;/h2&gt; \n";
  } // end if
  ?&gt;
&lt;/body&gt;
&lt;/html&gt;

    </pre>
  


</body></html>