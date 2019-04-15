<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>arrayHTML.php</title>
</head>
<body>
  <h1>Arrays are useful in HTML</h1>
  <div>
    <?php
      //first make an array of mini-book names
      $books = array("Creating the XHTML Foundation",
                     "Styling with CSS",
                     "Using Positional CSS for Layout",
                     "Client-Side Programming with JavaScript",
                     "Server-Side Programming with PHP",
                     "Databases with MySQL",
                     "Into the Future with AJAX",
                     "Moving From Pages to Web Sites");

      //make the array into a numbered list
      print "<ol>\n";
      foreach ($books as $book){
        print "  <li>$book</li> \n";
      } // end foreach
      print "</ol>\n";

      //make the array into a select object
      print "<select name = \"book\"> \n";
      foreach ($books as $book){
        print "  <option value = \"$book\">$book</option> \n";
      } // end foreach
      print "</select> \n";
    ?>
  </div>  
</body>
</html>