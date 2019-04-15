<?php 
   $title="A Warm Welcome";
   if (  empty($_POST['client_name']) ||
         empty($_POST['client_email']) )
   { $error=TRUE;
     $title="Please Go Back";
   } 
?>
<!DOCTYPE html>
<html lang="en">
  <head><meta charset="utf-8"/>
  <title><?php echo $title; ?></title></head>
  <body>
    <h1><?php echo $title; ?></h1>
   <?php if ( isset($error) ) {?>
     <p>Sorry, the form is incomplete.</p>
     <p>Please go back and fill out all the required entries.  Thank you.</p>
   <?php } else { ?>
     <p>Hello 
     <?php echo $_POST['client_name']; ?>
     , it is our great pleasure to welcome you to our site.</p>
     <p>We have your email address, 
    <?php echo $_POST['client_email']; ?>,
          and we will contact you shortly.</p>
    <?php } ?>
</body></html>
