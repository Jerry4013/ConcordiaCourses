<!DOCTYPE html>
<html lang="en">
  <head> 
    <meta charset="utf-8"/>
  </head>
  <body>
	<h1> File I/O - File tests</h1>
<?php
$name = "file_io.txt";
//$name = "somefile.txt";  // file that does not exist
//$name="A3Q3.exe"; // executable file
//$name="..";  // parent directory

if (file_exists($name)) {
    echo "The file <b>$name</b> exists<br /><br />";

	$size=filesize($name);	
	echo "Size of <b>$name </b> is $size in bytes<br /><br />";
	
	if 	(is_readable($name)){
		echo "<b>$name</b> is readable<br /><br />";
	} else {
		echo "<b>$name </b> is not readable<br /><br />";}
		
	if 	(is_writable($name)){
		echo "<b>$name</b> is writable<br /><br />";
	} else {
		echo "<b>$name </b> is not writable<br /><br />";}
}else{
    echo "The file <b>$name</b> does not exist<br /><br />";}
 
if 	(is_dir($name)){
    echo "<b>$name</b> is a directory<br /><br />";
} else {
    echo "<b>$name </b> is not a directory<br /><br />";}
	
if 	(is_file($name)){
    echo "<b>$name</b> is a file<br /><br />";
} else {
    echo "<b>$name </b> is not a file<br /><br />";}
	
if 	(is_executable($name)){
    echo "<b>$name</b> is executable<br /><br />";
} else {
    echo "<b>$name </b> is not executable<br /><br />";}		
?>
	</body>
</html>
