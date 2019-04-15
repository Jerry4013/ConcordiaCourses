<!DOCTYPE html>
<html lang="en">
  <head> 
    <meta charset="utf-8"/>
  </head>
  <body>
	<h1> File I/O - File status</h1>
<?php
$filename = "file_io.php";

if (file_exists($filename)) {
    echo "The file <b>$filename</b> exists<br /><br />";
	
	$info=fileatime($filename);
    echo "Last access of <b>$filename </b> is $info<br />";
	echo "Last access: ".date("F d Y H:i:s.",$info)."<br /><br />";
		
	$info=date(filemtime($filename));
	echo "Last time <b>$filename </b> was modified $info<br />";
	echo "Last modified: ".date("F d Y H:i:s.",$info)."<br /><br />";
	
	$info=filegroup($filename);
	echo "File <b>$filename </b> is part of group $info<br /><br />";
	
	$info=fileowner($filename);
	echo "File owner of <b>$filename </b> is $info<br /><br />";
	
	$info=fileperms($filename);
	echo "Permissions of <b>$filename </b> is $info<br /><br />";
	
	
} else {
    echo "The file <b>$filename</b> does not exist<br /><br />";}
	
?>
  </body>
</html>
