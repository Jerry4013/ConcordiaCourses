<!DOCTYPE html>
<html lang="en">
  <head> 
    <meta charset="utf-8"/>
  </head>
  <body>
	<h1> File I/O - Writing and reading to/from file</h1>
<?php
$myfile = fopen("file_io4.txt", "w") or die("Unable to open file!");
$txt = "Mickey Mouse\n";
fwrite($myfile, $txt);
$txt = "Minnie Mouse\n";
fwrite($myfile, $txt);
echo "Just finished writing to file<br />Content of file:";
fclose($myfile);
//------------------------------------------------
// Read one line at a time using fgets & feof


//------------------------------------------------------
// Read using fread


//------------------------------------------------------
//Read using readfile


//------------------------------------------------------
//Read using readfile (Display what was read with print_r)


//---------------------------------------------------------
// Get content of file using file_get_content


?>
  </body>
</html>
