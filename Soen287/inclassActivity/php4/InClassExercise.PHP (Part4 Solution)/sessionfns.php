<?php /////   sessionfns.php    /////
// functions you call after session_start();

function session_end()    // ends current session
{  $_SESSION = array();   // empties session state
   if (isset($_COOKIE["PHPSESSID"]))  // cancels sessionid cookie
   { setcookie("PHPSESSID", '', time()-3600, '/'); }
   session_destroy();     // release all session resources
}

// ends current session and starts a new one
?>
