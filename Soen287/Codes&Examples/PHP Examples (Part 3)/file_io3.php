<!DOCTYPE html>
<html lang="en">
  <head> 
    <meta charset="utf-8"/>
  </head>
  <body>
	<h1> File I/O - Manipulation</h1>
<?php
$filename = 'file_io.txt';

if (file_exists($filename)) {
    echo "The file <b>$filename</b> exists<br /><br />Content of file with file_get_content function:<br />";
	$str= file_get_contents("$filename");
	echo $str;
	echo "<br /><br />Content of file with file() function <br />";
	$lines = file("$filename");
	foreach ($lines as $line_num => $line) {
    echo "Line #<b>{$line_num}</b> : " . $line . "<br />";}
/*	
	// make a copy of the file
	$newfile = "copy.txt";
	
	echo "<br />Before making a copy of $filename checking whether <b>$newfile</b> exists<br />";
	if (file_exists($newfile)) {
    echo "The file <b>$newfile</b> already exists<br />";}
	else{
	echo "The file <b>$newfile</b> does not exist<br />";}
	
	//Make a copy
    if (copy($filename, $newfile)) {
	echo "file <b>$filename</b> successfully copied to <b>$newfile</b></b>";}
	else
    {echo "failed to copy <b>$filename</b>...\n";} 

	// Delete copy
	if(unlink($newfile)) {
	echo " <br />Deleted file <b>$newfile</b><br />";}
*/	
} else {
    echo "The file <b>$filename</b> does not exist<br />";
}
?>
	</body>
</html>
