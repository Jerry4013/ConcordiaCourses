<!DOCTYPE html>
<html lang="en">
<head> 
  <meta charset="utf-8"/>
  <title>Processing a Simple Form</title> 
</head>

<?php  
// Handling data from Form
//=========================
// Initialize variables from form
$name = $_POST['name'];
$favcolor = $_POST['favcolor'];
$yearborn = $_POST['yearborn'];

// Make background persons favorite color
print("<body bgcolor=$favcolor>");

// Print the person's name in a message
print("Hello $name<br>");

// Get the current date and store it in $currentdate, an array
// Retrieve the year from the $currentdate array and store it in
// a variable called $year, this will be used in calculating the age
$currentdate = getdate();
$year = $currentdate["year"]; 

// Calculate age using the $yearborn field from the submitted form
$age = $year - $yearborn;

// Print the person's age
print("You are $age years old<br />");

// Writing data to a file
// ======================
// The next line opens a file handle to a file called output.txt
// the file handle is like an alias to the file, the a in the fopen function 
// means append so entries will be appended to the output.txt file

$out = fopen("output.txt", "a");
 
// if the file could not be opened for whatever reason, print 
// an error message and exit the program

if (!$out) {
    print("Could not append to file<br />");
    exit;
}
// fputs writes output to a file.  the syntax is where to write
// followed by what to write

// $name is the contents of the name field in the sample form
// \t represents a tab character and \n represents a new line

fputs($out,"$_POST[name]\t");
fputs($out,"$_POST[yearborn]\t");
fputs($out,"$_POST[favcolor]\n");
print("<br />Thanks you for completing our survey.");
fclose($out);

// Reading data from a file
// =========================
// The following statement opens the files called output.txt
// and reads each line of the file into an array called $readfile

// Each line will be accessed by it's position in the array
// $readfile[0] would be the first line because the array begins at 0
// rather than 1
$readfile = file("output.txt");

// Create a loop that will read all elements of the array and print out
// each field of the tab-delimited text file
   print("<br />Here is the content of the file:<br />");
for ($k=0; $k<=count($readfile)-1; $k++) {
    $fields = preg_split("/\t/",$readfile[$k]);
    print("$fields[0] $fields[1] $fields[2]<br>");
}
// readfile with file_get_contents
print("<br />Second look at file content<br />");
print_r(file_get_contents("output.txt"));
?>
</body>
</html>
